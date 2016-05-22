package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import test.HashTableTests;


/**
 * This classes runs the tests located {@link test.HashTableTests}
 * for the {@link src.HashTable} class.
 *
 * @author Javier Lores
 * Created on May 21, 2016
 */
public class HashTableTestsRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(HashTableTests.class);
        for (Failure failure : result.getFailures())
            System.out.println(failure.toString());
        System.out.println(result.wasSuccessful());
    }
}
