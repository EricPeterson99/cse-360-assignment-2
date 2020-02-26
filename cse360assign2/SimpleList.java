
// Name: Eric Peterson
// ID: 145
// Assignment 1
// Repo: https://github.com/EricPeterson99/cse-360-assignment-2

package cse360assign2;

import java.util.Arrays;

/**
 * This is a class that creates a list that a can be modified and returned from.
 * This list can have a max size of 10 elements and all elements are added to
 * the front of the list. This list can also be searched, converted to string,
 * and has the ability to remove elements.
 */
public class SimpleList {

    /**
     * int[] list - the list of numbers int count - the count of numbers in the list
     */
    private int[] list;
    private int count;

    /**
     * This is the main method which makes a simple list of 10 elements and sets the
     * count to 0.
     */
    public SimpleList() {
        list = new int[10];
        count = 0;
    }

    /**
     * This method adds a number to the front of the list. And increase size if
     * needed by 50%.
     * 
     * @param num number to be added.
     */
    public void add(int num) {
        count++;

        /* if count higher than the list length, then increase list size by 50% */
        if (count > list.length) {
            list = Arrays.copyOf(list, list.length + (list.length / 2));
        }

        /* Shift element right to make room */
        for (int index = count - 1; index > 0; index--) {
            list[index] = list[index - 1];
        }

        list[0] = num;
    }

    /**
     * This method adds a number to the end of the list. And increase size if needed
     * by 50%.
     * 
     * @param num number to be added.
     */
    public void append(int num) {
        if (count == list.length) {
            list = Arrays.copyOf(list, list.length + (list.length / 2));
        }

        list[count] = num;
        count++;
    }

    /**
     * This method searches for the given number, if found it removes the element
     * and reformats the list.
     * 
     * @param num number to be removed.
     */
    public void remove(int num) {
        boolean removeFound = false;

        for (int index = 0; index < count; index++) {

            /* Iterate unitl the element to remove is found */
            if (list[index] == num) {
                removeFound = true;
            }

            /*
             * Shift all elements left after the element to remove, unless it is the last
             * element
             */
            if (removeFound && index != list.length - 1) {
                list[index] = list[index + 1];
            }
        }

        if (removeFound) {
            count--;

            /* If there is more than 25% empty space, then shrink list */
            if (count < list.length * 3 / 4) {
                list = Arrays.copyOf(list, list.length * 3 / 4);
            }
        }
    }

    /**
     * This method returns the number of elements.
     * 
     * @return int count of elements in list.
     */
    public int count() {
        return count;
    }

    /**
     * This method returns the current number of possible locations in the list.
     * 
     * @return int number of possible locations in the list.
     */
    public int size() {
        return list.length;
    }

    /**
     * This method returns the first element if it exist.
     * 
     * @return int of first element, or -1 if list is empty.
     */
    public int first() {
        return list[0];
    }

    /**
     * This writes the list to a sting and returns the result.
     * 
     * @return String This is a string of the list.
     */
    public String toString() {
        String res = "";

        if (count > 0) {
            for (int index = 0; index < count - 1; index++) {
                res += list[index] + " ";
            }

            res += list[count - 1];
        }

        return res;
    }

    /**
     * This method searches for the desired number and returns the location.
     * 
     * @param num Number to be searched for.
     * @return int The numbers location or -1 if not found.
     */
    public int search(int num) {
        int pos = -1;
        int index = 0;
        boolean posFound = false;

        while (index < count && !posFound) {

            if (list[index] == num) {
                posFound = true;
                pos = index;
            }
            index++;
        }
        return pos;
    }

}
