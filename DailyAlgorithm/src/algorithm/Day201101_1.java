package algorithm;

import java.util.ArrayList;

/*
● 3진법 뒤집기
	[문제 설명]
		자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 
		이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
	
	[제한사항]
		n은 1 이상 100,000,000 이하인 자연수입니다.
*/
public class Day201101_1 {

	public int solution(int n) {
		int result = 0;
		int a = 3;
		ArrayList<Integer>tmp = new ArrayList<Integer>();
		while(n>0) {
			tmp.add(n%a);
			n/=a;
		}
//		for (int i = tmp.size()-1,j=1; i >= 0; i--,j*=3) {
//			result+=tmp.get(i)*j;
//		}
		for (int i = 0; i < tmp.size(); i++) {
			result*=3;
			result+=tmp.get(i);
		}
		return result;
	}

	
	public static void main(String[] args) {
		Day201101_1 d = new Day201101_1();
		int n = 45;
		System.out.println(d.solution(n));
	}
}


















