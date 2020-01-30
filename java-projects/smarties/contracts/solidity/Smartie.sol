pragma solidity 0.4.25;
// pragma experimental ABIEncoderV2;

contract smartie {
    struct Heir {
        address addr;
        uint percentage;
    }

    address owner;
    Heir[] public heirs;
    address[] heirsThatDeclaredDead;
    uint countClaimPercentage;
    uint256 inheritanceValue;
    bool public isDead;
    uint public deathDate;

    event LogCoinsSent(address sentTo, uint amount);
    event LogDeath(bool isDead, uint nbOfValid);

    constructor(address[] memory _heirsAddr, uint[] memory _heirsPercentage) public payable {
        require(msg.value > 1, 'Not enough wei added to contract');
        // Check if the owner declares one or more heir(s)
        uint addrLength = _heirsAddr.length;
        uint percLength = _heirsPercentage.length;
        assert(addrLength > 0 && percLength > 0 && addrLength == percLength);

        // Check if the owner declares a total percentage equal to 100%
        uint totalPercentage = 0;
        for (uint i = 0; i < percLength; i++){
            // Check duplicates in heirs
            for (uint j = 0; j < heirs.length; j++){
                require(heirs[j].addr != _heirsAddr[i], 'Error, the heir has already been declared in the will');
            }
            Heir memory heir = Heir(_heirsAddr[i],_heirsPercentage[i]);
            heirs.push(heir);
            totalPercentage += _heirsPercentage[i];
        }
        require(totalPercentage == 100, 'Total percentage not equal to 100');
        owner = msg.sender;
        isDead = false;
        countClaimPercentage = 0;
        // Set funds
        inheritanceValue = msg.value;
    }

    function declareDead() public returns (string memory) {
        // Check duplicate declarations
        for (uint k = 0; k < heirsThatDeclaredDead.length; k++){
            require(heirsThatDeclaredDead[k] != msg.sender, 'Error, the heir has already declared the owner dead');
        }
        for (uint i = 0; i < heirs.length; i++){
            // Check if heir is legitimate
            if(heirs[i].addr == msg.sender) {
                countClaimPercentage += heirs[i].percentage;
                heirsThatDeclaredDead.push(heirs[i].addr);
                if (countClaimPercentage >= 80) {
                    isDead = true;
                    deathDate = block.timestamp;
                    return 'The owner is officially declared dead, a 7 days latency is needed to claim the will';
                }
                return 'The heir officially declared the owner dead. Other heirs will need to declare the owner dead.';
            }
        }
    } 

    function claimWill() public {
        require(isDead, 'The owner is not officially dead. Heirs representing at least 80% of the inheritance need to declare the owner dead');
        require((deathDate) <= block.timestamp, 'The latency needed for the will to be claimed is not yet reached, you will have to wait');
        executeContract();
    }

    function addWeiToInheritance() public payable returns(uint256) {
        require(msg.sender == owner, 'Only the owner of the contract can add ether');
        require(msg.value >= 1, 'Not enough wei provided');
        inheritanceValue += msg.value;
        return address(this).balance;
    }

    function removeWeiFromInheritance(uint256 valueToSubstract) public returns(uint256){
        require(msg.sender == owner, 'Only the owner of the contract can add ether');
        require(inheritanceValue >= valueToSubstract, 'Not enough wei in the contract');
        inheritanceValue -= valueToSubstract;
        owner.transfer(valueToSubstract);
        return address(this).balance;
    }

    function displayInheritence() public view returns (uint){
        return address(this).balance;
    }

    function deleteContract() public {
        if (msg.sender == owner) {
            selfdestruct(owner);
        }
    }

    function executeContract() public {
        uint amount;
        for (uint i = 0; i < heirs.length; i++) {
            amount = inheritanceValue * heirs[i].percentage;
            amount = amount / 100;
            heirs[i].addr.transfer(amount);
            emit LogCoinsSent(heirs[i].addr, amount);
        }
        selfdestruct(owner);
    }

    function getAddress() public view returns(address) {
        return address(this);
    }

    function getNumberOfHeirsThatClaimedWill() public view returns(uint) {
        return heirsThatDeclaredDead.length;
    }

    function getHeirsNumber() public view returns(uint) {
        return heirs.length;
    }

    function getOwner() public view returns(address) {
        return owner;
    }
}
