package dailymixes;

// -------------------------------------------------------------------------
/**
 * A test class for the GenreSet class, which is used to test the functionality
 * of the GenreSet class.
 * 
 * @author Prakhar Pandey
 * @version 30-Oct-2023
 */
public class GenreSetTest
    extends student.TestCase
{
    private GenreSet genreSet;

    /**
     * Set up the test environment by creating a new GenreSet instance with
     * specified genre values.
     */
    public void setUp()
    {
        genreSet = new GenreSet(15, 25, 35);
    }


    /**
     * Test the toString() method, which returns a string representation of the
     * genre set. Verifies that the string representation matches the expected
     * format.
     */
    public void testToString()
    {
        assertEquals("Pop:15 Rock:25 Country:35", genreSet.toString());
    }


    /**
     * Test the equals() method to check if two genre sets are equal. Compares
     * genre sets for equality and handles different cases.
     */
    public void testEquals()
    {
        GenreSet genreSet1 = new GenreSet(15, 25, 35);
        assertEquals(genreSet, genreSet1);

        GenreSet genreSet2 = new GenreSet(17, 23, 35);
        assertFalse(genreSet.equals(genreSet2));

        String name = "Prakhar Pandey";
        assertFalse(genreSet.equals(name));

        GenreSet genreSet3 = null;
        assertFalse(genreSet.equals(genreSet3));

        Object genreSet4 = new Object();
        assertFalse(genreSet.equals(genreSet4));

        Object obj = genreSet;
        assertEquals(genreSet, obj);
    }


    /**
     * Test the isWithinRange() method, which checks if a genre set is within a
     * specified range. Verifies that isWithinRange() correctly determines if a
     * genre set is within the specified range.
     */
    public void testIsWithinRange()
    {
        GenreSet minGenreSet = new GenreSet(10, 20, 30);
        GenreSet maxGenreSet = new GenreSet(20, 30, 40);
        GenreSet notWithinRange = new GenreSet(9, 19, 29);
        GenreSet notWithinRange1 = new GenreSet(21, 31, 41);

        assertTrue(genreSet.isWithinRange(minGenreSet, maxGenreSet));
        assertFalse(notWithinRange.isWithinRange(minGenreSet, maxGenreSet));
        assertFalse(notWithinRange1.isWithinRange(minGenreSet, maxGenreSet));
    }


    /**
     * Test the compareTo() method, which compares two genre sets. Validates
     * that the compareTo() method correctly compares genre sets and returns the
     * result.
     */
    public void testCompareTo()
    {
        GenreSet genreSet1 = new GenreSet(10, 20, 30);
        GenreSet genreSet2 = new GenreSet(15, 25, 35);

        assertEquals(1, genreSet.compareTo(genreSet1));
        assertEquals(-1, genreSet1.compareTo(genreSet));
        assertEquals(0, genreSet.compareTo(genreSet2));
    }
}
