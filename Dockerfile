FROM ubuntu:bionic

WORKDIR /root

RUN apt-get update
RUN apt-get install -y software-properties-common
RUN apt-get install -y curl
RUN apt-get install -y unzip
RUN add-apt-repository -y ppa:ethereum/ethereum
RUN apt-get update
RUN apt-get install -y ethereum

# Install jdk8
RUN apt-get -y install openjdk-8-jdk
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64
ENV PATH $JAVA_HOME/bin:$PATH

# Install maven
RUN curl http://mirrors.ircam.fr/pub/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip
RUN unzip apache-maven-3.6.3-bin.zip
ENV PATH /root/apache-maven-3.6.3/bin:$PATH

# Download & install Web3J v3.5
RUN curl https://github.com/web3j/web3j/releases/download/v3.5.0/web3j-3.5.0.zip
RUN unzip web3j-3.5.0.zip
RUN echo '#!/bin/bash' >> /bin/web3j
RUN echo '~/web3j-3.5.0/bin/web3j' >> /bin/web3j
RUN chmod +x /bin/web3j

# Install solidity v0.4.25
RUN curl -o /usr/bin/solc -fL https://github.com/ethereum/solidity/releases/download/v0.4.25/solc-static-linux \
    && chmod u+x /usr/bin/solc

# Init private blockchain called chaine1T
RUN mkdir .ethereum && cd .ethereum
WORKDIR /root/.ethereum
COPY genesis.json .
RUN geth --datadir="chaine1T" init genesis.json

WORKDIR /root

# Define default command.
CMD ["bash"]
