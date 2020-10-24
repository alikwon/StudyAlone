package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
● 나누어 떨어지는 숫자 배열
	문제 설명
		array의 각 element 중 divisor로 나누어 떨어지는 값을 
		오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
		divisor로 나누어 떨어지는 element가 하나도 없다면 
		배열에 -1을 담아 반환하세요.
	
	제한사항
		- arr은 자연수를 담은 배열입니다.
		- 정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
		- divisor는 자연수입니다.
		- array는 길이 1 이상인 배열입니다.
*/
public class Day201024_5 {
	
	//for문
	public int[] solution(int[] arr, int b) {
		int cnt=0;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%b==0)
				cnt++;
		}
		if(cnt==0) {
			int[]result = {-1};
			return result;
		}
		int index=0;
		int[]result= new int[cnt];
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%b==0) {
				result[index]=arr[i];
				index++;
			}
		}
		return result;
	}
	public int[] solution2(int[] arr, int b) {
		Arrays.sort(arr);
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%b==0) l.add(arr[i]);
		}
		int[]result=new int[l.size()];
		for (int i = 0; i < result.length; i++) {
			result[i]=l.get(i);
		}
		return result;
	}
	
	public int[] solution3(int[] array, int divisor) {
        //ret에 array에 포함된 정수중, divisor로 나누어 떨어지는 숫자를 순서대로 넣으세요.
        return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
    }
	
	public static void main(String[] args) {
		Day201024_5 d = new Day201024_5();
		int[]arr = {5,9,7,10};
		arr=d.solution2(arr,5);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
