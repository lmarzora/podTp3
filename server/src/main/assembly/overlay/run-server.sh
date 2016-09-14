#!/bin/bash

java  -Djava.security.policy=/home/lumarzo/pod/tp3/tp3/server/src/main/assembly/overlay/javaconf/java.policy -Djava.rmi.server.useCodebaseOnly=false -cp 'lib/jars/*' "ar.edu.itba.pod.server.Server" $*

