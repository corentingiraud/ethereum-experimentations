package fr.insa.drim.schieder.etherdemo.hellosmartworld;

/**
 * Demo program to deposit and call a smart contract. The used contract simply returns the received input string.
 * Geth must powered up and mining, first:
 geth --datadir="elephantchain" --etherbase '0x5edd062cc2ff7d260be8b93d0a0ac92be4e79da3'  --rpcapi personal,db,eth,net,web3 --rpc --nodiscover --mine --minerthreads=4 console
 * [*] runs the silent miner for an uninvolved third account.
 * [*] operates on the elephant chain
 */
public class Launcher {

    public static void main(String[] args) throws Exception {

        System.out.println("Trying to deposit a smart contract in the blockchain using java and web3j...");

        ContractDeployer deployer = new ContractDeployer();
        Mirrorcontract contract = deployer.transferContract();

        System.out.println("Contract transmitted to blockchain");

        ContractCaller caller = new ContractCaller(contract);
        caller.useContract();

        System.out.println("Interacted with contract in blockchain.");
    }
}
