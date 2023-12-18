// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Prakhar Pandey (prakhar28)

package dailymixes;

// -------------------------------------------------------------------------
/**
 * This class represents a GenreSet, which contains the number of songs in
 * different genres.
 * 
 * @author Prakhar Pandey
 * @version 29-Oct-2023
 */
public class GenreSet
    implements Comparable<GenreSet>
{
    private int rock;
    private int pop;
    private int country;

    // ----------------------------------------------------------
    /**
     * Create a new GenreSet object.
     * 
     * @param rock
     *            The number of songs in the Rock genre.
     * @param pop
     *            The number of songs in the Pop genre.
     * @param country
     *            The number of songs in the Country genre.
     */
    public GenreSet(int pop, int rock, int country)
    {
        this.rock = rock;
        this.pop = pop;
        this.country = country;
    }


    // ----------------------------------------------------------
    /**
     * Get the number of songs in the Rock genre.
     * 
     * @return The number of songs in the 'Rock' genre.
     */
    public int getRock()
    {
        return rock;
    }


    // ----------------------------------------------------------
    /**
     * Get the number of songs in the Pop genre.
     * 
     * @return The number of songs in the Pop genre.
     */
    public int getPop()
    {
        return pop;
    }


    /**
     * Returns a string representation of the GenreSet object.
     * 
     * @return The string representation of the GenreSet object.
     */
    public String toString()
    {
        return "Pop:" + pop + " Rock:" + rock + " Country:" + country;
    }


    /**
     * Compares this GenreSet to the specified object for equality.
     * 
     * @param obj
     *            The object to compare with.
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
        GenreSet other = (GenreSet)obj;
        return this.pop == other.pop && this.rock == other.rock
            && this.country == other.country;
    }


    // ----------------------------------------------------------
    /**
     * Checks if this GenreSet is within the specified range defined by minimum
     * and maximum GenreSet objects.
     * 
     * @param minGenreSet
     *            The minimum GenreSet object defining the lower bound of the
     *            range.
     * @param maxGenreSet
     *            The maximum GenreSet object defining the upper bound of the
     *            range.
     * @return true if this GenreSet is within the specified range, false
     *             otherwise.
     */
    public boolean isWithinRange(GenreSet minGenreSet, GenreSet maxGenreSet)
    {
        return isLessThanOrEqualTo(maxGenreSet) && this.pop >= minGenreSet.pop
            && this.rock >= minGenreSet.rock
            && this.country >= minGenreSet.country;
    }


    // ----------------------------------------------------------
    /**
     * Checks if this GenreSet is less than or equal to the specified GenreSet
     * in terms of genre counts.
     * 
     * @param other
     *            The GenreSet to compare with.
     * @return true if this GenreSet is less than or equal to the specified
     *             GenreSet, false otherwise.
     */
    private boolean isLessThanOrEqualTo(GenreSet other)
    {
        return this.pop <= other.pop && this.rock <= other.rock
            && this.country <= other.country;
    }


    /**
     * Compares this GenreSet to another GenreSet based on the sum of genre
     * counts. A negative integer is returned if this GenreSet is less than the
     * other, a positive integer if greater, and zero if they are equal.
     * 
     * @param other
     *            The GenreSet to compare with.
     * @return -1 if this is less, 1 if this is greater, 0 if they are equal.
     */
    public int compareTo(GenreSet other)
    {
        int thisTotal = this.pop + this.rock + this.country;
        int otherTotal = other.pop + other.rock + other.country;

        if (thisTotal < otherTotal)
        {
            return -1;
        }
        else if (thisTotal > otherTotal)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }


    // ----------------------------------------------------------
    /**
     * Get the number of songs in the Country genre.
     * 
     * @return The number of songs in the Country genre.
     */
    public int getCountry()
    {
        return country;
    }
}
