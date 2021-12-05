package algorithm;

import java.util.LinkedList;

/*
● 주식가격

[문제 설명]
	초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 
	가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
		
[제한사항]
	- prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
	- prices의 길이는 2 이상 100,000 이하입니다.
*/
public class Day211205_3 {

	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i : prices) {
			list.add(i);
		}

		int idx = 0;
		while (!list.isEmpty()) {
			int time = 0;
			int price = list.poll();
			for (int i = idx + 1; i < prices.length; i++) {
				time++;
				if (prices[i] < price) {
					answer[i] = time;
					break;
				}

			}
			answer[idx] = time;
			idx++;
		}
		return answer;
	}

	public int[] solution2(int[] prices) {
		int len = prices.length;
		int[] answer = new int[len];
		int time = 0;
		for (int idx = 0, price = 0; idx < len; idx++, time = 0) {
			price = prices[idx];
			for (int i = idx + 1; i < len; i++) {
				time++;
				if (prices[i] < price) {
					answer[i] = time;
					break;
				}

			}
			answer[idx] = time;
		}
		return answer;
	}

	public static void main(String[] args) {
		Day211205_3 d = new Day211205_3();
		int[] prices = { 1, 2, 3, 2, 3 }; // [4, 3, 1, 1, 0]

		int[] answer = d.solution2(prices);

		for (int i : answer) {
			System.out.print(i + " ");
		}
	}
}