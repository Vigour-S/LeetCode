package leetcode379;

import java.util.BitSet;

/**
 * Created by xiezhuohan on 1/4/17.
 */
/*
    Pay attention to the difference between .size() and .length(), they are different!
 */
public class PhoneDirectory {

    BitSet bitSet;
    int smallestFreeNumber;
    int max;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        bitSet = new BitSet(maxNumbers);
        max = maxNumbers;
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (smallestFreeNumber == max) {
            return -1;
        }
        bitSet.set(smallestFreeNumber);
        int num = smallestFreeNumber;
        smallestFreeNumber = bitSet.nextClearBit(smallestFreeNumber);
        return num;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !bitSet.get(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        bitSet.set(number, false);
        if (number < smallestFreeNumber) {
            smallestFreeNumber = number;
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */