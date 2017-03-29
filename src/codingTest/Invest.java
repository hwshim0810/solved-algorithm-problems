package codingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//
// 문제제목 : 4. 주식 투자
//- 읽은 가격에서 최대값을 찾고 처음부터 그 최대값 전항까지 최대값과 각 항의 차를 더해준다.
//- 최대값의 인덱스가 첫항이라면 이익이 없으므로 0출력
//- 빼 준항들을 가격리스트에서 제거하고나서 가격리스트에 남은게 없다면 총합출력
//- 남은게있다면 다시 최대값을 구하면서 반복
public class Invest {
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int T = Integer.parseInt(scan.nextLine());
			
			for (int i = 0; i < T; ++i) {
				List<Integer> prices = new ArrayList<>();

				// 읽은 가격 저장
				int N = scan.nextInt();
				for (int day = 0; day < N; ++day)
					prices.add(scan.nextInt());

				int sum = 0;
				while (true) {
					// 가격 중 최대값과 그 인덱스를 구함
					int max = prices.stream().mapToInt(Integer::valueOf).max().getAsInt();
					int maxIdx = prices.indexOf(max);
					List<Integer> willDel = new ArrayList<>();
					
					// 최대값이 첫 항일경우
					if (maxIdx == 0) {
						System.out.println(0);
						break;
					} else {
						// 최대값 전 항까지 리스트를 구함
						willDel = prices.stream().limit(maxIdx).collect(Collectors.toList());
						// 가격 리스트 갱신
						prices = prices.stream().skip(maxIdx+1).collect(Collectors.toList());
						
						// 총 합계산
						for (int frontNum : willDel)
							sum += (max - frontNum);
						
						// 반복여부 결정
						if (prices.size() == 0) {
							System.out.println(sum);
							break;
						}
					}
				}
					
			}
		}
	}
}
