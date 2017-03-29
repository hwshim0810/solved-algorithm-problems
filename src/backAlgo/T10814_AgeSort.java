package backAlgo;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class T10814_AgeSort {
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int rpt = Integer.parseInt(scan.nextLine());
			
			Map<Integer, Entry<Integer, String>> mem = new HashMap<>();
			
			for (int i = 0; i < rpt; i++) {
				String[] temp = scan.nextLine().split(" ");
				Entry<Integer, String> entry =
					    new AbstractMap.SimpleEntry<Integer, String>(Integer.parseInt(temp[0]), temp[1]);
				mem.put(i, entry);
			}
			
	    }
	}
}
