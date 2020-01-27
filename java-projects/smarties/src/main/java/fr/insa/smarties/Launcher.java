package fr.insa.smarties;

import java.util.Scanner;

/**
 * Demo program to deposit and call a smart contract. The used contract simply returns the received input string. Geth
 * must powered up and mining, first:
 geth --datadir="elephantchain" --rpcapi personal,db,eth,net,web3 --rpc --nodiscover --mine --minerthreads=4 console
 [*] runs the silent miner for
 * an uninvolved third account. [*] operates on the elephant chain
 */
public class Launcher {

    public static void main(String[] args) throws Exception {

        //check if deploy contract or call function on existing contract
        System.out.println("Do you want to add a contract to blockchain ? y/n");
        //Block program until enter key was hit.
        Scanner scanner = new Scanner(System.in);
        String decision = scanner.nextLine();
        SmartiesDeployer deployer = new SmartiesDeployer();

        if(decision.equals("y")) {
            System.out.println("Smart contract parameters...");
            System.out.println("Please enter the public ethereum address of your heir...");
            scanner = new Scanner(System.in);
            String addr = scanner.nextLine();
            System.out.println("Trying to deposit a smart contract in the blockchain using java and web3j...");
            Smartie smartie = deployer.transferContract(addr);
            System.out.println("Contract transmitted to blockchain with address: " + smartie.getContractAddress());
        } else if (decision.equals("n")){
            System.out.println("Calling function on existing contract");
            System.out.println("Who do you want to declare dead ? contract adress :");
            //Block program until enter key was hit.
            scanner = new Scanner(System.in);
            String smartieAddress = scanner.nextLine();
            Smartie smartie = deployer.getSmartie(smartieAddress);
            smartie.isDeadSaMere().send();
            System.out.println("le gars est dead sa mere");

        } else {
            System.out.println("Wrong input, bisous");
        }
    }
}
