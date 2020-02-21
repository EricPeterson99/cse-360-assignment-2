
// Name: Eric Peterson
// ID: 145
// Assignment 1

package cse360assign2;

/**
 * This is a class that creates a list that a can be modified and returned
 * from. This list can have a max size of 10 elements and all elements are added
 * to the front of the list. This list can also be searched, converted to
 * string, and has the ability to remove elements.
 */
public class SimpleList {

    /**
     * int[] list - the list of numbers
     * int count - the count of numbers in the list
     */
    private int[] list;
    private int count;

    /**
     * This is the main method which makes a simple list of 10 elements and 
     * sets the count to 0.
     */
    public SimpleList() {
        list = new int[10];
        count = 0;
    }

    /**
     * This method adds a number to the front of the list.
     * 
     * @param num number to be added.
     */
    public void add(int num) {

        /* count cannot be higher than the list length */
        if (count < list.length) {
            count++;
        }

        /* Shift element right to make room */
        for (int index = count - 1; index > 0; index--) {
            list[index] = list[index - 1];
        }

        list[0] = num;
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

            /*Iterate unitl the element to remove is found */
            if (list[index] == num) {
                removeFound = true;
            }

            /*Shift all elements left after the element to remove */
            if (removeFound) {
                list[index] = list[index + 1];
            }
        }

        if (removeFound) {
            count--;
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