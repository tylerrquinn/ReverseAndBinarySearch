package trquinn.reverseandsearch;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Contains JUnit4 Tests for the Searchs class.
 * 
 * @author Tyler Quinn
 * 
 */
public class SearchsTest {

    static Integer[] ints;
    static String[] strings;

    @Before
    public void setUp() throws Exception {
        ints = new Integer[] { Integer.MIN_VALUE, -1234, -4, -4, 7, 10, 19, 24,
                43, 90, Integer.MAX_VALUE };
        strings = new String[] { "apple", "banana", "cantelope", "grape",
                "strawberry", "watermelon" };
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(expected = NullPointerException.class)
    /**
     * Tests that binarySearch throws NullPointerException when
     * passed a null array.
     */
    public void testNullArrayException() {
        Searchs.binarySearch(null, 1);
    }

    @Test(expected = NullPointerException.class)
    /**
     * Tests that binarySearch throws NullPointerException when
     * passed a null element.
     */
    public void testNullElementException() {
        Searchs.binarySearch(ints, null);
    }

    @Test
    /**
     * Tests that binarySearch finds the expected index when given the middle
     * element of an array. 
     */
    public void testSearchIntegerMiddle() {
        assertBinarySearch(ints, 10, 5);
    }

    @Test
    /**
     * Tests that binarySearch finds the expected index when given the first
     * element of an array. 
     */
    public void testSearchIntegerFirst() {
        assertBinarySearch(ints, Integer.MIN_VALUE, 0);
    }

    @Test
    /**
     * Tests that binarySearch finds the expected index when given the last
     * element of an array. 
     */
    public void testSearchIntegerLast() {
        assertBinarySearch(ints, Integer.MAX_VALUE, 10);
    }

    @Test
    /**
     * Tests that binarySearch finds the expected index when given the element
     * left one element of the middle.
     */
    public void testSearchIntegerLeftOfMid() {
        assertBinarySearch(ints, 7, 4);
    }

    @Test
    /**
     * Tests that binarySearch finds the expected index when given the element
     * right one element of the middle.
     */
    public void testSearchIntegerRightOfMid() {
        assertBinarySearch(ints, 19, 6);
    }

    @Test
    /**
     * Tests that binarySearch finds an expected index when given an element
     * that has multiple matches in the array.
     */
    public void testSearchIntegerDuplicate() {
        int result = Searchs.binarySearch(ints, -4);
        // which duplicate is selected is undefined in the docs, so
        // either index will pass our test
        assertTrue("Expected: index 2 or 3    Actual: index " + result,
                result == 2 || result == 3);
    }

    /**
     * Tests that binarySearch finds an expected index when given an element
     * from the left half of an array.
     */
    @Test
    public void testSearchIntegerLeftSection() {
        assertBinarySearch(ints, -1234, 1);
    }

    /**
     * Tests that binarySearch finds an expected index when given an element
     * from the right half of an array.
     */
    @Test
    public void testSearchIntegerRightSection() {
        assertBinarySearch(ints, 90, 9);
    }

    @Test
    /**
     * Tests that binarySearch returns -1 when passed an element that is
     * not contained in the array.
     */
    public void testSearchIntegerNotInArray() {
        assertBinarySearch(ints, -77, -1);
    }

    @Test
    /**
     * Tests that searching an empty array returns the expected
     * index (-1).
     */
    public void testSearchEmptyArray() {
        Integer[] array = new Integer[0];
        assertBinarySearch(array, 1, -1);
    }

    @Test
    /**
     * Tests that binarySearch finds the expected index for every element
     * in an array of 11 unique Integers.
     */
    public void testSearchIntegerAll() {
        ints[3] = 5;
        for (int i = 0; i < ints.length; i++)
            assertBinarySearch(ints, ints[i], i);
    }

    @Test
    /**
     * Tests that binarySearch finds the expected index for every element
     * in an array of unique Strings.
     */
    public void testSearchStringAll() {
        for (int i = 0; i < strings.length; i++)
            assertBinarySearch(strings, strings[i], i);
    }

    @Test
    /**
     * Generates a random array and tests that the returned index from
     * binarySearch actually contains the element that we searched for.
     */
    public void testSearchRandomArrayResult() {
        final int maxNumber = 2000; // the maxNumber to use in random number
                                    // generation
        Random r = new Random();

        // run the random test 1000 times
        for (int i = 0; i < 1000; i++) {
            // generate a random array
            Integer[] array = new Integer[r.nextInt(maxNumber)];
            for (int j = 0; j < array.length; j++)
                array[j] = r.nextInt(maxNumber) - maxNumber / 2;
            // search for a random number in the array
            Integer element = r.nextInt(maxNumber) - maxNumber / 2;
            int result = Searchs.binarySearch(array, element);
            // assert that the result makes sense; the returned index
            // holds the element we searched for
            if (result > -1)
                assertEquals(element, array[result]);
        }
    }

    /**
     * Asserts that searching for element in array with binarySearch returns the
     * expected int.
     * 
     * @param array
     *            The array to search
     * @param element
     *            The element to search for
     * @param expected
     *            The expected result of the search
     */
    private <T extends Comparable<T>> void assertBinarySearch(T[] array,
            T element, int expected) {
        int result = Searchs.binarySearch(array, element);
        assertEquals(expected, result);
    }

}
