package fr.insa.smarties;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;
import java.io.Console;
import java.math.BigInteger;
import java.util.*;

/**
 * Demo program to deposit a helloworld smart contract in the blockchain using geth via web3j access.
 * Geth must powered up and mining, first:
 geth --datadir="elephantchain" --rpcapi personal,db,eth,net,web3 --rpc --nodiscover --mine --minerthreads=4 console
 * [*] runs the silent miner for an uninvolved third account.
 * [*] operates on the elephant chain
 */
public class SmartiesDeployer
    {
        // Path to ethereum base dir (This account will be debited)
        // private String LOCATION_SOURCE_ACCOUNT = "/root/.ethereum/chaine1T/keystore/UTC--2020-01-27T14-18-03.069304925Z--e087b47782c968bc3e31a3b1d9196af833501260";

        // // Password of the source account
        // private String SOURCE_ACCOUNT_PASSWORD = "root";

        // public Smartie transferContract(Heir[] heirs, BigInteger weiValue) throws Exception {
        //     // Connect to local node
        //     Web3j web3 = Web3j.build(new HttpService()); // defaults to http://localhost:8545/

        //     // Load credentials for accessing wallet of source account
        //     Credentials credentials = WalletUtils.loadCredentials(SOURCE_ACCOUNT_PASSWORD, LOCATION_SOURCE_ACCOUNT);

        //     // Deploy the contract in the blockchain
        //     List<String> heirAddrs = new ArrayList<>();
        //     List<BigInteger> heirPercs = new ArrayList<>();
        //     for (int i = 0; i < heirs.length; i++) {
        //         heirAddrs.add(heirs[i].getAddress());
        //         heirPercs.add(heirs[i].getPercentage());
        //     }

        //     return Smartie.deploy(
        //         web3,
        //         credentials,
        //         DefaultGasProvider.GAS_PRICE,
        //         DefaultGasProvider.GAS_LIMIT,
        //         weiValue,
        //         heirAddrs,
        //         heirPercs)
        //     .send();
        // }
        
        // public Smartie getSmartie(String smartieAddress) throws Exception {
        //     // Connect to local node
        //     Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        //     // Load credentials for accessing wallet of source account
        //     Credentials credentials = WalletUtils.loadCredentials(SOURCE_ACCOUNT_PASSWORD, LOCATION_SOURCE_ACCOUNT);

        //     // Deploy the contract in the blockchain
        //     //return Smartie.deploy(web3, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT).send();
        
        //    return Smartie.load(smartieAddress, web3, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);
        // }

        // public SmartiesDeployer (String loctionSourceAccount ) {
        //     this.LOCATION_SOURCE_ACCOUNT = locationSourceAccount;
        //     Console console = System.console();
        //     System.out.println("Please enter your Ethereum account password :");
        //     this.SOURCE_ACCOUNT_PASSWORD = new String(console.readPassword("Password:"));
        // }
    }
