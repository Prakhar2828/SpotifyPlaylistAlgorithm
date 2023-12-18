package dailymixes;

import java.util.Arrays;

// -------------------------------------------------------------------------
/**
 * This class represents a Playlist, which is used to manage songs in a
 * playlist.
 * 
 * @author Prakhar Pandey
 * @version 04-Nov-2023
 */
public class Playlist
    implements Comparable<Playlist>
{
    private GenreSet minGenreSet;
    private GenreSet maxGenreSet;
    private Song[] songs;
    private int capacity;
    private int numberOfSongs;
    private String name;

    // ----------------------------------------------------------
    /**
     * Create a new Playlist object.
     * 
     * @param playlistName
     *            is the name of the playlist.
     * @param minPop
     *            is the minimum percentage of pop.
     * @param minRock
     *            is the minimum percentage of rock.
     * @param minCountry
     *            is the minimum percentage of country.
     * @param maxPop
     *            is the maximum percentage of pop.
     * @param maxRock
     *            is the maximum percentage of rock.
     * @param maxCountry
     *            is the maximum percentage of country.
     * @param playlistCap
     *            is the capacity of the the playlist.
     */
    public Playlist(
        String playlistName,
        int minPop,
        int minRock,
        int minCountry,
        int maxPop,
        int maxRock,
        int maxCountry,
        int playlistCap)
    {
        this.minGenreSet = new GenreSet(minPop, minRock, minCountry);
        this.maxGenreSet = new GenreSet(maxPop, maxRock, maxCountry);
        this.numberOfSongs = 0;
        this.name = playlistName;
        this.capacity = playlistCap;
        this.songs = new Song[capacity];
    }


    /**
     * Gets the minimum genre set (Pop, Rock, Country) criteria for this
     * playlist.
     *
     * @return The minimum genre set criteria.
     */
    public GenreSet getMinGenreSet()
    {
        return minGenreSet;
    }


    /**
     * Sets the name of this playlist.
     *
     * @param newName
     *            The new name to set for the playlist.
     */
    public void setName(String newName)
    {
        this.name = newName;
    }


    /**
     * Gets the number of available spaces left in this playlist.
     *
     * @return The number of available spaces left.
     */
    public int getSpacesLeft()
    {
        return (capacity - numberOfSongs);
    }


    /**
     * Gets the maximum genre set (Pop, Rock, Country) criteria for this
     * playlist.
     *
     * @return The maximum genre set criteria.
     */
    public GenreSet getMaxGenreSet()
    {
        return maxGenreSet;
    }


    /**
     * Compares this playlist to another playlist based on certain criteria.
     *
     * @param other
     *            The other playlist to compare to.
     * @return A negative value if this playlist is less than the other, a
     *             positive value if it's greater, and 0 if they are equal.
     */
    public int compareTo(Playlist other)
    {
        int capacityComparison = this.capacity - other.capacity;

        if (capacityComparison != 0)
        {
            return capacityComparison;
        }

        int spacesLeftComparison = this.getSpacesLeft() - other.getSpacesLeft();

        if (spacesLeftComparison != 0)
        {
            return spacesLeftComparison;
        }

        int minGenreSetComparison =
            this.minGenreSet.compareTo(other.minGenreSet);

        if (minGenreSetComparison != 0)
        {
            return minGenreSetComparison;
        }

        int maxGenreSetComparison =
            this.maxGenreSet.compareTo(other.maxGenreSet);

        if (maxGenreSetComparison != 0)
        {
            return maxGenreSetComparison;
        }

        return this.name.compareTo(other.name);
    }


    /**
     * Gets the number of songs currently in this playlist.
     *
     * @return The number of songs in the playlist.
     */
    public int getNumberOfSongs()
    {
        return numberOfSongs;
    }


    /**
     * Adds a new song to this playlist if it's not full and qualifies based on
     * genre criteria.
     *
     * @param newSong
     *            The song to add to the playlist.
     * @return True if the song was added, false if it couldn't be added.
     */
    public boolean addSong(Song newSong)
    {
        if (!isFull() && isQualified(newSong))
        {
            songs[numberOfSongs] = newSong;
            numberOfSongs++;
            return true;
        }
        return false;
    }


    /**
     * Provides a string representation of this playlist.
     *
     * @return A string containing information about the playlist.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Playlist: ").append(name);
        sb.append(", # of songs: ").append(numberOfSongs);
        sb.append(" (cap: ").append(capacity).append("), Requires: ");
        sb.append("Pop:").append(minGenreSet.getPop()).append("%-")
            .append(maxGenreSet.getPop()).append("%, ");
        sb.append("Rock:").append(minGenreSet.getRock()).append("%-")
            .append(maxGenreSet.getRock()).append("%, ");
        sb.append("Country:").append(minGenreSet.getCountry()).append("%-")
            .append(maxGenreSet.getCountry()).append("%");

        return sb.toString();
    }


    /**
     * Checks if this playlist is full (reached its capacity).
     *
     * @return True if the playlist is full, false if there are available
     *             spaces.
     */
    public boolean isFull()
    {
        return (numberOfSongs == capacity);
    }


    /**
     * Compares this playlist to another object to check if they are equal.
     *
     * @param obj
     *            The object to compare to this playlist.
     * @return True if they are equal, false if they are not equal.
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }

        Playlist otherPlaylist = (Playlist)obj;

        boolean areFieldsEqual = this.name.equals(otherPlaylist.name)
            && this.minGenreSet.equals(otherPlaylist.minGenreSet)
            && this.maxGenreSet.equals(otherPlaylist.maxGenreSet)
            && this.capacity == otherPlaylist.capacity
            && this.numberOfSongs == otherPlaylist.numberOfSongs;

        return areFieldsEqual && Arrays.equals(this.songs, otherPlaylist.songs);
    }


    /**
     * Gets an array of songs in this playlist.
     *
     * @return An array containing the songs in the playlist.
     */
    public Song[] getSongs()
    {
        return songs;
    }


    /**
     * Gets the capacity of this playlist (maximum number of songs it can
     * contain).
     *
     * @return The capacity of the playlist.
     */
    public int getCapacity()
    {
        return capacity;
    }


    /**
     * Gets the name of this playlist.
     *
     * @return The name of the playlist.
     */
    public String getName()
    {
        return name;
    }


    /**
     * Checks if a given song qualifies for this playlist based on genre
     * criteria.
     *
     * @param possibleSong
     *            The song to check for qualification.
     * @return True if the song is qualified for the playlist, false if it's
     *             not.
     */
    public boolean isQualified(Song possibleSong)
    {
        return possibleSong.getGenreSet()
            .isWithinRange(minGenreSet, maxGenreSet);
    }
}
