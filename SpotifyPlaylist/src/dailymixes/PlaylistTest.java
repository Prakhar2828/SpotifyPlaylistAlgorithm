// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Prakhar Pandey (prakhar28)

package dailymixes;

// -------------------------------------------------------------------------
/**
 * This class is a set of test cases for the Playlist class.
 * 
 * @author Prakhar Pandey
 * @version 04-Nov-2023
 */
public class PlaylistTest
    extends student.TestCase
{
    private Playlist playlist;

    /**
     * sets up the initial test conditions for each test method.
     */
    public void setUp()
    {
        playlist = new Playlist("Motivation", 10, 20, 30, 20, 30, 40, 20);
    }


    /**
     * tests the setName() method.
     */
    public void testSetName()
    {
        assertEquals("Motivation", playlist.getName());
        playlist.setName("Lofi");
        assertEquals("Lofi", playlist.getName());
    }


    /**
     * tests the addSong() method.
     */
    public void testAddSong()
    {
        assertEquals(0, playlist.getNumberOfSongs());
        assertFalse(playlist.isFull());
        Song song1 = new Song("Hey Jude!", 12, 27, 37, "Motivation");
        assertTrue(playlist.addSong(song1));
        assertEquals(1, playlist.getNumberOfSongs());

        Song song2 = new Song("Hey!", 9, 19, 29, "Motivation");
        assertFalse(playlist.addSong(song2));
        assertEquals(1, playlist.getNumberOfSongs());

        Song song3 = new Song("Jude!", 21, 31, 41, "Motivation");
        assertFalse(playlist.addSong(song3));
        assertEquals(1, playlist.getNumberOfSongs());

        for (int i = 0; i < 19; i++)
        {
            playlist.addSong(song1);
        }
        playlist.addSong(song1);
        assertFalse(playlist.addSong(song1));
        assertEquals(20, playlist.getNumberOfSongs());
        assertTrue(playlist.isFull());
    }


    /**
     * tests the toString() method.
     */
    public void testToString()
    {
        Song song1 = new Song("Hey Jude!", 12, 27, 37, "Motivation");
        assertTrue(playlist.addSong(song1));
        assertEquals(1, playlist.getNumberOfSongs());
        assertEquals(
            playlist.toString(),
            "Playlist: Motivation, # of songs: 1 (cap: 20), Requires: "
                + "Pop:10%-20%, Rock:20%-30%, Country:30%-40%");
    }


    /**
     * tests the equals() method.
     */
    public void testEquals()
    {
        assertEquals(playlist, playlist);

        Playlist playlist1 =
            new Playlist("Motivation", 10, 20, 30, 20, 30, 40, 20);
        assertEquals(playlist1, playlist);

        Playlist playlist2 = new Playlist("Lofi", 20, 10, 30, 40, 30, 20, 50);
        assertFalse(playlist2.equals(playlist));

        String name = "Prakhar Pandey";
        assertFalse(playlist.equals(name));

        Playlist playlist3 = null;
        assertFalse(playlist.equals(playlist3));

        Object playlist4 = new Object();
        assertFalse(playlist.equals(playlist4));

        Object obj = playlist;
        assertEquals(playlist, obj);
    }


    /**
     * tests the isQualified() method.
     */
    public void testIsQualified()
    {
        Song song1 = new Song("Hey Jude!", 12, 27, 37, "Motivation");
        assertTrue(playlist.isQualified(song1));

        Song song2 = new Song("Hey!", 9, 19, 29, "Motivation");
        assertFalse(playlist.isQualified(song2));

        Song song3 = new Song("Jude!", 21, 31, 41, "Motivation");
        assertFalse(playlist.isQualified(song3));
    }


    /**
     * tests the compareTo() method.
     */
    public void testCompareTo()
    {
        Playlist playlist1 =
            new Playlist("Playlist2", 20, 30, 40, 50, 60, 70, 15);
        Playlist playlist2 =
            new Playlist("Playlist3", 10, 20, 30, 40, 50, 60, 15);
        Playlist playlist3 =
            new Playlist("Playlist4", 10, 20, 30, 40, 50, 60, 20);

        assertTrue(playlist.compareTo(playlist1) > 0);
        assertTrue(playlist1.compareTo(playlist2) > 0);
        assertTrue(playlist2.compareTo(playlist3) < 0);
        assertTrue(playlist.compareTo(playlist3) < 0);
        assertTrue(playlist1.compareTo(playlist3) < 0);
    }
}
