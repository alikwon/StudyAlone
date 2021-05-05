package algorithm;

/*
● 자연수 뒤집어 배열로 만들기

[문제 설명]
	자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 
	예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

[제한사항]
	- n은 10,000,000,000이하인 자연수입니다.
*/
public class Day210505_1 {
	public int[] solution(long n) {
        int[] answer = {};
        int length = (int)(Math.log10(n)+1); //int형의 자릿수 구하는방법
		answer = new int[length];
		for	(int i = 0; i < answer.length ; i++) {
			long s = n%10;
			answer[i] = (int)s;
			n /= 10;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Day210505_1 d = new Day210505_1();
		int[]arr = d.solution(12345);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
