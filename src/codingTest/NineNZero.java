package codingTest;

import java.util.Scanner;

/**
 * 숫자 0과 9로만 이루어진 0 이상의 정수 X가 있다. (ex: 90, 9990, 9009009) 
0이상의 정수 N이 주어졌을 때 X중 N의 배수이면서 가장 작은 수를 구하는 프로그램을 작성하시요. 

입력 
첫줄에 테스트 케이스 T를 입력 받는다. 다음 줄 부터 T줄만큼 N을 입력받는다. 

출력 
각각의 테스트 케이스에 대해서 조건 만족하는 수 X를 한줄에 하나씩 출력한다. 단 숫자 앞에 0이 와서는 안된다. 
(ex: 00999 > 999로 출력할 것) 

제한 
1 <= T <= 104 
1 <= N <= 500

입력 예제 #1
3
5
7
1

출력 예제 #1
90
9009
9

예제 설명 #1
첫번째 테스트 케이스 : 5의 배수이면서 9와 0으로만 이루어진 가장 작은 수는 90이다. 
 *
 */
//
// 문제제목 : 3. 9와 0
//- 입력받은 숫자의 배수를 계속구함
//- 구한 숫자에 9혹은0 이외의 숫자가 있을 경우 계속반복해서 배수를 구함
//- 조건에 만족하는 경우 반복문을 나와서 출력
//
public class NineNZero {
	static long solveMeFirst(long N) {
		long sum = 0;
		
		while (true) {
			sum += N;
			String tg = String.valueOf(sum);
			// 문자열을 Intstream으로 변환 후 조건을 만족하는지 확인  
			if (tg.chars().allMatch(c-> c == '9' || c == '0')) { 
				N = Long.valueOf(tg);
				break;
			}
		}
		return N;
	}
	
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int T = scan.nextInt();
			
			for (int i = 0; i < T; i++) {
				long N = (long) scan.nextInt(); // 배수가 int의 범위를 넘어갈 수 있기 때문에 long으로 선언
				System.out.println(solveMeFirst(N));
			}
		}
	}
}
