package dailymixes;

import java.io.FileNotFoundException;
import java.text.ParseException;

// -------------------------------------------------------------------------
/**
 * The ProjectRunner class serves as the main entry point for the DailyMixes project.
 * 
 * @author Prakhar Pandey
 * @version 06-Nov-2023
 */
public class ProjectRunner
{
    // ----------------------------------------------------------
    /**
     * Initializes a PlaylistReader based on command-line arguments or default values.
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
