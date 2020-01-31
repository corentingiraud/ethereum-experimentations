package fr.insa.smarties;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple2;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

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
    private static final String BINARY = "6080604052604051610e81380380610e818339810160405280516020820151908201910160008080808061003161039f565b600134116100a057604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820181905260248201527f4e6f7420656e6f7567682077656920616464656420746f20636f6e7472616374604482015290519081900360640190fd5b87519550865194506000861180156100b85750600085115b80156100c357508486145b15156100cb57fe5b60009350600092505b848310156102cd57600091505b6001548210156101d35787838151811015156100f957fe5b90602001906020020151600160a060020a031660018381548110151561011b57fe5b6000918252602090912060029091020154600160a060020a031614156101c857604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152603560248201527f4572726f722c2074686520686569722068617320616c7265616479206265656e60448201527f206465636c6172656420696e207468652077696c6c0000000000000000000000606482015290519081900360840190fd5b6001909101906100e1565b604080519081016040528089858151811015156101ec57fe5b90602001906020020151600160a060020a03168152602001888581518110151561021257fe5b60209081029190910181015190915260018054808201825560009190915282517fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf660029092029182018054600160a060020a031916600160a060020a03909216919091179055908201517fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf79091015587519091508790849081106102b257fe5b906020019060200201518401935082806001019350506100d4565b6064841461036257604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152602160248201527f546f74616c2070657263656e74616765206e6f7420657175616c20746f20313060448201527f3000000000000000000000000000000000000000000000000000000000000000606482015290519081900360840190fd5b505060008054600160a060020a031916331781556005805460ff19908116909155600780549091169055600455505034600255506103b692505050565b604080518082019091526000808252602082015290565b610abc806103c56000396000f3006080604052600436106100da5763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166314fae21881146100df5780631c0795c314610106578063252d3b7b146101415780633641a7b71461014957806338cc48311461016057806357c9ca14146101915780635a58cd4c146101ba5780635eeddcaa146101cf5780636f92e149146101e4578063893d20e81461026e5780638bf3a17c1461028357806399baa10c1461029b578063a9c74a66146102b0578063aedb1c8f146102c5578063c039c432146102da575b600080fd5b3480156100eb57600080fd5b506100f46102ef565b60408051918252519081900360200190f35b34801561011257600080fd5b5061011e6004356102f5565b60408051600160a060020a03909316835260208301919091528051918290030190f35b6100f461032b565b34801561015557600080fd5b5061015e61049e565b005b34801561016c57600080fd5b50610175610537565b60408051600160a060020a039092168252519081900360200190f35b34801561019d57600080fd5b506101a661053b565b604080519115158252519081900360200190f35b3480156101c657600080fd5b5061015e610544565b3480156101db57600080fd5b506100f4610567565b3480156101f057600080fd5b506101f961056d565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561023357818101518382015260200161021b565b50505050905090810190601f1680156102605780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561027a57600080fd5b5061017561082d565b34801561028f57600080fd5b506100f460043561083c565b3480156102a757600080fd5b506101a661096a565b3480156102bc57600080fd5b506100f4610973565b3480156102d157600080fd5b5061015e610978565b3480156102e657600080fd5b506100f4610a8a565b60065481565b600180548290811061030357fe5b600091825260209091206002909102018054600190910154600160a060020a03909116915082565b60075460009060ff16156103af576040805160e560020a62461bcd02815260206004820152602560248201527f43616e2f2774206164642057656920746f206465737472756374656420636f6e60448201527f7472616374000000000000000000000000000000000000000000000000000000606482015290519081900360840190fd5b600054600160a060020a03163314610437576040805160e560020a62461bcd02815260206004820152602c60248201527f4f6e6c7920746865206f776e6572206f662074686520636f6e7472616374206360448201527f616e206164642065746865720000000000000000000000000000000000000000606482015290519081900360840190fd5b6001341015610490576040805160e560020a62461bcd02815260206004820152601760248201527f4e6f7420656e6f756768207765692070726f7669646564000000000000000000604482015290519081900360640190fd5b506002805434019055303190565b60055460ff161515610520576040805160e560020a62461bcd02815260206004820152602a60248201527f546865206f776e6572206973206e6f74206f6666696369616c6c79206465636c60448201527f6172656420646561642e00000000000000000000000000000000000000000000606482015290519081900360840190fd5b610528610978565b6007805460ff19166001179055565b3090565b60075460ff1681565b600054600160a060020a031633141561056557600054600160a060020a0316ff5b565b60035490565b60606000805b60035482101561062a57600380543391908490811061058e57fe5b600091825260209091200154600160a060020a0316141561061f576040805160e560020a62461bcd02815260206004820152603360248201527f4572726f722c2074686520686569722068617320616c7265616479206465636c60448201527f6172656420746865206f776e6572206465616400000000000000000000000000606482015290519081900360840190fd5b600190910190610573565b5060005b60015481101561082857600180543391908390811061064957fe5b6000918252602090912060029091020154600160a060020a0316141561082057600180548290811061067757fe5b600091825260209091206001600290920201810154600480549091019055805460039190839081106106a557fe5b6000918252602080832060029092029091015483546001810185559383529120909101805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03909216919091179055600454605011610796576005805460ff191660011790554260065560408051608081018252605381527f546865206f776e6572206973206f6666696369616c6c79206465636c6172656460208201527f20646561642c206120372064617973206c6174656e6379206973206e65656465918101919091527f6420746f20636c61696d207468652077696c6c0000000000000000000000000060608201529250610828565b608060405190810160405280605d81526020017f5468652068656972206f6666696369616c6c79206465636c617265642074686581526020017f206f776e657220646561642e204f746865722068656972732077696c6c206e6581526020017f656420746f206465636c61726520746865206f776e657220646561642e0000008152509250610828565b60010161062e565b505090565b600054600160a060020a031690565b60008054600160a060020a031633146108c5576040805160e560020a62461bcd02815260206004820152602c60248201527f4f6e6c7920746865206f776e6572206f662074686520636f6e7472616374206360448201527f616e206164642065746865720000000000000000000000000000000000000000606482015290519081900360840190fd5b60025482111561091f576040805160e560020a62461bcd02815260206004820152601e60248201527f4e6f7420656e6f7567682077656920696e2074686520636f6e74726163740000604482015290519081900360640190fd5b60028054839003905560008054604051600160a060020a039091169184156108fc02918591818181858888f19350505050158015610961573d6000803e3d6000fd5b50503031919050565b60055460ff1681565b303190565b6000805b600154811015610a7c57600180548290811061099457fe5b9060005260206000209060020201600101546002540291506064828115156109b857fe5b0491506001818154811015156109ca57fe5b60009182526020822060029091020154604051600160a060020a039091169184156108fc02918591818181858888f19350505050158015610a0f573d6000803e3d6000fd5b507fb9f6cc65b3b9b7dc18152bc517c1783d9a9d5039e42b72918de9bd1a4b40487c600182815481101515610a4057fe5b60009182526020918290206002909102015460408051600160a060020a03909216825291810185905281519081900390910190a160010161097c565b600054600160a060020a0316ff5b600154905600a165627a7a72305820cef1d854d043be9ebcaca46cefc4b169e7c5ab69a9487f515be949f167366deb0029";

    public static final String FUNC_DEATHDATE = "deathDate";

    public static final String FUNC_HEIRS = "heirs";

    public static final String FUNC_ADDWEITOINHERITANCE = "addWeiToInheritance";

    public static final String FUNC_CLAIMWILL = "claimWill";

    public static final String FUNC_GETADDRESS = "getAddress";

    public static final String FUNC_ISCLAIMED = "isClaimed";

    public static final String FUNC_DELETECONTRACT = "deleteContract";

    public static final String FUNC_GETNUMBEROFHEIRSTHATCLAIMEDWILL = "getNumberOfHeirsThatClaimedWill";

    public static final String FUNC_DECLAREDEAD = "declareDead";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_REMOVEWEIFROMINHERITANCE = "removeWeiFromInheritance";

    public static final String FUNC_ISDEAD = "isDead";

    public static final String FUNC_DISPLAYINHERITENCE = "displayInheritence";

    public static final String FUNC_EXECUTECONTRACT = "executeContract";

    public static final String FUNC_GETHEIRSNUMBER = "getHeirsNumber";

    public static final Event LOGCOINSSENT_EVENT = new Event("LogCoinsSent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event LOGDEATH_EVENT = new Event("LogDeath", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
    ;

    protected Smartie(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Smartie(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<BigInteger> deathDate() {
        final Function function = new Function(FUNC_DEATHDATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple2<String, BigInteger>> heirs(BigInteger param0) {
        final Function function = new Function(FUNC_HEIRS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<String, BigInteger>>(
                new Callable<Tuple2<String, BigInteger>>() {
                    @Override
                    public Tuple2<String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> addWeiToInheritance(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_ADDWEITOINHERITANCE, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> claimWill() {
        final Function function = new Function(
                FUNC_CLAIMWILL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getAddress() {
        final Function function = new Function(FUNC_GETADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> isClaimed() {
        final Function function = new Function(FUNC_ISCLAIMED, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> deleteContract() {
        final Function function = new Function(
                FUNC_DELETECONTRACT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getNumberOfHeirsThatClaimedWill() {
        final Function function = new Function(FUNC_GETNUMBEROFHEIRSTHATCLAIMEDWILL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> declareDead() {
        final Function function = new Function(
                FUNC_DECLAREDEAD, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getOwner() {
        final Function function = new Function(FUNC_GETOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> removeWeiFromInheritance(BigInteger valueToSubstract) {
        final Function function = new Function(
                FUNC_REMOVEWEIFROMINHERITANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(valueToSubstract)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> isDead() {
        final Function function = new Function(FUNC_ISDEAD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> displayInheritence() {
        final Function function = new Function(FUNC_DISPLAYINHERITENCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> executeContract() {
        final Function function = new Function(
                FUNC_EXECUTECONTRACT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getHeirsNumber() {
        final Function function = new Function(FUNC_GETHEIRSNUMBER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<Smartie> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, List<String> _heirsAddr, List<BigInteger> _heirsPercentage) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.Utils.typeMap(_heirsAddr, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_heirsPercentage, org.web3j.abi.datatypes.generated.Uint256.class))));
        return deployRemoteCall(Smartie.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static RemoteCall<Smartie> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, List<String> _heirsAddr, List<BigInteger> _heirsPercentage) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.Utils.typeMap(_heirsAddr, org.web3j.abi.datatypes.Address.class)), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_heirsPercentage, org.web3j.abi.datatypes.generated.Uint256.class))));
        return deployRemoteCall(Smartie.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public List<LogCoinsSentEventResponse> getLogCoinsSentEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGCOINSSENT_EVENT, transactionReceipt);
        ArrayList<LogCoinsSentEventResponse> responses = new ArrayList<LogCoinsSentEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogCoinsSentEventResponse typedResponse = new LogCoinsSentEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.sentTo = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogCoinsSentEventResponse> logCoinsSentEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogCoinsSentEventResponse>() {
            @Override
            public LogCoinsSentEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGCOINSSENT_EVENT, log);
                LogCoinsSentEventResponse typedResponse = new LogCoinsSentEventResponse();
                typedResponse.log = log;
                typedResponse.sentTo = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<LogCoinsSentEventResponse> logCoinsSentEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGCOINSSENT_EVENT));
        return logCoinsSentEventObservable(filter);
    }

    public List<LogDeathEventResponse> getLogDeathEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGDEATH_EVENT, transactionReceipt);
        ArrayList<LogDeathEventResponse> responses = new ArrayList<LogDeathEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LogDeathEventResponse typedResponse = new LogDeathEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.isDead = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.nbOfValid = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LogDeathEventResponse> logDeathEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, LogDeathEventResponse>() {
            @Override
            public LogDeathEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGDEATH_EVENT, log);
                LogDeathEventResponse typedResponse = new LogDeathEventResponse();
                typedResponse.log = log;
                typedResponse.isDead = (Boolean) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.nbOfValid = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<LogDeathEventResponse> logDeathEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGDEATH_EVENT));
        return logDeathEventObservable(filter);
    }

    public static Smartie load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Smartie(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Smartie load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Smartie(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static class LogCoinsSentEventResponse {
        public Log log;

        public String sentTo;

        public BigInteger amount;
    }

    public static class LogDeathEventResponse {
        public Log log;

        public Boolean isDead;

        public BigInteger nbOfValid;
    }
}
