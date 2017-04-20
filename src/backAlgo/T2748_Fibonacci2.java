package backAlgo;

import java.util.HashMap;
import java.util.Scanner;
/**
 * 문제
피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.

이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n>=2)가 된다.

n=17일때 까지 피보나치 수를 써보면 다음과 같다.

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597

n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 n이 주어진다. n은 90보다 작거나 같은 자연수이다.

출력
첫째 줄에 n번째 피보나치 수를 출력한다.

예제 입력  복사
10
예제 출력  복사
55
 * @see https://www.acmicpc.net/problem/2748
 */
public class T2748_Fibonacci2 {
	private static HashMap<Integer, Long> memo = new HashMap<>();

	public static long fibonacci(int num) {
		if (memo.containsKey(num)) {
			return memo.get(num);
		} else {
			long result = fibonacci(num - 1) + fibonacci(num - 2);
			memo.put(num, result);
			return result;
		}
	}

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int num = scan.nextInt();
			
			memo.clear();
			memo.put(0, (long) 0);
			memo.put(1, (long) 1);
			System.out.println(fibonacci(num));
		}
	}
}
