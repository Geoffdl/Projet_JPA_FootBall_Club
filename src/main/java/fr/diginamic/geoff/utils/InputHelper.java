package fr.diginamic.geoff.utils;

import java.util.Scanner;

public class InputHelper
{
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