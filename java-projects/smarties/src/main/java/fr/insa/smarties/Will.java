package fr.insa.smarties;

import org.web3j.crypto.Credentials;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.utils.Convert;

import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.math.BigDecimal;

public class Will {
    private String _address;
    private Account _owner;
    private Smartie _contract;
    private List<Heir> _heirs;

    public Will(int ethValue, List<Heir> heirs, Account owner) throws Exception {
        this._heirs = heirs;
        this._owner = owner;

        // Create array of addresses and percentages
        List<String> heirAddrs = new ArrayList<>();
        List<BigInteger> heirPercs = new ArrayList<>();
        
        for (int i = 0; i < this._heirs.size(); i++) {
            heirAddrs.add(heirs.get(i).getAddress());
            heirPercs.add(BigInteger.valueOf(heirs.get(i).getPercentage()));
        }
        BigInteger value = BigInteger.valueOf(ethValue).multiply(BigInteger.valueOf(10).pow(18));
        //Deploy contract
        this._contract = Smartie.deploy(
            Launcher.web3,
            this._owner.getCredentials(),
            DefaultGasProvider.GAS_PRICE,
            DefaultGasProvider.GAS_LIMIT,
            value,
            heirAddrs,
            heirPercs)
        .send();

        this._address = this._contract.getAddress().send();
    }

    public Will(String contractAddress, Credentials credentials) {
        this._address = contractAddress;
        // Load contract         load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit)
        this._contract = Smartie.load(contractAddress, Launcher.web3, credentials, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);
    }

    public int addEthToInheritance(int ethToAdd) throws Exception {
        BigInteger value = BigInteger.valueOf(ethToAdd).multiply(BigInteger.valueOf(10).pow(18));
        this._contract.addWeiToInheritance(value).send();
        return 0;
    }

    public int removeEthFromInheritance(int ethToRemove) throws Exception {
        BigInteger value = BigInteger.valueOf(ethToRemove).multiply(BigInteger.valueOf(10).pow(18));
        this._contract.removeWeiFromInheritance(value).send();
        return 0;
    }

    public int declareDead() throws Exception {
        this._contract.declareDead().send();
        return 0;
    }

    public int claimInheritance() throws Exception { 
        this._contract.claimWill().send();
        return 0;
    }

    public int getHeirsNumber() throws Exception {
        return this._contract.getHeirsNumber().send().intValue();
    }

    public int getNumberOfHeirsThatClaimedWill() throws Exception{
        return this._contract.getNumberOfHeirsThatClaimedWill().send().intValue();
    }

    public String getAddress() throws Exception {
        return this._address;
    }

    public String getBalance() throws InterruptedException, ExecutionException {
        EthGetBalance balanceWei = Launcher.web3
            .ethGetBalance(this._address, DefaultBlockParameterName.LATEST)
            .sendAsync()
            .get();     
        BigDecimal balanceInEther = Convert.fromWei(balanceWei.getBalance().toString(), Convert.Unit.ETHER);
        return balanceInEther.toString();  
    }
}
