/*
problem found on: https://community.topcoder.com/stat?c=problem_statement&pm=14008
 */
package com.tylerblanton;
import static java.lang.System.out;
import java.util.*;
import java.io.*;

public class Main
{
    static class relationClassifier
    {
        //function returns spot of next instance of 'findThis'

        boolean ruinBijection(int currentIndex, int[] firstArr, int[] secondArr)
        {
            for(int i = 0; i < firstArr.length; ++i)
            {
                if(i != currentIndex)
                {
                    if(firstArr[i] == firstArr[currentIndex])       //if then have the same value in the first array
                    {
                        if(secondArr[i] == secondArr[currentIndex])     ;//if they have they same thing in the second array also, then the bijection is ruined
                        {
                            return true;        //if two x's have the same y then the bijection is ruined
                        }

                    }
                }
            }
            return false;
        }

        String isBijection(int[] domain, int[] range)
        {
            boolean isBijection = true;
            //go through x's first
            for(int i = 0; i < domain.length; ++i)
            {
                if(ruinBijection(i, domain, range) || ruinBijection(i, range, domain))
                {
                    return "Not";
                }
                else
                {
                    return "Bijection";
                }
            }
            return "Not";
        }
    }



    //MAIN
    public static void main(String[] args)
    {
        ArrayList<String> lines = new ArrayList<String>();

        try
        {
            File f = new File("input.txt");
            Scanner s = new Scanner(f);
            while(s.hasNextLine())
            {
                lines.add(s.nextLine());
            }
        }catch(FileNotFoundException e)
        {
            out.println("Could not locate file. Program terminated.");
            System.exit(1);
        }
        relationClassifier func = new relationClassifier();
        String temp = lines.get(0).substring(1, lines.get(0).length()-1);
        lines.remove(0);
        lines.add(0, temp);

        temp = lines.get(1).substring(1, lines.get(1).length()-1);
        lines.remove(1);
        lines.add(1, temp);

        String[] dStr = lines.get(0).split(", ");
        String[] rStr = lines.get(1).split(", ");
        int[] d = new int[dStr.length];
        int[] r = new int[rStr.length];

        for(int i = 0; i < dStr.length; ++i)
        {
            int strToNum = Integer.valueOf(dStr[i]);
            d[i] = strToNum;
        }
        for(int i = 0; i < rStr.length; ++i)
        {
            int strToNum = Integer.valueOf(rStr[i]);
            r[i] = strToNum;
        }

        out.println(func.isBijection(d, r));
    }
}
