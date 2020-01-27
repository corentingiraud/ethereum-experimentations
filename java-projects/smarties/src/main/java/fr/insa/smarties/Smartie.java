package fr.insa.smarties;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
public class Smartie extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506040516101af3803806101af8339818101604052602081101561003357600080fd5b5051600080546001600160a01b03199081163317909155600180546001600160a01b03909316929091169190911790556003805460ff191690556101338061007c6000396000f3fe6080604052348015600f57600080fd5b506004361060465760003560e01c8063210879f414604b57806391f2ebb814605357806398246e2614607c57806399baa10c146082575b600080fd5b6051609c565b005b605960be565b604080516001600160a01b03909316835260208301919091528051918290030190f35b605160d3565b608860f4565b604080519115158252519081900360200190f35b6000546001600160a01b031633141560bc576000546001600160a01b0316ff5b565b6001546002546001600160a01b039091169082565b6001546001600160a01b031633141560bc576003805460ff19166001179055565b60035460ff168156fea2646970667358221220593adf544420e578a923a306218b955cf279d463f8495c7289831e67e54b180d64736f6c63430006010033";

    public static final String FUNC_DELETEWILL = "deleteWill";

    public static final String FUNC_HEIR = "heir";

    public static final String FUNC_ISDEAD = "isDead";

    public static final String FUNC_ISDEADSAMERE = "isDeadSaMere";

    protected Smartie(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Smartie(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RemoteCall<Smartie> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _address) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_address)));
        return deployRemoteCall(Smartie.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Smartie> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _address) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_address)));
        return deployRemoteCall(Smartie.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public RemoteCall<TransactionReceipt> deleteWill() {
        final Function function = new Function(
                FUNC_DELETEWILL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> heir() {
        final Function function = new Function(
                FUNC_HEIR, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> isDead() {
        final Function function = new Function(
                FUNC_ISDEAD, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> isDeadSaMere() {
        final Function function = new Function(
                FUNC_ISDEADSAMERE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static Smartie load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Smartie(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Smartie load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Smartie(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
