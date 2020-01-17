package fr.insa.drim.schieder.etherdemo.hellosmartworld;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class Mirrorcontract extends Contract {
    private static final String BINARY = "608060405260008054600160a060020a031916331790556101a1806100256000396000f30060806040526004361061004b5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166341c0e1b58114610050578063c1ce53fc14610067575b600080fd5b34801561005c57600080fd5b50610065610135565b005b34801561007357600080fd5b506040805160206004803580820135601f81018490048402850184019095528484526100c09436949293602493928401919081908401838280828437509497506101729650505050505050565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100fa5781810151838201526020016100e2565b50505050905090810190601f1680156101275780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b60005473ffffffffffffffffffffffffffffffffffffffff163314156101705760005473ffffffffffffffffffffffffffffffffffffffff16ff5b565b905600a165627a7a72305820054bd84cd38bb136c215ab219066a32f5305eda29b2dd50f2062ea1f1bff72740029";

    public static final String FUNC_KILL = "kill";

    public static final String FUNC_REFLECT = "reflect";

    protected Mirrorcontract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Mirrorcontract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<TransactionReceipt> kill() {
        final Function function = new Function(
                FUNC_KILL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> reflect(String _input) {
        final Function function = new Function(FUNC_REFLECT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_input)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<Mirrorcontract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Mirrorcontract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Mirrorcontract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Mirrorcontract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static Mirrorcontract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Mirrorcontract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Mirrorcontract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Mirrorcontract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
