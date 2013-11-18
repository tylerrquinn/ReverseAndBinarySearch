package trquinn.reverseandsearch;

/**
 * 
 * Reverse contains a static method to reverse a string.
 * 
 * @author Tyler Quinn
 * 
 */
public class Reverse {

    /**
     * Reverse only contains static methods and should not be instantiated.
     */
    private Reverse() {
    }

    /**
     * Returns a new String with characters in the reverse order of s.
     * 
     * @param s
     *            The String to reverse
     * @return A new String with characters in the reverse order of s
     * @throws NullPointerException
     *             if s is null
     */
    public static String reverseString(String s) {
        if (s == null)
            throw new NullPointerException("s was null");

        // attempts to be as basic as possible without
        // creating lots of intermediate immutable Strings
        char[] buffer = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            buffer[s.length() - 1 - i] = s.charAt(i);
        }
        return new String(buffer);
    }

}
