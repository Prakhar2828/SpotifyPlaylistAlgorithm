// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Prakhar Pandey (prakhar28)

package dailymixes;

// -------------------------------------------------------------------------
/**
 * Represents a custom exception specific to DailyMixData.
 * 
 * @author Prakhar Pandey
 * @version 05-Nov-2023
 */
public class DailyMixDataException
    extends Exception
{
    // ----------------------------------------------------------
    /**
     * Constructs a new DailyMixDataException with the specified detail message.
     * 
     * @param string
     *            A descriptive message indicating the cause of the exception.
     */
    public DailyMixDataException(String string)
    {
        super(string);
    }
}
