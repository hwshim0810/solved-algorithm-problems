package backAlgo;

import java.util.Scanner;
/**
 * 문제
예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 다음과 같이 변경해서 입력했다.

크로아티아 알파벳	변경
č	c=
ć	c-
dž	dz=
ñ	d-
lj	lj
nj	nj
š	s=
ž	z=
예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다.

단어가 주어졌을 때, 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.

입력
첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.

문제 설명에 나와있는 크로아티아 알파벳만 주어진다.

출력
입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.

예제 입력  복사
ljes=njak
예제 출력  복사
6
 * @see https://www.acmicpc.net/problem/2941
 */
public class T2941_Croatia {
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			String res = scan.nextLine()
					.replace("c=", "c")
					.replace("c-", "c")
					.replace("dz=", "d")
					.replace("d-", "d")
					.replace("lj", "l")
					.replace("nj", "n")
					.replace("s=", "s")
					.replace("z=", "z");
			System.out.println(res.length());
		}
	}
}
