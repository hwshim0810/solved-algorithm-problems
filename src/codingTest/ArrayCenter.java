package codingTest;

import java.util.Scanner;
/**
 * [A1][A2]....[An]으로 이루어진 배열이 있다. 이 배열에서 다음의 조건을 만족하는 요소 Ai가 있는지 검사하는 프로그램을 작성하시오
1. Ai의 왼쪽에 있는 요소들의 합과 오른쪽에 있는 요소들의 합이 동일하다. 
2. 왼쪽이나 오른쪽에 요소가 없다면 (A1이거나 An이라면) 합은 0으로 간주한다. 

즉 [A1] + [A2].... [Ai-1] = [Ai+1] + [Ai+2] + [An] 

입력 
첫 번째 줄에 테스트 케이스의 수를 입력한다. 
각 테스트 케이스에서 첫번째 줄은 배열의 크기 N을 그 다음 줄은 스페이스로 구분한 배열의 요소들을 입력받는다. 

출력 
각각의 테스트 케이스에 대해서 Ai가 존재하면 YES를 그렇지 않으면 No를 출력한다. 

입력 예제 #1 
2
3
1 2 3
4
1 2 3 3

출력 예제 #1
NO
YES

예제 설명 #1 
첫번째 케이스에서는 만족하는 것을 찾을 수 없다. 
두번째 케이스에서는 A[1] + A[2] = A[4]이다.


가산섬 

왼편, 오른편의 합을 구할 때 처리 속도를 빠르게 처리하면 가산점이 있습니다.
 *
 */
//
// 문제제목 : 2. 배열의 무게 중심
//- 입력된 숫자의 총 합이 반씩 나눠지면 중심이 맞춰졌다고 가정
//- 두 항을 더해가며 절반이 되었는지 비교
//- 두 항중 하나의 항은 반으로 나누어봐야하기때문에 값을 입력받을 때 모두 짝수로 변경
//
public class ArrayCenter {
	static boolean solveMeFirst(int[] arr, int sum) {
		int left = 0; // 왼쪽항의 합
		boolean flag = false; // 성립여부
		
		int half = sum / 2; // 목표값: 절반
		for (int j = 0, n = arr.length - 1; j < n;) {
			left += arr[j];
			int next = arr[++j] / 2;
			left += next;	// 두개의 항을 더해가며 비교
			
			if (left == half) {
				flag = true;
				break;
			} else {
				// 아닌경우 절반값은 제거
				left -= next;
			}
		}
		return flag;
	}
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int T = scan.nextInt();
			
			for (int i = 0; i < T; i++) {
				int len = scan.nextInt();
				int[] arr = new int[len];
				int sum = 0;	//총 합
				
				for (int j = 0; j < len; j++) {
					arr[j] = (scan.nextInt() * 2);	//짝수로 만듬
					sum += arr[j];	//총 합계산
				}
				
//				int right = 0;
//				for (int k = 1; k < arr.length-1; k++) {
//					for (int m = 0; m < k; m++) left += arr[m];
//					for (int n = k+1; n < arr.length; n++) right += arr[n];
//					
//					if (left == right) {
//						flag = true;
//						break;
//					}
//					left = 0; 
//					right = 0;
//				}
	
				if (solveMeFirst(arr, sum)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
}
