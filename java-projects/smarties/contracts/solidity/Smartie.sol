pragma solidity ^0.6.1;

contract smartie {
    struct Heir {
        address addr;
        uint percentage;
    }

    address payable owner;
    Heir public heir;
    bool public isDead;

    constructor(address _address) public {
        owner = msg.sender;
        heir.addr = _address;
        isDead = false;
    }

    function isDeadSaMere() public {
        if (msg.sender == heir.addr) {
            isDead = true;
        }
    }

    function deleteWill() public {
        if (msg.sender == owner) {
            selfdestruct(owner);
        }
    }
}
