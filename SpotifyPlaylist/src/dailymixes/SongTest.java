package dailymixes;

// -------------------------------------------------------------------------
/**
 * A test class for the Song class, which is used to test the functionality of
 * the Song class.
 * 
 * @author Prakhar Pandey
 * @version 30-Oct-2023
 */
public class SongTest
    extends student.TestCase
{
    private Song song;

    /**
     * Set up the test environment by creating a new Song instance with sample
     * data.
     */
    public void setUp()
    {
        song = new Song("This is America", 15, 25, 35, "Rap");
    }


    /**
     * Test the equals() method to check if two songs are equal. Compares songs
     * for equality and handles different cases.
     */
    public void testEquals()
    {
        Song song1 = new Song("This is America", 15, 25, 35, "Rap");
        assertEquals(song, song1);

        Song song2 = new Song("In Da Club", 20, 10, 40, "Rap");
        assertFalse(song.equals(song2));

        String name = "Prakhar Pandey";
        assertFalse(song.equals(name));

        Song song3 = null;
        assertFalse(song.equals(song3));

        Object song4 = new Object();
        assertFalse(song.equals(song4));

        Object obj = song;
        assertEquals(song, obj);
    }


    /**
     * Test the toString() method, which returns a string representation of the
     * song. Verifies that the string representation matches the expected
     * format.
     */
    public void testToString()
    {
        assertEquals(
            "This is America Pop:15 Rock:25 Country:35 Suggested: Rap",
            song.toString());

        Song song1 = new Song("This is America", 15, 25, 35, "");
        assertEquals(
            song1.toString(),
            "No-Playlist This is America Pop:15 Rock:25 Country:35");
    }
}
