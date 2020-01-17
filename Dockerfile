FROM ubuntu:bionic


WORKDIR /root

RUN apt-get update
RUN apt-get install -y software-properties-common
RUN apt-get install -y wget
RUN apt-get install -y unzip
RUN add-apt-repository -y ppa:ethereum/ethereum
RUN apt-get update
RUN apt-get install -y ethereum

# Install jdk8
RUN apt-get -y install openjdk-8-jdk

ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64s
ENV PATH $JAVA_HOME/bin:$PATH

RUN wget http://mirrors.ircam.fr/pub/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip

RUN unzip apache-maven-3.6.3-bin.zip
ENV PATH /root/apache-maven-3.6.3/bin:$PATH

# Download Web3J

RUN wget https://github.com/web3j/web3j/releases/download/v3.5.0/web3j-3.5.0.zip

# Unzip it

RUN unzip web3j-3.5.0.zip

# Linking

RUN echo '#!/bin/bash' >> /bin/web3j
RUN echo '~/web3j-3.5.0/bin/web3j' >> /bin/web3j
RUN chmod +x /bin/web3j

# Install solidity

RUN apt-get install -y solc


# Init private blockchain called chaine1T

RUN mkdir .ethereum && cd .ethereum
WORKDIR /root/.ethereum
COPY genesis.json .
RUN geth --datadir="chaine1T" init genesis.json

WORKDIR /root

# Define default command.
CMD ["bash"]
