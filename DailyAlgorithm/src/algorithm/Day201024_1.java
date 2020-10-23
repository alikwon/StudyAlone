package algorithm;

/*
● 이상한 문자 만들기

	문제 설명
		문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 
		각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 
		각 단어의 짝수번째 알파벳은 대문자로, 
		홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, 
		solution을 완성하세요.
	
	제한 사항
		- 문자열 전체의 짝/홀수 인덱스가 아니라, 
		    단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
		- 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
*/
public class Day201024_1 {

	public String solution(String s) {
		int index = 0;
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ')
				index = 0;
			else {
				if (index % 2 == 0 && arr[i] >= 'a' && arr[i] <= 'z') {
					arr[i] -= ' ';
				} else if (index % 2 == 1 && arr[i] >= 'A' && arr[i] <= 'Z') {
					arr[i] += ' ';
				}
				index++;
			}
		}
		return String.valueOf(arr);
	}

	public String solution2(String s) {
		int index = 0;
		s = s.toLowerCase();
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] == ' ')
//				index = 0;
//			else {
//				if (index % 2 == 0) {
//					arr[i] -= ' ';
//				}
//				index++;
//			}
			index=arr[i]==' '?0:index+1;
			arr[i]-=index%2==0?0:' ';
		}
		return String.valueOf(arr);
	}

	public String solution3(String s) {
		String answer = "";
		int index = 0;
		String[] arr = s.split("");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(" ")) {
				answer += " ";
				index = 0;
			} else {
				if (index % 2 == 0) {
					answer += arr[i].toUpperCase();
				} else {
					answer += arr[i].toLowerCase();
				}
				index++;
			}
		}
		return answer;
	}

	public String solution4(String s) {
		String answer = "";
		int index = 0;
		String[] arr = s.split("");
		for (String a : arr) {
			index = a.equals(" ") ? 0 : index + 1;
			answer += index % 2 == 1 ? a.toUpperCase() : a.toLowerCase();
		}
		return answer;
	}

	public static void main(String[] args) {
		Day201024_1 d = new Day201024_1();
		String s = "TRY HELLO WORLD";
		System.out.println(d.solution2(s));
	}

}
