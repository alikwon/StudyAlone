package algorithm;

/*
● 최댓값과 최솟값

[문제 설명]
	문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다. 
	str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 (최소값) (최대값)형태의 문자열을 반환하는
	함수, solution을 완성하세요.
	예를들어 
	s가 "1 2 3 4"라면 "1 4"를 리턴하고, 
	"-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
	 		
[제한사항]
	- s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
	
*/
public class Day201117_2 {

	public String solution(String s) {
		String answer = "";
		// 공백을 기준으로 배열만듦
		String[] arr = s.split(" ");
		//a와 b에 배열제일 처음 값을 넣어줌
		int a = Integer.parseInt(arr[0]);
		int b = a;
		
		//for문을 돌려서 a에는 최소값을 담고 b에는 최대값을 담는다
		for (int i = 1; i < arr.length; i++) {
			int n = Integer.parseInt(arr[i]);
			if (a > n) a = n;
			if (b < n) b = n;
		}
		answer = a + " " + b;
		return answer;
	}

	public static void main(String[] args) {
		Day201117_2 d = new Day201117_2();
		String s = "1 2 3 4";
		System.out.println(d.solution(s));
	}
}
