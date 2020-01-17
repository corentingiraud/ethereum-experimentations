package fr.insa.drim.schieder.etherdemo.hellosmartworld;

public class ContractCaller {

    private Mirrorcontract contract;

    public ContractCaller(Mirrorcontract contract) {
        this.contract = contract;
    }

    public void useContract() throws Exception {
        String input = "Hello, smart-world!";
        String output = contract.reflect(input).send();
        System.out.println("Called Smart Contract and got reply: "+output);
    }
}
