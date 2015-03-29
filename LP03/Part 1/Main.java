package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        String input = GetInput() /*"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."*/;

        String[] splitedString = SplitSentenceIntoWords(input);
        Hashtable<String, Integer> countedWords = MapArrayToDictionary(splitedString);

        PrintHashTable("Sentense has next words: ", countedWords);
    }

    private static void PrintHashTable(String title, Hashtable<String, Integer> hashtable)
    {
        System.out.println(title);

        for (String key : hashtable.keySet())
        {
            System.out.print("  " + key.toLowerCase() + " : " + hashtable.get(key) + "\n");
        }
    }

    private static Hashtable<String, Integer> MapArrayToDictionary(String[] array)
    {
        Hashtable<String, Integer> result = new Hashtable<String, Integer>();

        for (String item : array)
        {
            int valueToPut;
            if (result.containsKey(item))
            {
                valueToPut = result.get(item) + 1;
            }
            else
            {
                valueToPut = 1;
            }

            result.put(item, valueToPut);
        }

        return result;
    }

    private static String[] SplitSentenceIntoWords(String sentense)
    {
        return sentense.split("\\W+");
    }

    private static String GetInput() throws IOException
    {
        System.out.print("Enter string: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
}
