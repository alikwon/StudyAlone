package algorithm;

/*
● 숫자 문자열과 영단어


[문제 설명]
	네오와 프로도가 숫자놀이를 하고 있습니다. 
	네오가 프로도에게 숫자를 건넬 때 
	일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.

	다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.

	1478 → "one4seveneight"
	234567 → "23four5six7"
	10203 → "1zerotwozero3"
	
	이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 
	혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다. 
	s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.
	 		
[제한사항]
	- 1 ≤ s의 길이 ≤ 50
	- s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
	- return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.
	
*/
public class Day211001_4 {
	public int solution(String s) {

		String[] words = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		StringBuffer answer = new StringBuffer();
		StringBuffer sb = new StringBuffer();
		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 58) {
				answer.append(arr[i]);
			} else {
				sb.append(arr[i]);
			}
			if (sb.length() < 3)
				continue;
			
			for (int j = 0; j < words.length; j++) {
				if (words[j].equals(sb.toString())) {
					answer.append(j);
					sb.delete(0, sb.length());
					break;
				}
			}
		}
		return Integer.parseInt(answer.toString());
	}

	public int solution2(String s) {

		String[] words = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		for (int i = 0; i < words.length; i++) {
			s = s.replaceAll(words[i], String.valueOf(i));
		}
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		Day211001_4 d = new Day211001_4();
		String s = "one4seveneight";

		System.out.println(d.solution(s));
	}
}
