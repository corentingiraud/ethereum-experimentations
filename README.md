# Ethereum experimentations

Some experimentation in the ethereum ecosystem. This repo include a team project for OT4 course in INSA Lyon.

## Build docker image from Dockerfile

`docker build . -t ethereum-tp`

It will create a new private blackchain called `chaine1T` (chaine d'inté ;-) ) in the `~/.ethereum` directory.

## Run a container in detach mode

Lunch the following command from root:

`docker run -itd --name ethereum-tp -v $(pwd)/java-project:/root/java-project ethereum-tp /bin/bash`

## Enter in the container

To obtain bash command line interface inside the container:
`docker exec -it ethereum-tp /bin/bash`

## Create new ETH account

From `~/.ethereum` directory:
```
cd ~/.ethereum/
geth account new
```

## Lunch a node with mining

From the container command line (cf `Enter in the container`):

`geth --datadir chaine1T --rpcapi personnal,db,eth,net,web3 --rpc --mine --minerthreads=1 console`
