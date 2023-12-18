package dailymixes;

import java.util.Arrays;

import list.AList;
import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * A class representing a Playlist Calculator that helps manage songs in
 * playlists.
 * 
 * @author Prakhar Pandey
 * @version 06-Nov-2023
 */
public class PlaylistCalculator
{
    private Playlist[] playlists;
    /**
     * The number of playlists.
     */
    public static final int NUM_PLAYLISTS = 3;
    /**
     * The minimum percentage value.
     */
    public static final int MIN_PERCENT = 0;
    private AList<Song> rejectedTracks;
    private ArrayQueue<Song> songQueue;
    /**
     * The maximum percentage value.
     */
    public static final int MAX_PERCENT = 100;

    /**
     * Create a new PlaylistCalculator object.
     * 
     * @param songQueue
     *            The queue of songs to manage.
     * @param playlists
     *            An array of playlists to manage.
     */
    public PlaylistCalculator(ArrayQueue<Song> songQueue, Playlist[] playlists)
    {
        if (songQueue == null)
        {
            throw new IllegalArgumentException(
                "Input ArrayQueue cannot be null");
        }

        this.songQueue = songQueue;
        this.playlists = playlists;
        this.rejectedTracks = new AList<Song>();
    }


    /**
     * Get the appropriate playlist for a given song based on certain criteria.
     * 
     * @param nextSong
     *            The song for which to find a playlist.
     * @return The playlist to which the song should be assigned, or null if
     *             none is suitable.
     */
    public Playlist getPlaylistForSong(Song nextSong)
    {
        if (nextSong == null)
        {
            return null;
        }

        String suggestedPlaylist = nextSong.getPlaylistName();

        for (Playlist playlist : playlists)
        {
            if (suggestedPlaylist != null
                && suggestedPlaylist.equals(playlist.getName()))
            {
                if (!playlist.isFull() && canAccept(playlist, nextSong))
                {
                    return playlist;
                }
            }
        }

        Playlist playlistWithMostRoom = getPlaylistWithMostRoom(nextSong);
        if (playlistWithMostRoom != null)
        {
            return playlistWithMostRoom;
        }
        return null;
    }


    /**
     * Finds and returns the playlist with the most available capacity that can
     * accept a given song based on certain criteria.
     * 
     * @param nextSong
     *            The song for which a suitable playlist is being sought.
     * @return The playlist with the most room for the song, or null if no
     *             suitable playlist is found.
     */
    private Playlist getPlaylistWithMostRoom(Song nextSong)
    {
        Playlist[] sortedPlaylists = Arrays.copyOf(playlists, playlists.length);
        Arrays.sort(sortedPlaylists, (playlist1, playlist2) -> {
            int capacityComparison = Integer.compare(
                playlist2.getCapacity() - playlist2.getNumberOfSongs(),
                playlist1.getCapacity() - playlist1.getNumberOfSongs());

            if (capacityComparison == 0)
            {
                return playlist1.compareTo(playlist2);
            }
            return capacityComparison;
        });

        for (Playlist playlist : sortedPlaylists)
        {
            if (!playlist.isFull() && canAccept(playlist, nextSong))
            {
                return playlist;
            }
        }
        return null;
    }


    /**
     * Add the next song in the queue to an appropriate playlist, if available.
     * 
     * @return True if a song was added to a playlist, false if not.
     */
    public boolean addSongToPlaylist()
    {
        if (!songQueue.isEmpty())
        {
            Song nextSong = songQueue.getFront();
            Playlist suggestedPlaylist = getPlaylistForSong(nextSong);

            if (suggestedPlaylist != null)
            {
                suggestedPlaylist.addSong(nextSong);
                songQueue.dequeue();
                return true;
            }
        }

        return false;
    }


    /**
     * Move the next song in the queue to the list of rejected tracks.
     */
    public void reject()
    {
        Song rejectedSong = songQueue.getFront();
        rejectedTracks.add(rejectedSong);
        songQueue.dequeue();
    }


    /**
     * Check if a song is eligible to be added to a playlist based on genre
     * criteria.
     * 
     * @param playlist
     *            The playlist being considered.
     * @param song
     *            The song to be added.
     * @return True if the song is eligible for the playlist, false if not.
     */
    private boolean canAccept(Playlist playlist, Song song)
    {
        return playlist.isQualified(song);
    }


    /**
     * Find the index of a playlist by its name.
     * 
     * @param playlistName
     *            The name of the playlist to search for.
     * @return The index of the playlist in the array, or -1 if not found.
     */
    public int getPlaylistIndex(String playlistName)
    {
        for (int i = 0; i < NUM_PLAYLISTS; i++)
        {
            if (playlists[i].getName().equals(playlistName))
            {
                return i;
            }
        }
        return -1;
    }


    /**
     * Get the queue of songs to be assigned to playlists.
     * 
     * @return The queue of songs.
     */
    public ArrayQueue<Song> getQueue()
    {
        return songQueue;
    }


    /**
     * Get the array of playlists.
     * 
     * @return An array of playlists.
     */
    public Playlist[] getPlaylists()
    {
        return playlists;
    }
}
