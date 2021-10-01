package algorithm;

/*
● 없는 숫자 더하기


[문제 설명]
	0부터 9까지의 숫자 중 일부가 들어있는 배열 numbers가 매개변수로 주어집니다. 
	numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 
	더한 수를 return 하도록 solution 함수를 완성해주세요.
	 		
[제한사항]
	- 1 ≤ numbers의 길이 ≤ 9
	- 0 ≤ numbers의 모든 수 ≤ 9
	- numbers의 모든 수는 서로 다릅니다.
	
*/
public class Day211001_5 {
	public int solution(int[] numbers) {
		int answer = 0;
		for (int i = 0; i < 10; i++) {
			boolean contain = false;
			for (int j = 0; j < numbers.length; j++) {
				if(i == numbers[j]) {
					contain = true;
					break;
				}
			}
			if(!contain) {
				answer += i;
			}
		}
		return answer;
	}
	
	public int solution2(int[] numbers) {
		int answer = 45;
		for (int i : numbers) {
			answer -= i;
		}
		return answer;
	}

	public static void main(String[] args) {
		Day211001_5 d = new Day211001_5();
		int[] arr = { 1, 2, 3, 4, 6, 7, 8, 0 };

		System.out.println(d.solution(arr));
	}
}
