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
    private final String LOCATION_SOURCE_ACCOUNT = "/Users/maex/Library/Ethereum/elephantchain/keystore/UTC--2018-09-24T11-36-11.487115201Z--3c7b081d3e608525a2efb821e80d597cef7a435c";

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
