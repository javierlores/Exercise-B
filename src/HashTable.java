package src;

import java.util.Random;

/**
 * This class is an implementation of a HashTable. This class uses open
 * addressing and linear probing for collision resolution.
 */
public class HashTable {
    long[] table;

    public HashTable(int size) {
        this.table = new long[size];
        for (int i = 0; i < this.table.length; i++)
            this.table[i] = Long.MIN_VALUE;
    }

    /**
     * Return {@code true} if {@code value} exists within the collection.
     *
     * @param value the value for which to check
     * @return {@code true} if {@code value} is contained within the
     * collection
     */
     public boolean contains(long value) {
        int hashCode = (int)(value^(value >>> 32));
        int hashMarker = -1; // A marker to detect if table was searched

        // If we found an empty slot, or if we have looped through the
        // whole table and still haven't found the value, the value is
        // not in the table
        while (this.table[hashCode] != Long.MIN_VALUE && hashCode != hashMarker) {
            // Check if we found the value
            if (this.table[hashCode] == value)
                return true;

            // If this is the first attempt to find a hash, set a marker
            // that will be used to detect when the whole table has been
            // searched
            if (hashMarker == -1)
                hashMarker = hashCode;

            // Linear probing
            hashCode = (hashCode+1) % this.table.length;
        }
        return false;
    }

    /**
     * Attepmt to insert {@code value} into the collection and return
     * {@code true} if the collection is modified after this method
     * returns (e.g. {@code value} was not already contained in the
     * collection)
     *
     * @param value a long value to insert into the collection
     * @return {@code true} if {@code value} didn't previously exist in
     * the collection and is inserted
     */
    public boolean insert(long value) {
        // Compute the hash code
        int hashCode = (int)(value^(value >>> 32));
        int hashMarker = -1; // A marker to detect if table was searched

        // Search for an available slot for the value
        while (this.table[hashCode] != Long.MIN_VALUE) {
            // If this value is already in the table, return false
            if (this.table[hashCode] == value)
                return false;
            // If we have looped through the whole table and still haven't
            // found a slot, the table is full and we need to resize
            if (hashCode == hashMarker)
                return false;
            // If this is the first attempt to find a hash, set a marker
            // that will be used to detect when the whole table has been
            // searched
            if (hashMarker == -1)
                hashMarker = hashCode;

            // Linear probing
            hashCode = (hashCode+1) % this.table.length;
        }

        // We have found a slot for the value, insert it
        this.table[hashCode] = value;
        return true;
    }
}


