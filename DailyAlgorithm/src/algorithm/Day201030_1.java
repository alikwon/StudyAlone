package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/*
● 두 개 뽑아서 더하기
	문제 설명
		정수 배열 numbers가 주어집니다. 
		numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를
		 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
	
	제한사항
		- numbers의 길이는 2 이상 100 이하입니다.
		- numbers의 모든 수는 0 이상 100 이하입니다.
*/
public class Day201030_1 {

	//리스트가 더 빨랏는데 
	//테스트 6,7,8이 Set을 쓴게 더 빨랏음
	public int[] solution1(int[] arr) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int num;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				num = arr[i]+arr[j];
				if (!list.contains(num))
					list.add(num);
			}
		}
		Collections.sort(list);
		int[] answer = new int[list.size()];
		int index = 0;
		for (int n : list)
			answer[index++] = n;
		return answer;
	}

	public int[] solution2(int[] arr) {
		Set<Integer> list = new TreeSet<>();
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				list.add(arr[i] + arr[j]);
			}
		}
		int[] answer = new int[list.size()];
		int index = 0;
		for (int num : list) {
			answer[index++] = num;
		}
		return answer;
	}

	public static void main(String[] args) {
		Day201030_1 d = new Day201030_1();
		int[] arr1 = { 2, 1, 3, 4, 1 };
		int[] arr2 = { 7, 0, 2, 5 };
		for (int n : d.solution2(arr2)) {
			System.out.print(n + " ");
		}
	}
}
