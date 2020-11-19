package algorithm;

import java.util.Set;
import java.util.TreeSet;

/*
● 소수 찾기

[문제 설명]
	한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 
	흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
	
	각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 
	종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
		
[제한사항]
	- numbers는 길이 1 이상 7 이하인 문자열입니다.
	- numbers는 0~9까지 숫자만으로 이루어져 있습니다.
	- 013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
	
*/
public class Day201116_1 {
	public int solution(String num) {
		Set<Integer> set = new TreeSet<>();
		int answer = 0;
		String[] s = num.split("");
		for (int i = 1; i <= s.length; i++) {
			permutation(s, 0, i, set);
		}
		for (int n : set) {
			if (isPrime(n)) {
				answer++;
			}
		}
		return answer;
	}

	private void permutation(String[] s, int depth, int r, Set<Integer> set) {
		StringBuilder sb = new StringBuilder();
		if (depth == r) {
			for (int i = 0; i < r; i++) {
				sb.append(s[i]);
			}
//			System.out.println("sb:" + sb.toString());
//			System.out.println();
			set.add(Integer.parseInt(sb.toString()));
			return;
		}

		for (int i = depth; i < s.length; i++) {
			String tmp = s[depth];
			s[depth] = s[i];
			s[i] = tmp;
//			System.out.print(depth+": ");
//			System.out.println(Arrays.toString(s));
			permutation(s, depth + 1, r, set);

			// 스왑한거 다시 되돌리기
			s[i] = s[depth];
			s[depth] = tmp;
		}
	}

	private boolean isPrime(int n) {
		if (n < 2)
			return false;
		if (n < 4)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i * i <= n; i += 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		Day201116_1 d = new Day201116_1();
		String num = "012";
		System.out.println(d.solution(num));
	}
}
