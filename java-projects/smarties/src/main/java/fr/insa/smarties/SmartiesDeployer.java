package fr.insa.smarties;


import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

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
        private final String LOCATION_SOURCE_ACCOUNT = "/root/.ethereum/chaine1T/keystore/UTC--2020-01-27T16-46-29.621517206Z--79dcbbbe41c3b5a1e5ce9029b30478f1be308d96";

        // Password of the source account
        private final String SOURCE_ACCOUNT_PASSWORD = "root";

        public Smartie transferContract(String addr) throws Exception {
            // Connect to local node
            Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

            // Load credentials for accessing wallet of source account
            Credentials credentials = WalletUtils.loadCredentials(SOURCE_ACCOUNT_PASSWORD, LOCATION_SOURCE_ACCOUNT);

            // Deploy the contract in the blockchain
            return Smartie.deploy(web3, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT, addr).send();
        }
        
        public Smartie getSmartie(String smartieAddress) throws Exception {
            // Connect to local node
            Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

            // Load credentials for accessing wallet of source account
            Credentials credentials = WalletUtils.loadCredentials(SOURCE_ACCOUNT_PASSWORD, LOCATION_SOURCE_ACCOUNT);

            // Deploy the contract in the blockchain
            //return Smartie.deploy(web3, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT).send();
        
           return Smartie.load(smartieAddress, web3, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);
        }
    }
