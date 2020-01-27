# Sample smart contract compile scripy

## To compile

```
rm -rf ../build
solc Smartie.sol --bin --abi --optimize -o ../build
```

## To generate java class

```
cd ../build
./../../../../web3j-3.5.0/bin/web3j solidity generate smartie.bin smartie.abi -p fr.insa.smarties -o ../../src/main/java
```
