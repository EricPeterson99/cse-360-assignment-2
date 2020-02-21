
// Name: Eric Peterson
// ID: 145
// Assignment 1

package cse360assign2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This is the test class for SimpleList. It test all of the methods and the
 * constructor.
 */
public class SimpleListTest {

    /**
     * This method test the constructor by making sure that it is not null after
     * construction.
     */
    @Test
    public void testMyList1() {
        SimpleList list = new SimpleList();

        assertNotNull(list);
    }

    /**
     * This methods test the adding by adding elements and checking if they are in
     * the expected spot.
     */
    @Test
    public void testAdd1() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(2);

        assertEquals("2 1", list.toString());
    }

    /**
     * This methods test the adding by making sure that when more than 10 elements
     * are added the oldest one is still at the end.
     */
    @Test
    public void testAdd2() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);

        /* checks if '1' is still there */
        assertEquals(10, list.search(1));
    }

    /**
     * This methods test the adding by adding the same number twice.
     */
    @Test
    public void testAdd3() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(1);

        assertEquals("1 1", list.toString());
    }

    /**
     * This methods test the adding by making sure that when more than 10 elements
     * are added the list is increased to make room.
     */
    @Test
    public void testAdd4() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);

        /* checks if size is increased */
        assertEquals(15, list.size());
    }

    /**
     * This methods test the remove by adding elements then removing one and
     * checking if it is removed using search.
     */
    @Test
    public void testRemove1() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);

        /* Checks to see if '2' is removed */
        assertEquals(-1, list.search(2));
    }

    /**
     * This methods test the remove by removing an element that was never there.
     */
    @Test
    public void testRemove2() {
        SimpleList list = new SimpleList();

        /* remove element that does not exist */
        list.remove(2);

        assertEquals(-1, list.search(2));
    }

    /**
     * This methods test the remove by checking to make sure the count is never less
     * than 0.
     */
    @Test
    public void testRemove3() {
        SimpleList list = new SimpleList();
        list.remove(2);

        /* makes sure that count is still 0, not -1 */
        assertEquals(0, list.count());
    }

    /**
     * This methods test the remove by making sure that only when MORE than 25% is
     * free space that is shrinks the list.
     */
    @Test
    public void testRemove4() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.remove(2);
        list.remove(1);

        /* Checks to see if '2' is removed */
        assertEquals(4, list.size());
    }

    /**
     * This methods test the count by adding elements and making sure the count is
     * correct.
     */
    @Test
    public void testCount1() {
        SimpleList list = new SimpleList();
        list.add(0);
        list.add(1);

        assertEquals(2, list.count());
    }

    /**
     * This methods test the count by getting the count of an empty list.
     */
    @Test
    public void testCount2() {
        SimpleList list = new SimpleList();

        assertEquals(0, list.count());
    }

    /**
     * This methods test the size by adding elements and making sure the size is
     * correct.
     */
    @Test
    public void testSize1() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(2);

        assertEquals(10, list.size());
    }

    /**
     * This methods test the size when the list is empty.
     */
    @Test
    public void testSize2() {
        SimpleList list = new SimpleList();

        assertEquals(10, list.size());
    }

    /**
     * This methods test the first by adding two elements and checking the first is
     * returned.
     */
    @Test
    public void testFirst1() {
        SimpleList list = new SimpleList();
        list.add(0);
        list.add(1);

        assertEquals(1, list.first());
    }

    /**
     * This methods test the first by getting the first of an empty list.
     */
    @Test
    public void testFirst2() {
        SimpleList list = new SimpleList();

        assertEquals(-1, list.first());
    }

    /**
     * This methods test the seach by adding elements and searching for it. It makes
     * sure that they are found and in the correct location.
     */
    @Test
    public void testSearch1() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(2);

        assertEquals(1, list.search(1));
    }

    /**
     * This methods test the seach by looking for an element that was never added.
     */
    @Test
    public void testSearch2() {
        SimpleList list = new SimpleList();

        assertEquals(-1, list.search(1));
    }

    /**
     * This method test the toString by adding elements and comparing the toString
     * to the expected result.
     */
    @Test
    public void testToString1() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(2);

        assertEquals("2 1", list.toString());
    }

    /**
     * This method test the toString by comparing the empty list toString to the
     * expected result.
     */
    @Test
    public void testToString2() {
        SimpleList list = new SimpleList();

        assertEquals("", list.toString());
    }
}
