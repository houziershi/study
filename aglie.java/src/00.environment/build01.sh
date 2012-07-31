#!/bin/bash

# compile
javac -classpath   /opt/morganstudio/lib-java/junit4.8.2/junit-4.8.2.jar HelloTest.java

# run junit test
java  -classpath .:/opt/morganstudio/lib-java/junit4.8.2/junit-4.8.2.jar org.junit.runner.JUnitCore HelloTest
