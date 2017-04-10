package codingtest;

public class StringRule {
	public static String solution2(String S) {
//		StringBuffer buf = new StringBuffer(S);
//		
//		while (true) {
//			S = buf.toString();
//			buf.setLength(0);
//			boolean flag = true;
//			int len = S.length();
//			int sum = 0;
//			
//			for (int i = 0; i < len; ++i) {
//				if (i % 2 == 0) {
//					sum += S.charAt(i);
//				} else {
//					sum += S.charAt(i);
//					switch (sum) {
//					//AB, BA, AA
//					case 130:
//					case 131:
//						buf.append("A");
//						flag = false;
//						break;
//					//BC, CB, CC
//					case 133:
//					case 134:
//						buf.append("C");
//						flag = false;
//						break;
//					default:
//						break;
//					}
//					sum = 0;
//				}
//			}
//			if (flag) break;
//		}
//		return S;
		while (true) {
			S = S.replace("AB", "A").replace("BA", "A")
				.replace("CB", "C").replace("BC", "C")
				.replace("AA", "A").replace("CC", "C");
			
			if (S.indexOf("AB") == -1 && S.indexOf("BA") == -1 &&
				S.indexOf("BC") == -1 && S.indexOf("CB") == -1 &&
				S.indexOf("CC") == -1 && S.indexOf("AA") == -1) break;
				
		}
		return S;
	}
	public static void main(String[] args) {
		solution2("BBA");
	}
}
