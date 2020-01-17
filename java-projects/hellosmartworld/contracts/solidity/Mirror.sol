pragma solidity ^0.4.17;
    contract mortal {
        address owner;
        constructor() public { owner = msg.sender; }
        function kill() public { if (msg.sender == owner) selfdestruct(owner); }
    }

    contract mirrorcontract is mortal {

    // mini-function that simply returns the input argument back to caller
    function reflect(string _input) public pure returns (string) {
	    return _input;
	}
}  
