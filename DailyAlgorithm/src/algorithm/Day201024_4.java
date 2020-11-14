package algorithm;

import java.util.Arrays;

/*
● 두 정수 사이의 합

	문제 설명
		두 정수 a, b가 주어졌을 때 a와 b 사이에 속한 모든 정수의 합을 리턴하는 함수, 
		solution을 완성하세요.
		
		예를 들어 a = 3, b = 5인 경우, 3 + 4 + 5 = 12이므로 12를 리턴합니다.
	
	제한 조건
		- a와 b가 같은 경우는 둘 중 아무 수나 리턴하세요.
		- a와 b는 -10,000,000 이상 10,000,000 이하인 정수입니다.
		- a와 b의 대소관계는 정해져있지 않습니다.
*/
public class Day201024_4 {

	// for문
	public long solution(int a, int b) {
		long sum = 0;
		int big = a > b ? a : b;
		int small = big == a ? b : a;
		for (int i = small; i <= big; i++)
			sum += i;
		return sum;
	}

	// 등차수열공식 이용
	// (n-m+1)(m+n)/2
	// https://shcoachstorage.s3.amazonaws.com/media/timeline/post/2018/4/20/post_img_61b0b1a9275b4303aa2c002e62452013.png
	// 훨씬 빠름...
	public long solution2(int a, int b) {
		return a < b ? sum(a, b) : sum(b, a);
	}

	private long sum(long a, long b) {
		return (b - a + 1) * (a + b) / 2;
	}

	public static void main(String[] args) {
		Day201024_4 d = new Day201024_4();
		System.out.println(d.solution(3, 5));
	}

}
