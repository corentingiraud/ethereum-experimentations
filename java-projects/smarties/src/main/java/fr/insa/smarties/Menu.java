package fr.insa.smarties;

import java.io.Console;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional; 
import java.util.Arrays;
import org.web3j.abi.TypeReference;
import org.web3j.abi.FunctionEncoder;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.abi.datatypes.Utf8String;

class Menu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    private Account _currentAccount;
    private Will _currentWill;
    
    public Menu() {
        System.out.println(this.ANSI_WHITE_BACKGROUND + this.ANSI_BLACK + "*************** Smarties DAPP: Smart contract for will managment. ***************" + this.ANSI_RESET);
        this.changeAccount();
        this._currentWill = this.askWillAddress();
    }

    public int mainMenu() {
        int choice = 0;
        do {
            System.out.println();
            System.out.println(this.ANSI_WHITE_BACKGROUND + this.ANSI_BLACK + "******************* SmartiesDApp - Main MENU *******************" + this.ANSI_RESET);
            try {
                System.out.println("Current account : " + this._currentAccount.getAddress());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception raised during account initialization. Please try again");
            }
            if (this._currentWill != null) {
                try {
                    System.out.println("Current will : " + this._currentWill.getAddress());
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Exception raised during will initialization. Please try again");
                }
            } else {
                System.out.println("No current will");
            }
            System.out.println();
            System.out.println("1- Load another ethereum account");
            System.out.println("2- Write a new will");
            System.out.println("3- Edit a will");
            System.out.println("4- Declare death");
            System.out.println("5- Claim inheritance");
            System.out.println("6- Show my account balance");
            System.out.println("7- Show will balance");
            System.out.println("0- Exit");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    this.changeAccount();
                    break;
                case 2:
                    this.writeWill();
                    break;
                case 3:
                    this.editWill();
                    break;
                case 4:
                    this.declareDead();
                    break;
                case 5:
                    this.claimInheritance();
                    break;
                case 6:
                    this.showAccountBalance();
                    break;
                case 7:
                    this.showWillBalance();
                    break;
                default:
                    break;
            }

        } while (choice != 0);
        return 0;
        
    }

    private int changeAccount() {
        // Absolute path
        System.out.println("Account absolute path :");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        // Password
        Console console = System.console();
        String password = new String(console.readPassword("Password :"));

        try {
            this._currentAccount = new Account(path, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception raised during account initialization. Please try again");
        } finally {
            return 0;
        }
    }

    private int writeWill(){
        System.out.println("Amount of Ether of your will :");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        
        System.out.println("Number of heirs you wish to declare :");
        scanner = new Scanner(System.in);
        int numberOfHeir = scanner.nextInt();

        List<Heir> heirs = new ArrayList<Heir>();

        for (int i = 0; i < numberOfHeir; i++) {
            System.out.println("*************** Heir n" + (i + 1));
            heirs.add(this.createHeir());
        }

        try {
            System.out.println(ANSI_GREEN + "Calling smart contract function in the blockchain..." + ANSI_RESET);
            Will will = new Will(amount, heirs, this._currentAccount);
            System.out.println("Will address: " + will.getAddress());
            this._currentWill = will;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception raised during account initialization. Please try again");
        } finally {
            return 0;
        }
    }

    private Heir createHeir() {
        System.out.println("Address :");
        Scanner scanner = new Scanner(System.in);
        String heirAddress = scanner.nextLine();
        System.out.println("Percentage :");
        scanner = new Scanner(System.in);
        int heirPercentage = scanner.nextInt();
        while(heirPercentage > 100 || heirPercentage < 0 ) {
            System.out.println(ANSI_RED + "Error : percentage must be an integer between 0 and 100 " + ANSI_RESET);
            System.out.println("Percentage :");
            scanner = new Scanner(System.in);
            heirPercentage = scanner.nextInt();
        }
        return new Heir(heirAddress, heirPercentage);
    }

    private int editWill() {
        int choice = 0;

        do {
            System.out.println("1- Add ether to will");
            System.out.println("2- Remove ether from will");
            System.out.println("3- Show will balance");
            System.out.println("0- Exit");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Choose an amount to add :");
                    scanner = new Scanner(System.in);
                    int amount = scanner.nextInt();
                    try {
                        System.out.println(ANSI_GREEN + "Calling smart contract function in the blockchain..." + ANSI_RESET);
                        this._currentWill.addEthToInheritance(amount);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Exception raised during account addEtherToInheritance. Please try again");
                        return 0;
                    }
                    break;
                case 2:
                    System.out.println("Choose a amount to remove :");
                    scanner = new Scanner(System.in);
                    amount = scanner.nextInt();
                    try {
                        System.out.println(ANSI_GREEN + "Calling smart contract function in the blockchain..." + ANSI_RESET);
                        this._currentWill.removeEthFromInheritance(amount);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Exception raised during account removeEtherFromInheritance. Please try again");
                        return 0;
                    }
                    break;
                case 3:
                    this.showWillBalance();
                    break;
                default:
                    break;
            }

        } while (choice != 0);
        
        return 0;
    }

    private int declareDead() {
        try {
            System.out.println(ANSI_GREEN + "Calling smart contract function in the blockchain..." + ANSI_RESET);
            this._currentWill.declareDead();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception raised during account askWillAddress. Please try again");
        }
        return 0;
    }

    private int claimInheritance() {
        try {
            System.out.println(ANSI_GREEN + "Calling smart contract function in the blockchain..." + ANSI_RESET);
            this._currentWill.claimInheritance();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception raised during account claimInheritance. Please try again");
        }
        return 0;
    }

    private int showAccountBalance() {
        try {
            System.out.println(this._currentAccount.getBalance() + " Ether");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception raised during account getBalance. Please try again");
        }
        return 0;
    }

    private int showWillBalance() {
        try {
            System.out.println(this._currentWill.getBalance() + " Ether");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception raised during will getBalance. Please try again");
        }
        return 0;
    }

    private Will askWillAddress() {
        System.out.println("Will address :");
        Scanner scanner = new Scanner(System.in);
        String willAddress = scanner.nextLine();

        return new Will(willAddress, this._currentAccount.getCredentials());
    }
}
