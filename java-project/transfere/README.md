# Transfer

## About

 * Demo program to tranfer a fix amount of ether from one account to another using geth via web3j access.

## Pre-Run

Geth must powered up and mining before you run this program.

```bash
    geth --datadir="elephantchain" --etherbase '0x5edd062cc2ff7d260be8b93d0a0ac92be4e79da3'  --rpcapi personal,db,eth,net,web3 --rpc --nodiscover --mine --minerthreads=4 console
```

*Note: Do not forget to adapt datadir and etherbase parameters.*

## Compile

Use maven:  
```bash
    mvn clean install
```
