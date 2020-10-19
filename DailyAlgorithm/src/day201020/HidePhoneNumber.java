package day201020;

//	● 핸드폰 번호 가리기
//	- 문제설명
//		프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 
//		고객들의 전화번호의 일부를 가립니다.
//		전화번호가 문자열 phone_number로 주어졌을 때, 
//		전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, 
//		solution을 완성해주세요.
//
//	- 제한 조건
//		s는 길이 4 이상, 20이하인 문자열입니다.
public class HidePhoneNumber {
	/*
	 * 1.전달받은 문자열길이(len) 2.표시할 숫자 --> 끝에서 4개의 문자(num) 3.별표시 반복횟수 (starNum=len-4)
	 */
	public String solution(String pNum) {
		// pNum의 길이
		int len = pNum.length();
		// 숫자로 표시할 부분
		String num = pNum.substring(len - 4, len);
		// 별표로 바꿀 숫자 개수
		int starNum = pNum.substring(0, len - 4).length();
		// stars은 문자열 "*"를 몇번 반복할건지에 대한 변수
		String stars = new String(new char[starNum]).replace("\0", "*");
		return stars + num;
	}

	/*
	 * 다른풀이 1. (전달받은 문자열의 길이 -4)만큼 "*"을 반복 후 결과에 넣고 2. 뒤에 끝 4개 문자를 붙여줌
	 */
	public String solution2(String pNum) {
		String answer = "";
		int len = pNum.length();
		for (int i = 0; i < len - 4; i++) {
			answer += "*";
		}
		answer += pNum.substring(len - 4, len);
		return answer;
	}
	
	public String solution3(String pNum) {
		String answer = "";
		int len = pNum.length();
		answer = pNum.substring(0, len - 4).replaceAll(".", "*") + 
				pNum.substring(len - 4, len);
		return answer;
	}

	/*
	 * 다른사람 풀이
	 */
	public String solution4(String pNum) {
		char[] a = pNum.toCharArray();
		for (int i = 0; i < a.length - 4; i++) {
			a[i] = '*';
		}
		return String.valueOf(a);
	}

	public static void main(String[] args) {
		HidePhoneNumber hp = new HidePhoneNumber();
		String pNum = "01031986937";
		System.out.println(hp.solution4(pNum));
	}

}
