package backAlgo;

import java.util.Random;

public class T12091_Eve {
	public static void main(String[] args) {
		Random random = new Random();
		String[] arr = {"Vaporeon", "Jolteon", "Flareon"};
		System.out.println(arr[random.nextInt(3)]);
	}
}
