https://medium.com/coinmonks/ethereum-blockchain-hello-world-smart-contract-with-java-9b6ae2961ad1

## Build docker image from Dockerfile

docker build . -t ethereum-tp

## Run a container in detach mode

docker run -itd --name ethereum-tp -v $(pwd)/java-project:/root/java-project ethereum-tp /bin/bash

## Lunch a node

geth --datadir chaine1T --rpcapi personnal,db,eth,net,web3 --rpc --mine --minerthreads=4 console

