package backAlgo;
/**
 * 문제
새 학기를 맞아 상근이는 책을 10권 구입했다. 상근이는 의욕이 너무 앞서서 가격을 조사하지 않고 책을 구입했다. 이제 각 책의 가격을 알아보려고 한다.

하지만, 영수증에는 얼룩이 묻어있었고, 상근이는 책 10권 중 9권의 가격만 읽을 수 있었다.

책 10권의 총 가격과 가격을 읽을 수 있는 9권 가격이 주어졌을 때, 가격을 읽을 수 없는 책의 가격을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 10권의 총 가격이 주어진다. 둘째 줄부터 9개 줄에는 가격을 읽을 수 있는 책 9권의 가격이 주어진다. 책의 가격은 10000이하이다.

출력
첫째 줄에 가격을 읽을 수 없는 책의 가격을 출력한다.
@see https://www.acmicpc.net/problem/5565
 */
import java.util.Scanner;

class Receipt {

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int[] bookValue = new int[10];
			
			for(int i = 0; i < 10; i++) {
				bookValue[i] = scan.nextInt();
			}
			
			int sumValue = bookValue[0];
			
			for(int j = 1; j < 10; j++) {
				sumValue -= bookValue[j];
			}
			
			System.out.println(sumValue);
		}
	}

}
