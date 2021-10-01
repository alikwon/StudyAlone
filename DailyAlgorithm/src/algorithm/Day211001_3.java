package algorithm;

import java.text.ParseException;

/*
 * 휴가기간 n이 주어질 때 
 * 가장 많이 적게 포함되는 주말 일 수와 가장 많이 포함되는 주말 일 수를 구하기
 */
public class Day211001_3 {
	public long[] solution1(long n) {
		long[] answer = { 0, 0 };
		int[] week = { 0, 0, 0, 0, 0, 1, 1 };
		int[] week2 = { 1, 1, 0, 0, 0, 0, 0 };
		long day = 0;
		while (day < n) {
			if (week[(int) (day % 7)] == 1)
				answer[0]++;
			if (week2[(int) (day % 7)] == 1)
				answer[1]++;
			day++;
		}
		return answer;
	}

	public long[] solution2(long n) {
		long[] answer = { 0, 0 };
		
		// 휴일이 가장 적을 때 --> 월요일부터 휴가 시작
		// 휴일이 가장 많을 때 --> 토요일부터 휴가 시작
		int[] week = { 0, 0, 0, 0, 0, 1, 1 };
		int[] week2 = { 1, 1, 0, 0, 0, 0, 0 };
		
		// 1. 몇 주인지 계산
		long weekCnt = n / 7;
		
		// 2. 주를 맨 나머지 일수 계산
		long leftDay = n % 7;
		
		// 3. 나머지 일수에 포함된 휴일 계산
		int cnt = 0;
		while (cnt < leftDay) {
			if (week[cnt % 7] == 1)
				answer[0]++;
			if (week2[cnt % 7] == 1)
				answer[1]++;
			cnt++;
		}
		
		// 4. 주 수만큼 휴일 더해줌
		for (int i = 0; i < answer.length; i++) {
			answer[i] += weekCnt * 2;
		}
		return answer;
	}

	public static void main(String[] args) throws ParseException {
		Day211001_3 d = new Day211001_3();
		int n = 6;
		long[] arr = d.solution2(n);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
