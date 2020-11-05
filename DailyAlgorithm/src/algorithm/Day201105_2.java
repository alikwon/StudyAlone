package algorithm;

import java.util.Arrays;
import java.util.Comparator;

/*
● 문자열 내림차순으로 배치하기

	[문제 설명]
		문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수,
		solution을 완성해주세요.
		s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
	
	[제한 사항]
		str은 길이 1 이상인 문자열입니다.
*/
public class Day201105_2 {

	public String solution(String s) {
		String[] arr = s.split("");
		Arrays.sort(arr);
		StringBuffer sb = new StringBuffer();
		for (int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}

	public String solution2(String s) {
		char[]arr=s.toCharArray();
		Arrays.sort(arr);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		return sb.reverse().toString();
	}
	
	public String solution3(String s) {
		char[]arr=s.toCharArray();
		Arrays.sort(arr);
		return new StringBuffer(new String(arr)).reverse().toString();
	}

	public static void main(String[] args) {
		Day201105_2 d = new Day201105_2();
		String s = "Zbcdefg";
		System.out.println(d.solution2(s));
	}
}
