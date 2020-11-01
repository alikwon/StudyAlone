package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
● 가장 큰 수
	문제 설명
		0 또는 양의 정수가 주어졌을 때, 
		정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
		
		예를 들어, 주어진 정수가 [6, 10, 2]라면 
		[6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 
		이 중 가장 큰 수는 6210입니다.
		
		0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 
		순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 
		solution 함수를 작성해주세요.
	
	제한 사항
		- numbers의 길이는 1 이상 100,000 이하입니다.
		- numbers의 원소는 0 이상 1,000 이하입니다.
		- 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
*/
public class Day201029_1 {

	public String solution3(int[]numbers) {
		ArrayList<String>list=new ArrayList<String>();
		for(int n:numbers) {
			list.add(String.valueOf(n));
		}
		Collections.sort(list,new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return (b+a).compareTo(a+b);
			}
		});
//		Collections.sort(list,(a,b)->{
//			return (b+a).compareTo(a+b);
//		});
		
		StringBuffer sb = new StringBuffer();
		for(String s:list) {
			sb.append(s);
		}
		if(sb.toString().charAt(0)=='0') return "0";
		return sb.toString();
	}
	
	
	
	public String solution(int[] numbers) {
		String answer = "";
		String[] arr = new String[numbers.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = "" + numbers[i];
		}
//		Arrays.sort(arr, new Comparator<String>() {
//			@Override
//			public int compare(String o1, String o2) {
//				return (o2 + o1).compareTo(o1 + o2);
//			}
//		});
		Arrays.sort(arr, (a,b)->{
			return (b+a).compareTo(a+b);
		});
		for (int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		if (answer.charAt(0) == '0')
			return "0";
		return answer;
	}

	public String solution2(int[] numbers) {
		String answer = "";

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}
		Collections.sort(list,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String a=""+o1;
				String b=""+o2;
				return Integer.compare(Integer.parseInt(b+a), Integer.parseInt(a+b));
			}
		});
//		Collections.sort(list,(x,y)->{
//			int a= Integer.parseInt(""+y+x);
//			int b= Integer.parseInt(""+x+y);
//			return Integer.compare(a, b);
//		});
		StringBuffer sb = new StringBuffer();
		for (Integer i : list) {
			sb.append(i);
		}
		answer = sb.toString();
		if (answer.charAt(0) == '0') return "0";
		return answer;
	}

	public static void main(String[] args) {
		Day201029_1 d = new Day201029_1();
		int[] numbers1 = { 3, 9, 30, 34, 5 };
		int[] numbers2 = { 6, 10, 2 };
		int[] numbers3 = { 0, 0, 0 };
		System.out.println(d.solution3(numbers1));
	}

}
