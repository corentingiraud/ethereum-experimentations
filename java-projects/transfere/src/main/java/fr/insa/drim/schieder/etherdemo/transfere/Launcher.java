package fr.insa.drim.schieder.etherdemo.transfere;

import org.web3j.crypto.CipherException;
import org.web3j.protocol.exceptions.TransactionException;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Demo program to tranfer a fix amount of ether from one account to another using geth via web3j access.
 * Geth must powered up and mining, first:
 geth --datadir="elephantchain" --etherbase '0x5edd062cc2ff7d260be8b93d0a0ac92be4e79da3'  --rpcapi personal,db,eth,net,web3 --rpc --nodiscover --mine --minerthreads=4 console
 * [*] runs the silent miner for an uninvolved third account.
 * [*] operates on the elephant chain
 */
public class Launcher {

    public static void main(String[] args) throws InterruptedException, TransactionException, CipherException, IOException, ExecutionException {

        System.out.println("Trying to transfere some ether using java and web3j...");

        EtherShifter shifter = new EtherShifter();
        shifter.transferEther();

        System.out.println("Ethereum transfer complete :-)");
    }
}
