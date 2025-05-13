package fr.diginamic.geoff.utils;

import java.util.Scanner;

public class InputHelper
{
    public static int askUser(Scanner sc)
    {
        while (true)
        {
            sc.nextLine();
            try
            {
                return sc.nextInt();
            } catch (Exception e)
            {
                System.out.println("input a valid number");
            }
        }
    }
}