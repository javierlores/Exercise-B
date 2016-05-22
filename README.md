# Exercise-B
----------- 

The data structure employed in this exercise is a simple open address hashtable
that employs linear probing for collision avoidance.

## Compile 
----------- 
javac src/HashTable.java 
javac -cp .:test/junit.jar:test/hamcrest.jar test/HashTableTests.java test/HashTableTestsRunner.java

## Run Unit Tests
-----------
java -cp .:test/junit.jar:test/hamcrest.jar test/HashTableTestsRunner

## Documentation
-----------
javadoc -cp .:test/junit.jar -d javadoc src test

## Build Jar
-----------
jar cf hashtable.jar src/*.class
