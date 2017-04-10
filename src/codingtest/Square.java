package codingtest;

public class Square {
    public int solution1(int A, int B) {
		int i = 1;
		int pow = 0, count = 0;
		
		if (A < 0) A = 0;
		if (B <= 0) {
			return 0;
		} else {
			i = (int) Math.sqrt(A);
//			pow = (int) Math.pow(i, 2);

			while (pow <= B) {
				pow = (int) Math.pow(i, 2);
				if (pow >= A) ++count;
				++i;
			}
			return count;
		}
    }
    
	public static void main(String[] args) {
		System.out.println();
	}
}
