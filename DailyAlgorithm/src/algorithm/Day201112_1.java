package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
● 단어공부

[문제]
알파벳 대소문자로 된 단어가 주어지면, 
이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 
단, 대문자와 소문자를 구분하지 않는다.

[입력]
첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 
주어지는 단어의 길이는 1,000,000을 넘지 않는다.

[출력]
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 
단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.


*/
public class Day201112_1 {
	private void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		int[] arr = new int[26];
		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 'A'] += 1;
		}
		int max = arr[0];
		int result = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				result = i;
			} else if (max == arr[i]) {
				result = -2;
			}
		}
		System.out.println((char) (result + 65));
		br.close();
	}

	public static void main(String[] args) throws Exception {
		Day201112_1 d = new Day201112_1();
		d.solution();
	}
}
