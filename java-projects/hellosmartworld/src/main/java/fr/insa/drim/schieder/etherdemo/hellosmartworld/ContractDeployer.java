package fr.insa.drim.schieder.etherdemo.hellosmartworld;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

/**
 * Demo program to deposit a helloworld smart contract in the blockchain using geth via web3j access.
 * Geth must powered up and mining, first:
 geth --datadir="elephantchain" --etherbase '0x5edd062cc2ff7d260be8b93d0a0ac92be4e79da3'  --rpcapi personal,db,eth,net,web3 --rpc --nodiscover --mine --minerthreads=4 console
 * [*] runs the silent miner for an uninvolved third account.
 * [*] operates on the elephant chain
 */
class ContractDeployer
{
    // Path to ethereum base dir (This account will be debited)
    private final String LOCATION_SOURCE_ACCOUNT = "/root/.ethereum/chaine1T/keystore/UTC--2020-01-17T14-27-18.328984619Z--a319c6e3b1b67034011dc77c23b6cfde29290d76";

    // Password of the source account
    private final String SOURCE_ACCOUNT_PASSWORD = "coco";

    public Mirrorcontract transferContract() throws Exception {

        // Connect to local node
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        // Load credentials for accessing wallet of source account
        Credentials credentials = WalletUtils.loadCredentials(SOURCE_ACCOUNT_PASSWORD, LOCATION_SOURCE_ACCOUNT);

        // Deploy the contract in the blockchain
        return Mirrorcontract.deploy(web3, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT).send();
    }
}
