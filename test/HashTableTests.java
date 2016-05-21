package test;

import src.HashTable;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;
import org.junit.Test;
import org.junit.Assert;


/**
 * This classes performs unit tests on the {@link src.HashTable} class.
 *
 * @author Javier Lores
 * @date May 21st, 2016
 */
public class HashTableTests {
    private static final int CAPACITY = 10;
    private static Random random = new Random();

    /**
     * This function tests the {@link src.HashTable#insert(long)} function.
     * It does so by attempting to insert randomly generated numbers
     * into a {@link src.HashTable}. Then, it confirms that insertions
     * for unique entries not in the table, return {@code true}.
     */
    @Test
    public void testInsertWhenValueIsNotInTable() {
        // The hashtable to insert the entries into
        HashTable table = new HashTable(this.CAPACITY);

        // Keep track of unique entries to decide if the insert should
        // be successful or unsucessful
        Set<Long> uniqueEntries = new HashSet<Long>();

        // Attempt to insert the entries into the hashtable
        for (int i = 0; i < this.CAPACITY; i++) {
            long entry = getRandom();

            // If this entry has not already been inserted, the insertion
            // should be successful
            if (!uniqueEntries.contains(entry)) {
                boolean success = table.insert(entry);
                Assert.assertTrue(success);
                uniqueEntries.add(entry); // Add the entry to the unique set
            }
        }
    }

    /**
     * This function tests the {@link src.HashTable#insert(long)} function.
     * It does so by attempting to insert randomly generated numbers
     * into a {@link src.HashTable}. Then, it confirms that insertions
     * for unique entries not in the table, return {@code true}.
     */
    @Test
    public void testInsertWhenValueIsInTable() {
        // The hashtable to insert the entries into
        HashTable table = new HashTable(this.CAPACITY);

        // Keep track of unique entries to decide if the insert should
        // be successful or unsucessful
        Set<Long> uniqueEntries = new HashSet<Long>();

        // Attempt to insert the entries into the hashtable
        for (int i = 0; i < this.CAPACITY; i++) {
            long entry = getRandom();
            boolean success = table.insert(entry);

            // If this entry has already been inserted, the insertion
            // should be unsuccessful
            if (uniqueEntries.contains(entry))
                Assert.assertFalse(success);

            // Add the entry to the unique set
            uniqueEntries.add(entry);
        }
    }

    /**
     * This function tests the {@link src.HashTable#insert(long)} function.
     * It does so by inserting randomly generated numbers into a
     * {@link src.HashTable} in an attempt to fill up the table. Of course,
     * the dynamic resizing should prevent this from happening and therefore
     * every insertion passed the orginal size of the hash table should
     * return {@code true}
     */
    @Test
    public void testInsertDynamicTableResizing() {
        HashTable table = new HashTable(this.CAPACITY);

        // Keep track of unique entries to decide if the insert should
        // be successful or unsucessful
        Set<Long> uniqueEntries = new HashSet<Long>();

        // Attempt to fill up the hash table
        for (int i = 0; i < 2*this.CAPACITY; i++) {
            // Generate the random number
            long entry;
            do {
                entry = getRandom();
            } while (uniqueEntries.contains(entry));

            // Insert and check if successfull
            boolean success = table.insert(entry);
            Assert.assertTrue(success);
            uniqueEntries.add(entry);
        }
    }

    /**
     * This function tests the {@link src.HashTable#contains(long)} function.
     * It does so by generating and inserting randomly generated numbers into
     * a {@link src.HashTable}. Then it searches for the entry in the table
     * and ensures the result is {@code true}.
     */
    @Test
    public void testContainsWhenValueIsInTable() {
        HashTable table = new HashTable(this.CAPACITY);

        // Generate the random numbers and check if they are in the table
        for (int i = 0; i < this.CAPACITY; i++) {
            // Generate the random number
            // Note the number is not necessarily unique, this is irrelevant
            // though because even if we insert the same number twice,
            // it will still be in the table
            long entry = getRandom();

            // Insert the entry into the table
            table.insert(entry);

            // Check if the entry is in the table
            boolean found = table.contains(entry);
            Assert.assertTrue(found);
        }
    }

    /**
     * This function tests the {@link src.HashTable#contains(long)} function.
     * It does so creating a {@link src.HashTable}. Then it generates a random
     * number and searches for the entry in the table and ensures the result
     * is {@code false}.
     */
    @Test
    public void testContainsWhenValueIsNotInTable() {
        HashTable table = new HashTable(this.CAPACITY);

        // Generate the random number and check if it is in the table
        for (int i = 0; i < (int)(0.5*this.CAPACITY); i++) {
            // Generate a random number
            long entry = getRandom();

            // Make sure the number is not in the table
            boolean found = table.contains(entry);
            Assert.assertFalse(found);
        }
    }

    /**
     * A helper function to generate a random (not necessarily unique)
     * long value.
     *
     * @return the random long value
     */
    private long getRandom() {
        return (long)(this.random.nextDouble()*4*this.CAPACITY);
    }
}
