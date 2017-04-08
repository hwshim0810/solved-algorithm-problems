package codejam;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem

Tatiana likes to keep things tidy. Her toys are sorted from smallest to largest, her pencils are sorted from shortest to longest and her computers from oldest to newest. One day, when practicing her counting skills, she noticed that some integers, when written in base 10 with no leading zeroes, have their digits sorted in non-decreasing order. Some examples of this are 8, 123, 555, and 224488. She decided to call these numbers tidy. Numbers that do not have this property, like 20, 321, 495 and 999990, are not tidy.

She just finished counting all positive integers in ascending order from 1 to N. What was the last tidy number she counted?

Input

The first line of the input gives the number of test cases, T. T lines follow. Each line describes a test case with a single integer N, the last number counted by Tatiana.

Output

For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the last tidy number counted by Tatiana.

Limits

1 ≤ T ≤ 100.
Small dataset

1 ≤ N ≤ 1000.
Large dataset

1 ≤ N ≤ 1018.
Sample


Input 
 	
Output 
 
4
132
1000
7
111111111111111110

Case #1: 129
Case #2: 999
Case #3: 7
Case #4: 99999999999999999

Note that the last sample case would not appear in the Small dataset.
 * @author Hyun-Woo Shim
 *
 */

public class P_2017_QB {
	public static void main(String[] args) throws InterruptedException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("B-small-attempt0.in"));
        FileOutputStream output = new FileOutputStream("small_output.out");
        
        while(true) {
            String line = br.readLine();
            if (line == null) break;
            
            int T = Integer.valueOf(line);
            
            for (int i = 1; i <= T; ++i) {
            	String res = String.format("Case #%d: %s%n", i, eval(br.readLine()));
            	output.write(res.getBytes());
            }
            output.close();
        }
        br.close();
	}
	
	public static String eval(String input) {
		long N = Long.valueOf(input);
		
		if (N < 10) {
			return String.valueOf(N);
		} else {
			while (true) {
				char[] arr = String.valueOf(N).toCharArray();
				char prev = arr[0];
				boolean flag = false;
				
				for (char num : arr) {
					if (num < prev) {
						flag = true;
						break;
					} else {
						prev = num;
					}
				}
				
				if (flag) {
					--N;
				} else {
					return String.valueOf(N);
				}
			}
		}
	}
}
