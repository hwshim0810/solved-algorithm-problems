package backAlgo;

import java.util.Scanner;
/**
 * 문제
상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다. 설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.

상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다. 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만, 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.

상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)

출력
상근이가 배달하는 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.

예제 입력  복사
18
예제 출력  복사
4
 *
 */
public class T2839_SugarDelivery {
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int n = scan.nextInt();
			int res = 0;
			int min = Integer.MAX_VALUE;
			
			if (n % 5 == 0) {
				res += n / 5;
				min = res;
			}
			if (n % 3 == 0) {
				res += n / 3;
				min = res;
			}
			
		    int k = 1;
		    while (true) {
		        int t_n = n;
		        res = 0;
		        res += k;
		        t_n = n - (5 * k);

		        if (t_n < 0)
		            break;
		 
		        res += t_n / 3;
		        t_n = t_n % 3;

		        if (min > res && t_n == 0)
		            min = res;
		 
		        ++k;
		    }
		    

		    k = 1;
		    while (true) {
		        int t_n = n;
		        res = 0;
		        res += k;
		        t_n = n - (3 * k);
		 
		        if (t_n < 0)
		            break;
		 
		        res += t_n / 5;
		        t_n = t_n % 5;
		 
		        if (min > res && t_n == 0)
		            min = res;
		 
		        k++;
		    }
		 
		    if (min == Integer.MAX_VALUE) System.out.println(-1);
		    else System.out.println(min);
		}
	}
}
