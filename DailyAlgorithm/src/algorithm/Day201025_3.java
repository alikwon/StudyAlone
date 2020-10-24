package algorithm;

import java.util.Arrays;

/*
● K번째수
	문제 설명
		배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, 
		k번째에 있는 수를 구하려 합니다.
		
		예를 들어 
		array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
		
		1.array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
		2.1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
		3.2에서 나온 배열의 3번째 숫자는 5입니다.
		
		배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 
		매개변수로 주어질 때, commands의 모든 원소에 대해 
		앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 
		solution 함수를 작성해주세요.
	
	제한사항
		- array의 길이는 1 이상 100 이하입니다.
		- array의 각 원소는 1 이상 100 이하입니다.
		- commands의 길이는 1 이상 50 이하입니다.
		- commands의 각 원소는 길이가 3입니다.
*/
public class Day201025_3 {

	public int[] solution(int []arr,int[][] commands) {
        int[] answer = new int[commands.length];
        int [] subArr;
        for (int i = 0; i < commands.length; i++) {
        	subArr = cutArr(arr,commands[i][0],commands[i][1]);
        	answer[i]=sortArr(subArr)[commands[i][2]-1];
		}
        return answer;
    }
	
	//선택정렬 메서드
	private int[] sortArr(int[]arr) {
		int tmp=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j]) {
					tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
		return arr;
	}
	
	//배열 자르는 메서드
	private int[] cutArr(int []arr,int a, int b) {
		int [] result=new int[b-a+1];
		for (int i = 0; a<=b; i++,a++)
			result[i]=arr[a-1];
		return result;
	}
	
	
	
	//다른사람 풀이
	public int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }
        return answer;
    }

	public static void main(String[] args) {
		Day201025_3 d = new Day201025_3();
		int []arr= {1,5,2,6,3,7,4};
		int[][]commands= {{2,5,3},{4,4,1},{1,7,3}};
		arr=d.solution(arr,commands);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
