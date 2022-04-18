/*
 INSERT PROGRAM HEADER HERE
*/

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;


public class LetterDistributionTemplate {

    static final String LETTERS_IN_THE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    static final int    FIRST_LETTER            = 'a';
    static final String FILE_NAME               = "Constitution.txt";
    static final int    FRAME_WIDTH             = 1024;
    static final int    FRAME_HEIGHT            = 768;
    

    public static void main(String[] args) throws FileNotFoundException {
        //ToDo: Define two arrarys whose size is the English alphabet length
        //Call them lettersLabels (the letters of the alphbet(
        //and lettersFrequency, the percentage of occurrences of each letter
        
        String[] lettersLabels = {"a", "b", "c", "d", "e", "f", "g", "h", "i", 
        "j", "k","l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", 
         "w", "x", "y", "z"};
        
        char[] letterLabel = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
        'w', 'x', 'y', 'z'};
        
        //System.out.println(lettersLabels[1]);
        double[] lettersFrequency = new double[26];
        
        
        //Initialize both arrays with the default values
        
        

        

        
        // Set up to read a file using Scanner.  
        //It reads from a file, instead of reading from System.in (keyboard)
        //File FILE_NAME = new File("/Users/aidenminer/Desktop/Java/Project 3/Constitutions.txt");
     
        File constitution = new File(FILE_NAME);
            
        Scanner scan = new Scanner(constitution);
        
        
        int total = 0;
        while (scan.hasNextLine())
        {
            String line = scan.nextLine();
            System.out.println(line);
            for (int x = 0; x < line.length(); x += 1)
               {
                 
                  if (line.toLowerCase().charAt(x) >= 97 && line.toLowerCase().charAt(x) <= 122)
                  {
                     int s = line.toLowerCase().charAt(x) - FIRST_LETTER;
                     
                     if (line.toLowerCase().charAt(x) == letterLabel[s])
                     {
                        lettersFrequency[s] += 1;
                        
                        System.out.println(s);
                        System.out.println(lettersFrequency[s] + lettersLabels[s]);  
                         
                        total += 1;
                     }
                             
                  
                  }
                  
                }
            
          }

for (int b = 0; b <= 25; b += 1)
   {
      lettersFrequency[b] = (lettersFrequency[b] / (double)total) * 100;
          
   }
          
          
                
         
         
         
         
         
         
        
        
        
        /* 
         * While reading the file line by line.
         *    New function to learn:  hasNext(), nextLine(), toLowerCase()
         *    for the new line just read in, look for each character in the letters array
         *        if exists, increment the frequency of the character and total number variable
         * end the while-loop
         * Compute percentage for each character 
         * Display the chart using the code from BarChart.java::main()
         *    make sure you call BarChart constructor with the corresponding actual arguments
         */

         JFrame f = new JFrame();
         f.setSize(FRAME_WIDTH, FRAME_HEIGHT);
         String title = FILE_NAME.split("\\.")[0];

         BarChart chart = new BarChart(title, lettersLabels, lettersFrequency);
         f.getContentPane().add(chart);

         WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        f.addWindowListener(wndCloser);
        f.setVisible(true);
    }
}