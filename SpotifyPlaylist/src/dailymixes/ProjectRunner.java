// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Prakhar Pandey (prakhar28)

package dailymixes;

import java.io.FileNotFoundException;
import java.text.ParseException;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author Prakhar Pandey
 * @version 06-Nov-2023
 */
public class ProjectRunner
{
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @param args
     * @throws ParseException
     * @throws DailyMixDataException
     * @throws FileNotFoundException
     */
    public static void main(String[] args)
        throws ParseException,
        DailyMixDataException,
        FileNotFoundException
    {
        PlaylistReader reader;

        if (args.length == 2)
        {

            reader = new PlaylistReader(args[0], args[1]);

        }
        else
        {
            reader = new PlaylistReader("input.txt", "playlists.txt");
        }

    }
}
