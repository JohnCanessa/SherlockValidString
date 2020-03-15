import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;

/**
 * 
 */
public class Solution {

    /**
     * Generate a sorted array of frequencies (no zero entries)
     */
    static int[] stringCharFreq(String s) {

        // **** ****
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        // **** get frequencies of characters ****
        for (char ch : s.toCharArray())
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);

        // **** create empty array of non-zero frequencies ****
        int[] freq = new int[hm.size()];

        // **** populate the array of frequencies ****
        Iterator<Entry<Character, Integer>> it = hm.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Entry<Character, Integer> e = it.next();
            freq[i++] = e.getValue();
        }

        // **** sort the frequency array ****
        Arrays.sort(freq);

        // **** return sorted frequency array ****
        return freq;
    }


    /**
     * Compute median of specified array of integers.
     * !!! NOT USED IN THE SOLUTION !!!
     */
    static double computeMedian(int[] f) {

        // **** sort the frequency array ****
        Arrays.sort(f);

        // **** compute median ****
        if (f.length % 2 == 0)
            return (f[f.length / 2 - 1] + f[f.length / 2]) / 2.0;
        else
            return f[f.length / 2];
    }


    /**
     * Complete the isValid function below.
     * Using single array.
     */
    static String isValid(String s) {

        // **** sanity check ****
        if (s != null && s.length() <= 1)
            return "YES";

        // **** generate a sorted frequency array ****
        int[] freq = stringCharFreq(s);

        // **** for ease of use ****
        int min = freq[0];
        int postMin = freq[1];
        int max = freq[freq.length - 1];
        int prevMax = freq[freq.length - 2];

        // **** check min == max ****
        if (min == max)
            return "YES";

        // **** first frequency is 1 and the rest are equal ****
        if (min == 1 && postMin == max)
            return "YES";

        // **** all frequencies the same except last ****
        if (min == postMin && min == prevMax && max == prevMax + 1)
            return "YES";

        // **** this is not a valid string ****
        return "NO";
    }


    // **** open scanner ****
    static Scanner sc = new Scanner(System.in);

    
    /**
     * Test scaffolding.
     */
    public static void main(String[] args) {
        
        // **** read the number of strings to process ****
        int n = Integer.parseInt(sc.nextLine().trim());

        // **** loop reading strings ****
        for (int i = 0; i < n; i++) {

            // **** read the next string ****
            String s = sc.nextLine().trim();

            // **** process string and display result ****
            System.out.println(isValid(s));
        }

        // **** close scanner ****
        sc.close();
    }
}