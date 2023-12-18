package dailymixes;

// -------------------------------------------------------------------------
/**
 * This class is a test suite for the PlaylistCalculator class, which is used to
 * manage playlists and songs.
 * 
 * @author Prakhar Pandey
 * @version 06-Nov-2023
 */
public class PlaylistCalculatorTest
    extends student.TestCase
{
    private ArrayQueue<Song> songQueue;
    private Playlist[] playlists;
    private PlaylistCalculator playlistCalculator;

    /**
     * Sets up the initial test environment by creating a song queue and
     * populating playlists.
     */
    public void setUp()
    {
        songQueue = new ArrayQueue<>(20);
        playlists = new Playlist[3];
        playlists[0] = new Playlist("Playlist1", 10, 20, 30, 20, 30, 40, 20);
        playlists[1] = new Playlist("Playlist2", 11, 21, 31, 21, 31, 41, 20);
        playlists[2] = new Playlist("Playlist3", 12, 22, 32, 22, 32, 42, 20);
        playlistCalculator = new PlaylistCalculator(songQueue, playlists);
    }


    /**
     * tests the reject() method.
     */
    public void testReject()
    {
        Song song1 = new Song("Jude", 11, 21, 31, "Playlist1");
        Song song2 = new Song("Hey", 12, 22, 32, "Playlist2");
        Song song3 = new Song("Heart", 13, 23, 33, "Playlist3");

        songQueue.enqueue(song1);
        songQueue.enqueue(song2);
        songQueue.enqueue(song3);
        assertEquals(playlistCalculator.getQueue().getSize(), 3);

        playlistCalculator.reject();
        assertEquals(playlistCalculator.getQueue().getSize(), 2);
        playlistCalculator.reject();
        assertEquals(playlistCalculator.getQueue().getSize(), 1);
        playlistCalculator.reject();
        assertEquals(playlistCalculator.getQueue().getSize(), 0);
    }


    /**
     * tests the addSongToPlaylist() method.
     */
    public void testaddSongToPlaylist()
    {
        Song song1 = new Song("hey", 11, 21, 31, "Playlist1");
        songQueue.enqueue(song1);
        assertTrue(playlistCalculator.addSongToPlaylist());
        Song songNull = null;
        songQueue.enqueue(songNull);
        assertFalse(playlistCalculator.addSongToPlaylist());

        for (int i = 0; i < 20; i++)
        {
            songQueue.enqueue(song1);
        }
        assertFalse(playlistCalculator.addSongToPlaylist());
    }


    /**
     * tests the getPlaylistForSong() method.
     */
    public void testGetPlaylistForSong()
    {
        Song songNull = null;
        assertEquals(null, playlistCalculator.getPlaylistForSong(songNull));

        Song song1 = new Song("I believe", 11, 21, 31, "Playlist1");
        assertEquals(
            playlists[0],
            playlistCalculator.getPlaylistForSong(song1));

        for (int i = 0; i < 20; i++)
        {
            playlists[0].addSong(song1);
        }
        assertEquals(
            playlists[1],
            playlistCalculator.getPlaylistForSong(song1));

        Song song2 = new Song("Heart", 9, 19, 29, "Playlist1");
        assertEquals(null, playlistCalculator.getPlaylistForSong(song2));

        Song song3 = new Song("Love", 21, 31, 41, "Playlist1");
        assertEquals(
            playlists[1],
            playlistCalculator.getPlaylistForSong(song3));

        Song song4 = new Song("Love", 31, 41, 51, "Playlist1");
        assertEquals(null, playlistCalculator.getPlaylistForSong(song4));

        Song song5 = new Song("Hey", 22, 32, 42, "Playlist1");
        assertEquals(
            playlists[2],
            playlistCalculator.getPlaylistForSong(song5));
    }


    /**
     * tests the getQueue() method.
     */
    public void testGetQueue()
    {
        assertEquals(songQueue, playlistCalculator.getQueue());
    }


    /**
     * tests the getPlaylistIndex() method.
     */
    public void testGetPlaylistIndex()
    {
        assertEquals(0, playlistCalculator.getPlaylistIndex("Playlist1"));
        assertEquals(1, playlistCalculator.getPlaylistIndex("Playlist2"));
        assertEquals(2, playlistCalculator.getPlaylistIndex("Playlist3"));
        assertEquals(-1, playlistCalculator.getPlaylistIndex("Playlist4"));
    }


    /**
     * tests the getPlaylists() method.
     */
    public void testGetPlaylists()
    {
        assertEquals(playlists, playlistCalculator.getPlaylists());
    }

}
