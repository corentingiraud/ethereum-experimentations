package fr.insa.smarties;

import java.util.Scanner;
import java.math.BigInteger;
import java.lang.*;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

/**
 * Demo program to deposit and call a smart contract. The used contract simply returns the received input string. Geth
 * must powered up and mining, first:
 geth --datadir="elephantchain" --rpcapi personal,db,eth,net,web3 --rpc --nodiscover --mine --minerthreads=4 console
 [*] runs the silent miner for
 * an uninvolved third account. [*] operates on the elephant chain
 */
public class Launcher {

    public static Web3j web3 = Web3j.build(new HttpService()); // defaults to http://localhost:8545/

    public static void main(String[] args) throws Exception {

        Menu menu = new Menu();
        menu.mainMenu();

        // SmartiesDeployer deployer = new SmartiesDeployer(args[0]);

        // //check if deploy contract or call function on existing contract
        // System.out.println("Do you want to add a contract to the blockchain ? y/n/stop");
        // //Block program until enter key was hit.
        // Scanner scanner = new Scanner(System.in);
        // String decision = scanner.nextLine();
        // do{
        //     if(decision.equals("y")) {
        //         System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "*************** Smart contract parameters ***************" + ANSI_RESET);
        //         System.out.println("Please enter the amount of Ether to attach to the contract...");
        //         scanner = new Scanner(System.in);
        //         int ethValue = scanner.nextInt();
        //         BigInteger weiValue = BigInteger.valueOf(ethValue).pow(18);
        //         System.out.println("Please enter the number of heirs you wish to declare :");
        //         scanner = new Scanner(System.in);
        //         int numberOfHeir = scanner.nextInt();
        //         Heir[] heirs = new Heir[numberOfHeir];
        //         int i = 0;
        //         while (i < numberOfHeir){
        //             heirs[i] = createHeir();
        //             i++;
        //         }
        //         System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "******** End of Smart contract parameters ********" + ANSI_RESET);
        //         System.out.println("Trying to deposit a smart contract in the blockchain using java and web3j...");
        //         Smartie smartie = deployer.transferContract(heirs, weiValue);
        //         System.out.println("Contract transmitted to blockchain with address: " + ANSI_GREEN + smartie.getContractAddress() + ANSI_RESET);
        //     } else if (decision.equals("n")){
        //         System.out.println("Calling function on existing contract...");
        //         System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "***** Deceased person declaration *****" + ANSI_RESET);
        //         System.out.println("Who do you want to declare deceased ? Please enter the contract address :");
        //         //Block program until enter key was hit.
        //         scanner = new Scanner(System.in);
        //         String smartieAddress = scanner.nextLine();
        //         if (!smartieAddress.matches("0[xX][0-9a-fA-F]{40}")) {
        //             System.out.println(ANSI_RED + "The typed format does not match a contract address" + ANSI_RESET);
        //         } else {
        //             try {
        //                 Smartie smartie = deployer.getSmartie(smartieAddress);
        //                 String res = smartie.declareDead().send().toString();
        //                 System.out.println("Deceased person declaration received");
        //                 System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK + "****** End of Deceased person declaration ******" + ANSI_RESET);
        //             } catch (Exception e) {
        //                 System.out.println(ANSI_RED + "Error : Solidity exception caught :" + e + ANSI_RESET);
        //             }
        //         }
        //     } else {
        //         System.out.println(ANSI_RED + "Error : Wrong input, please try again" + ANSI_RESET);
        //     }

        //     System.out.println("Do you want to add a contract to the blockchain ? y/n/stop");
        //     scanner = new Scanner(System.in);
        //     decision = scanner.nextLine();
        // }while (!decision.equals("stop"));
    }
}
