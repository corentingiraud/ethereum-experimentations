rm -rf contracts/build &&\
solc contracts/solidity/Smartie.sol --bin --abi --optimize -o contracts/build &&\
./../../web3j-3.5.0/bin/web3j solidity generate contracts/build/smartie.bin contracts/build/smartie.abi -p fr.insa.smarties -o src/main/java &&\
chmod 777 src/main/java/fr/insa/smarties/Smartie.java &&\
mvn clean install

# java -cp ./target/smarties-1.0-SNAPSHOT-jar-with-dependencies.jar fr.insa.smarties.Launcher '0xe087b47782c968bc3e31a3b1d9196af833501260'
