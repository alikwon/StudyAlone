package algorithm;

import java.util.ArrayList;

/*
-문제 설명
	두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, 
	solution을 완성해 보세요. 
	배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 
	예를 들어 두 수 3, 12의 최대공약수는 3, 
	최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

- 제한 사항
	두 수는 1이상 1000000이하의 자연수입니다.
*/
public class Day201021_3 {
	// 유클리드 호재법
	public static int[] solution(int n, int m) {
		int[] result = new int[2];
		int a = n;
		int b = m;
		while (m != 0) {
			int r = n % m;
			n = m;
			m = r;
		}
		result[0] = n;
		result[1] = a * b / result[0];	
		return result;
	}

	// 내가한거...부끄
	public static int[] solution2(int n, int m) {
		int[] result = new int[2];
		int a = n;
		int b = m;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i <= m / 2; i++) {
			if (m % i == 0)
				list.add(i);
		}
		list.add(b);
		for (int i = 0; i < list.size(); i++) {
			if (a % list.get(i) == 0) {
				n = list.get(i);
			}
		}
		result[0] = n;
		result[1] = a * b / n;
		System.out.println(result[0] + "," + result[1]);
		return result;
	}

	// 다른사람 코드,, 재귀함수 씹오짐
	public int[] solution3(int a, int b) {
		int[] answer = new int[2];
		answer[0] = gcd(a, b);
		answer[1] = (a * b) / answer[0];
		return answer;
	}

	public static int gcd(int p, int q) {
		if (q == 0)
			return p;
		return gcd(q, p % q);
	}

	public static void main(String[] args) {
		int n = 3;
		int m = 12;
		solution2(n, m);
	}
}
