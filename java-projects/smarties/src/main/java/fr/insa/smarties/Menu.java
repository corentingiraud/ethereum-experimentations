package fr.insa.smarties;

import java.io.Console;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Menu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    private Account _currentAccount;
    
    public Menu() {
        System.out.println(this.ANSI_WHITE_BACKGROUND + this.ANSI_BLACK + "*************** Smarties DAPP: Smart contract for will managment. ***************" + this.ANSI_RESET);
        this.changeAccount();
    }

    public int mainMenu() {
        int choice = 0;
        do {
            System.out.println(this.ANSI_WHITE_BACKGROUND + this.ANSI_BLACK + "******************* SmartiesDApp - Main MENU *******************" + this.ANSI_RESET);
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
            Will will = new Will(amount, heirs, this._currentAccount);
            System.out.println("Will address: " + will.getAddress());
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
            System.out.println(ANSI_RED + "Error : percentage must be an integer between 0 and 100 " + ANSI_RESET );
            System.out.println("Percentage :");
            scanner = new Scanner(System.in);
            heirPercentage = scanner.nextInt();
        }
        return new Heir(heirAddress, heirPercentage);
    }

    private int editWill() {
        Will will = this.askWillAddress();

        int choice = 0;

        do {
            System.out.println("1- Add wei to will");
            System.out.println("2- Remove wei from will");
            System.out.println("0- Exit");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Choose an amount to add :");
                    scanner = new Scanner(System.in);
                    int amount = scanner.nextInt();
                    try {
                        will.addWeiToInheritance(amount);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Exception raised during account addWeiToInheritance. Please try again");
                        return 0;
                    }
                    break;
                case 2:
                    System.out.println("Choose a amount to remove :");
                    scanner = new Scanner(System.in);
                    amount = scanner.nextInt();
                    try {
                        will.removeWeiFromInheritance(amount);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Exception raised during account removeWeiFromInheritance. Please try again");
                        return 0;
                    }
                    break;
                default:
                    break;
            }

        } while (choice != 0);
        
        return 0;
    }

    private int declareDead() {
        try {
            Will will = this.askWillAddress();
            will.declareDead(); 
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception raised during account askWillAddress. Please try again");
        }
        return 0;
    }

    private int claimInheritance() {
        try {
            Will will = this.askWillAddress();
            will.claimInheritance();   
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception raised during account claimInheritance. Please try again");
        }
        return 0;
    }

    private int showAccountBalance() {
        try {
            System.out.println(this._currentAccount.getBalance());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception raised during account getBalance. Please try again");
        }
        return 0;
    }

    private int showWillBalance() {
        Will will = this.askWillAddress();
        try {
            System.out.println(will.getBalance());
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
