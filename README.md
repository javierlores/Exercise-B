# Exercise-B
----------- 

## Compile 
----------- 
javac src/HashTable.java 
javac -cp .:test/junit.jar:test/hamcrest.jar test/HashTableTests.java test/Hash$

## Run Unit Tests
-----------
java -cp .:test/junit.jar:test/hamcrest.jar test/HashTableTestsRunner

## Documentation
-----------
javadoc -cp .:test/junit.jar -d javadoc src test

## Build Jar
-----------
jar cf hashtable.jar src/HashTable.java
