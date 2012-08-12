#!/bin/bash
rm -rf build/classes
mkdir  build
mkdir  build/classes
javac -cp build/classes:lib/junit-4.8.2.jar \
	-sourcepath src -d build/classes \
	src/net/jade/*.java
java  -cp build/classes:lib/junit-4.8.2.jar \
	org.junit.runner.JUnitCore net.jade.HelloTest
rm -rf build
