package backAlgo;

import java.util.HashSet;
import java.util.Random;

public class T10947_Lotto {
	public static void main(String[] args) {
		Random random = new Random();
		HashSet<Integer> set = new HashSet<>();

		while (set.size() < 6) 
			set.add(random.nextInt(45) + 1);
		
		for (int num : set) System.out.print(num + " ");
	}
}
