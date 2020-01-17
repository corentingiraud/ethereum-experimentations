package fr.insa.drim.schieder.etherdemo.transfere;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

/**
 * This class handles the actual ether transfer (connects to geth via the web3j library)
 */
class EtherShifter
{
    // Path to ethereum base dir (This account will be debited)
    private final String LOCATION_SOURCE_ACCOUNT = "/Users/maex/Library/Ethereum/elephantchain/keystore/UTC--2018-09-24T11-36-11.487115201Z--3c7b081d3e608525a2efb821e80d597cef7a435c";

    // Password of the source account
    private final String SOURCE_ACCOUNT_PASSWORD = "coco";

    // Account to sent the ethers to
    private final String TARGET_ACCOUNT = "0xd929a310108ea93d2d82df4a74763ed1316f94fb";

    // Amount of ether to send in transaction
    private final int AMOUNT = 42;

    public void transferEther() throws IOException, CipherException, TransactionException, InterruptedException, ExecutionException {

        // Connect to local node
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        // Load credentials for accessing wallet of source account
        Credentials credentialsWallet1 = WalletUtils.loadCredentials(SOURCE_ACCOUNT_PASSWORD, LOCATION_SOURCE_ACCOUNT);

        // Transfer specified amount of ether to target account
        Transfer.sendFunds(web3, credentialsWallet1, TARGET_ACCOUNT, BigDecimal.valueOf(AMOUNT), Convert.Unit.ETHER).sendAsync().get();
    }
}
