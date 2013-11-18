package trquinn.reverseandsearch;

/**
 * Searchs contains static searching methods.
 * 
 * @author Tyler Quinn
 * 
 */
public class Searchs {

    /**
     * Searchs contains only static methods and should not be instantiated.
     */
    private Searchs() {
    }

    /**
     * Searches for object 'element' in a sorted array of objects that extend
     * Comparable.
     * 
     * Precondition: array is sorted in ascending order according to
     * {@link java.lang.Comparable#compareTo(Object) compareTo} (behavior is
     * undefined otherwise).
     * 
     * @param array
     *            The array to search
     * @param element
     *            The element to search for
     * @return An index in array at which an object equal to element is stored.
     *         If there are multiple indices with a match, it is undefined which
     *         of those indices is returned. If a match is not found, -1 is
     *         returned.
     * @throws NullPointerException
     *             if array or element is null
     */
    public static <T extends Comparable<T>> int binarySearch(T[] array,
            T element) {
        // check for null input
        if (array == null || element == null)
            throw new NullPointerException();

        // instantiate pointers
        int beg = 0;
        int end = array.length - 1;

        // We will implement iteratively and avoid some possible overhead of
        // recursion
        while (end >= beg) {
            // pick middle index
            // avoid possible overflow
            int mid = beg + ((end - beg) / 2);
            if (array[mid].compareTo(element) == 0) {
                // match is found
                return mid;
            } else if (array[mid].compareTo(element) < 0) {
                // element is greater, search right array
                beg = mid + 1;
            } else { // "" > 0
                // element is smaller, search left array
                end = mid - 1;
            }
        }
        // No match was found
        return -1;
    }

}
