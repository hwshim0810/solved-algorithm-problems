package topcoder;

import java.util.Scanner;

public class Srm478_Kiwi {
	/**
	 * @Method Name : thePouring
	 * @param capacities : n개의 병 각각의 최대용량
	 * @param bottles : n개의 병 각각에 담긴 음료
	 * @param fromId : 옮길 병의 번호
	 * @param toId : 받을 병의 번호
	 * @return : 옮겨지고 난 후의 각각의 병에 들어있는 음료
	 */
	public static void thePouring(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
		for (int num = 0; num < toId.length; ++num) {	//받을 병만큼 반복

			int fromNum = fromId[num]; //옮길병의 번호를 순서대로 대입
			int toNum = toId[num];	// 받을 병의 번호를 순서대로 대입
			
			int sum = bottles[fromNum] + bottles[toNum];
			bottles[toNum] = Math.min(sum, capacities[toNum]);
			bottles[fromNum] = sum - bottles[toNum];
//			int moveJuice = 0;	// 옮겨가는 음료의 양
//			int toCapacities = capacities[toNum];	//받을 병의 최대용량
//
//			if (bottles[fromNum] <= toCapacities - bottles[toNum]) { //옮길 병의 음료가 받을 병의 남은 공간보다 작거나 같을때
//				bottles[toNum] += bottles[fromNum];	// 받는 병에 더해줌
//				bottles[fromNum] = 0;	//옮기고 나서 빈병이 됨
//			} else { // 그외
//				moveJuice = toCapacities - bottles[toNum];	//받을병에 남은 공간만큼 옮기기로 함
//				bottles[toNum] += moveJuice;	// 옮김
//				bottles[fromNum] -= moveJuice;	// 옮긴병에서 이동한만큼 빼줌
//			}

		}
//		return bottles;	//처리 결과를 반환
	}

	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)){
			int[] capacities = {30, 20, 10};
			int[] bottles = {10, 5, 5};
			int[] fromId = {0, 1, 2};
			int[] toId = {1, 2, 0};
			
			thePouring(capacities, bottles, fromId, toId);
			
			for (int a : bottles) 
				System.out.println(a);
		}
	}

}
