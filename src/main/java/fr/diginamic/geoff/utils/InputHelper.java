package fr.diginamic.geoff.utils;

import java.util.Scanner;

/**
 * Helper class for cli user input
 */
public class InputHelper
{
    /**
     * parses user input and returns a valid integer
     *
     * @param sc scanner instance
     * @return integer
     */
    public static int askUser(Scanner sc)
    {
        while (true)
        {
            try
            {
                String line = sc.nextLine();
                return Deserializer.stringToInt(line);
            } catch (Exception e)
            {
                System.out.println("input a valid number");
                sc.nextLine();
            }
        }
    }
}