#!/bin/bash

java -Djava.rmi.server.codebase=file:///home/lumarzo/pod/tp3/tp3/client/target/tp3-client-1.0-SNAPSHOT.jar -cp 'lib/jars/*' "ar.edu.itba.pod.client.Client" $*




