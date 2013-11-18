package trquinn.reverseandsearch;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Contains JUnit4 Tests for the Reverse class.
 * 
 * @author Tyler Quinn
 * 
 */
public class ReverseTest {

    @Test(expected = NullPointerException.class)
    /**
     * Tests that passing reverseString a null String throws the expected
     * exception.
     */
    public void testNullPointerExceptionThrown() {
        Reverse.reverseString(null);
    }

    @Test
    /**
     * Tests a that a String with a single character is reversed as expected.
     */
    public void testSingleCharacterString() {
        assertReverseString("a", "a");
    }

    @Test
    /**
     * Tests that passing reverseString a String with two characters
     * returns the expected string.
     */
    public void testTwoCharacterString() {
        assertReverseString("de", "ed");
    }

    @Test
    /**
     * Tests that passing reverseString an empty string ("") returns
     * the expected String.
     */
    public void testEmptyString() {
        assertReverseString("", "");
    }

    @Test
    /**
     * Tests that passing reverseString a small odd length String
     * returns the expected String.
     */
    public void testSmallOddString() {
        assertReverseString("abc", "cba");
    }

    @Test
    /**
     * Tests that passing reverseString a small odd String
     * which is a palindrome returns a new string of the same
     * form.
     */
    public void testSmallOddPalindromeString() {
        String pal = "$%$";
        String result = assertReverseString(pal, pal);
        assertTrue(result != pal); // assert new string returned
    }

    @Test
    /**
     * Tests that passing reverseString a small even length
     * String returns the expected String.
     */
    public void testSmallEvenString() {
        assertReverseString("even", "neve");
    }

    @Test
    /**
     * Tests that passing reverseString a small even String which
     * is a palindrome returns a new string of the same form.
     */
    public void testSmallEvenPalindromeString() {
        String pal = "meem";
        String result = assertReverseString(pal, pal);
        assertTrue(result != pal);
    }

    @Test
    /**
     * Tests that passing reverseString a string of even length with many
     * different characters returns the expected String.
     */
    public void testOddString() {
        assertReverseString("abcd !@#$ 1234 {}||", "||}{ 4321 $#@! dcba");
    }

    @Test
    /**
     * Tests that passing reverseString a string of odd length with many
     * different characters returns the expected String.
     */
    public void testEvenString() {
        assertReverseString("abcd!@#$1234{}||", "||}{4321$#@!dcba");
    }

    @Test
    /**
     * Tests that passing reverseString a string which contains escape
     * sequence characters returns the expected String.
     */
    public void testEscapeSequenceString() {
        assertReverseString("\\\\Escape \"Sequence\"",
                "\"ecneuqeS\" epacsE\\\\");
    }

    /**
     * Asserts that reverseString will take String input and return a string
     * that is equivalent to String output.
     * 
     * @param input
     *            The string to pass to reverseString
     * @param output
     *            The string expected to be returned
     * @return The actual result of reverseString
     */
    private String assertReverseString(String input, String expected) {
        String result = Reverse.reverseString(input);
        assertEquals(expected, result);
        return result;
    }

}
