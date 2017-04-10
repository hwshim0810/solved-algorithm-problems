package codingtest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;

/**
 * 알파벳 소문자로만 이루어진 문자열 w가 있다. w의 문자들을 재 조합해서 또다른 문자열 s를 만드는데 s는 w보다 그 크기가 크다. 
(크기가 크다는 것은 사전 편찬 식으로 정렬했을 때 s가 w보다 뒤에 위치하게 된다는 의미이다.)

입력 
첫출에 테스트할 횟수 t를 입력받는다. 
그 다음 줄 부터 문자열 w를 입력받는다. 

출력
각각의 테스트 케이스에 대해서 s를 출력한다. s가 여러개일 경우 그 중 가장 작은 것을 출력한다. 
답이 존재하지 않으면 "no answer"를 출력한다. 

제한 
1 <= t <= 10^5 
1 <= (w의 길이) <= 100 
w는 알파벳 소문자로만 이루어져있으며, 길이가 100을 초과하지 않는다. 

입력 예제 #1
3
ab
bb
hefg

출력 예제 #1
ba
no answer
hegf

입력 예제 #2
15
zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgmw
zyyxwwtrrnmlggfeb
ocsmerkgidvddsazqxjbqlrrxcotrnfvtnlutlfcafdlwiismslaytqdbvlmcpapfbmzxmftrkkqvkpflxpezzapllerxyzlcf
biehzcmjckznhwrfgglverxsezxuqpj
rebjvsszebhehuojrkkhszxltyqfdvayusylgmgkdivzlpmmtvbsavxvydldmsym
unpzhmbgrrs
jprfovzkdlmdcesdcpdchcwoedjchcovklhrhlzfeeptoewcqpxg
ywsfmynmiylcjgrfrrmtyeeykffzkuphpajndwxjteyjba
dkuashjzsdq
gwakhcpkolybihkmxyecrdhsvycjrljajlmlqgpcnmvvkjlkvdowzdfikh
nebsajjbbuifimjpdcqfygeitief
qetpicxagjkydehfnvfxrtigljlheulcsfidjjozbsnomygqbcmpffwswptbgkzrbgqwnczrcfynjmhebfbgseuhckbtuynvbo
xuqfobndhsnsztifmqpnencxkllnpmbfqihtgdgxjhsvitlgtodhcydfb
xqdwkjpkmrvkfnztozzlqtuxzxyxwowf
yewluyxiwiprnajrtkeilolkmqidazhiar

출력 예제 #2
zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgwm no answer ocsmerkgidvddsazqxjbqlrrxcotrnfvtnlutlfcafdlwiismslaytqdbvlmcpapfbmzxmftrkkqvkpflxpezzapllerxyzlfc biehzcmjckznhwrfgglverxsjepquxz rebjvsszebhehuojrkkhszxltyqfdvayusylgmgkdivzlpmmtvbsavxvydldmyms unpzhmbgrsr jprfovzkdlmdcesdcpdchcwoedjchcovklhrhlzfeeptoewcqxgp ywsfmynmiylcjgrfrrmtyeeykffzkuphpajndwxjtjabey dkuashjzsqd gwakhcpkolybihkmxyecrdhsvycjrljajlmlqgpcnmvvkjlkvdowzdfkhi nebsajjbbuifimjpdcqfygeitife qetpicxagjkydehfnvfxrtigljlheulcsfidjjozbsnomygqbcmpffwswptbgkzrbgqwnczrcfynjmhebfbgseuhckbtuynvob xuqfobndhsnsztifmqpnencxkllnpmbfqihtgdgxjhsvitlgtodhcyfbd xqdwkjpkmrvkfnztozzlqtuxzxyxwwfo yewluyxiwiprnajrtkeilolkmqidazhira
 *
 */
//
// 문제제목 : 5. 더 큰 문자열
//- 읽어들인 문자열을 뒤쪽부터 두개씩 비교하며 비교하는 두 글자에서 뒷글자가 사전순 뒤쪽글자일 경우에
//  알고리즘을 실행하고 출력. 뒤쪽글자가 아닌 경우는 비교한 글자의 뒷글자를 리스트에 추가해서 보존
//
public class BiggerString {
	public static void main(String[] args) {
		try(Scanner scan = new Scanner(System.in)) {
			int T = Integer.parseInt(scan.nextLine());
			
			for (int i = 0; i < T; i++) {
				String w = scan.nextLine();
				char[] wArr = w.toCharArray();	//읽은 문자열을 char배열로 변환
				int wLen = wArr.length;
				int flag = 0;

				//1글자인경우 답이없는것으로 간주
				if (wLen == 1) {
					System.out.print("no answer");
					continue;
				}
				
				//모두 같은 글자인경우 답이없는것으로 간주
				char head = wArr[0];
				for (int j = 1; j < wLen; j++)
					if (head == wArr[j]) ++flag;
				
				if (wLen == flag+1) {
					System.out.print("no answer");
					continue;
				}
				
				//글자 변경 후 뒤쪽에 정렬한 글자를 저장하는 리스트
				List<Character> list = new ArrayList<>();
				int point = 0;
				//끝에서부터 두글자씩 비교하면서 이동
				for (int j = wLen-1; j >= 0;) {
					//첫글자까지 온 경우 첫글자를 추가하고 빠져나감
					if (j == 0)  {
						list.add(wArr[0]);
						break;
					}
					
					// 뒷글자 / 앞글자
					char back = wArr[j];
					char front = wArr[--j];
					
					// 뒷글자가 사전순으로 뒤쪽인 경우
					if (back > front) {
						// 바뀔 위치의 뒷글자들 중 앞글자보다 사전순보다 뒤쪽이면서 가장 사전순으로 앞서는 글자 추출
						list.add(back);
						
						OptionalInt min = list.stream()
						.mapToInt(c -> c)
						.filter(c -> c > front)
						.min();
						
						// 비교한 글자중 앞쪽을 최소값으로 변경후 남은글자 리스트에서 삭제
						wArr[j] = (char) min.getAsInt();
						for (int k = 0; k < list.size(); ++k)
							if (list.get(k) == wArr[j]) list.remove(k);
						// 변경위치 저장
						point = j;
						
						// 뒤쪽에 붙일 글자들을 오름차순으로 정렬
						list.add(front);
						list.sort(Comparator.naturalOrder());
						break;
					} else {
						// 비교 후 사전순 뒤쪽이 아니라면 뒷글자만 추가
						list.add(back);
					}
				}
				
				// 변경없이 왔다면 글자수와 리스트크기가 일치
				if (list.size() == wLen) {
					System.out.println("no answer");
				} else {
					// 변경위치 까지 잘라낸 후 리스트의 글자들을 뒤쪽에 추가
					StringBuffer buf = 
							new StringBuffer(String.valueOf(wArr).substring(0, point+1));
					for (char c : list)
						buf.append(c);
					System.out.println(buf.toString());
				}
			}
		}
	}
}
