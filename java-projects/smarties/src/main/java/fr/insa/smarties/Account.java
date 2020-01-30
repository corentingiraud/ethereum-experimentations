package fr.insa.smarties;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.crypto.CipherException;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Account {
    private String _address;
    private Credentials _credentials;

    public Account(String accountPath, String password) throws IOException, CipherException {
        this._credentials = WalletUtils.loadCredentials(password, accountPath);
        this._address = this._credentials.getAddress();
    }

    public String getBalance() throws InterruptedException, ExecutionException {
        EthGetBalance balanceWei = Launcher.web3
            .ethGetBalance(this._address, DefaultBlockParameterName.LATEST)
            .sendAsync()
            .get();
        BigDecimal balanceInEther = Convert.fromWei(balanceWei.getBalance().toString(), Convert.Unit.ETHER);
        return balanceInEther.toString();  
    }

    public String getAddress() {
        return this._address;
    }

    public Credentials getCredentials() { 
        return this._credentials;
    }
}
