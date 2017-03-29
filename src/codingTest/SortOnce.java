package codingTest;

import java.util.Arrays;

public class SortOnce {
    public static boolean solution3(int[] A) {
			int count = 0;
			int[] sorted = A.clone();
			Arrays.sort(sorted);
			
			int size = A.length;
			for (int i = 0; i < size; ++i)
				if (sorted[i] != A[i]) ++count;
			
			if (count <= 2) return true;
			else return false;
    }
    
	public static void main(String[] args) {
	}
}
