# Ethereum experimentations

Some experimentations in the Ethereum ecosystem. This repo include a team project for OT4 course in INSA Lyon.

## About the Dockerfile

### Build docker image from Dockerfile

`docker build . -t ethereum-tp`

It will create a new private blackchain called `chaine1T` (chaine d'inté ;-) ) in the `~/.ethereum` directory.

### Run a container in detach mode

Lunch the following command from root:

`docker run -itd --name ethereum-tp -v $(pwd)/java-projects:/root/java-projects ethereum-tp /bin/bash`

### Enter in the container

To obtain bash command line interface inside the container:
`docker exec -it ethereum-tp /bin/bash`

### Create new ETH account

From `~/.ethereum` directory:
```
cd ~/.ethereum/
geth --datadir chaine1T account new
```

Save `Public address of the key` and `Path of the secret key file` output for future use inside your dApp.

### Lunch a node with mining

From the container command line (cf `Enter in the container`):

```
cd ~/.ethereum
geth --datadir chaine1T --rpcapi personnal,db,eth,net,web3 --rpc --mine --minerthreads=1 console
```

## Java projects

You can find different Java projects that interact with you private Ethereum blockchain in the `java-projects` directory:

- [HelloSmartWorld](./java-projects/hellosmartword): simple app to upload and execute a solidity smart contract on your own blockchain
- [Transfere](./java-projects/transfere): simple app to transfert `eth` from an account to another
- [Smarties](./java-projects/smarties): The team project. Project specs can be found in [this file](./PROJECT-REQUIREMENTS.md)

### Compile java project

Go inside the `java-projects` directory and choose a project.
Go inside a project.
To compile source code to `.jar` file (including dependencies), use:
`mvn clean install`
To lunch a compiled project: `java -cp ./target/X-SNAPSHOT-jar-with-dependencies.jar fr.insa.smarties.Launcher`

If a project miss dependencies, add the following code snippet to the `pom.xml` file in the root of your maven project.
```xml
<build>
    <plugins>
        <plugin>
            <artifactId>maven-assembly-plugin</artifactId>
            <executions>
            <execution>
                <phase>package</phase>
                <goals>
                    <goal>single</goal>
                </goals>
            </execution>
            </executions>
            <configuration>
            <descriptorRefs>
                <descriptorRef>jar-with-dependencies</descriptorRef>
            </descriptorRefs>
            </configuration>
        </plugin>
    </plugins>
</build>
```
