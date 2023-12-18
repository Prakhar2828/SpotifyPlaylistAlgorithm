package dailymixes;

// -------------------------------------------------------------------------
/**
 * The `Song` class represents a musical composition with information about its
 * name, genre, and a suggested playlist.
 * 
 * @author Prakhar Pandey
 * @version 30-Oct-2023
 */
public class Song
{
    private String name;
    private String suggestedPlaylist;
    private GenreSet genreSet;

    /**
     * Creates a new Song object.
     *
     * @param name
     *            The name of the song.
     * @param pop
     *            The popularity value for the pop genre.
     * @param rock
     *            The popularity value for the rock genre.
     * @param country
     *            The popularity value for the country genre.
     * @param suggested
     *            The suggested playlist for the song.
     */
    public Song(String name, int pop, int rock, int country, String suggested)
    {
        this.name = name;
        this.suggestedPlaylist = suggested;
        genreSet = new GenreSet(pop, rock, country);
    }


    /**
     * Get the name of the song.
     *
     * @return The name of the song.
     */
    public String getPlaylistName()
    {
        return suggestedPlaylist;
    }


    /**
     * Get a string representation of the song, including name, genre
     * information, and suggested playlist if available.
     *
     * @return A string representation of the song in the format "Name
     *             Pop:Popularity Rock:Popularity Country:Popularity [Suggested:
     *             PlaylistName]" or "No-Playlist Name Pop:Popularity
     *             Rock:Popularity Country:Popularity" if no playlist is
     *             suggested.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" Pop:").append(genreSet.getPop());
        sb.append(" Rock:").append(genreSet.getRock());
        sb.append(" Country:").append(genreSet.getCountry());

        if (suggestedPlaylist.length() > 0)
        {
            sb.append(" Suggested: ").append(suggestedPlaylist);
        }
        else
        {
            sb.insert(0, "No-Playlist ");
        }

        return sb.toString();
    }


    /**
     * Compare this song to another object for equality.
     *
     * @param obj
     *            The object to compare to.
     * @return true if the objects are equal, false otherwise.
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
        Song other = (Song)obj;
        return this.name.equals(other.name)
            && this.genreSet.equals(other.genreSet)
            && this.suggestedPlaylist.equals(other.suggestedPlaylist);
    }


    /**
     * Get the genre information for the song.
     *
     * @return The GenreSet object representing the genre information.
     */
    public GenreSet getGenreSet()
    {
        return genreSet;
    }


    /**
     * Get the name for the song.
     *
     * @return The string representing the name of the song.
     */
    public String getName()
    {
        return name;
    }
}
