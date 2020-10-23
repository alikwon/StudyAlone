package day201021;


public class DelLowNum {
	public static int[] solution(int[] arr) {
		if (arr.length <= 1) {
			int[] answer = { -1 };
			return answer;
		} else {
			int a=arr[0];
			int cnt =0;
			for (int i =1; i < arr.length; i++) {
				a= a>arr[i]?arr[i]:a;
			}
			for (int i = 0; i < arr.length; i++) {
				if(a==arr[i]) {
					cnt++;
				}
			}
			int [] answer = new int[arr.length-cnt];
			int index = 0;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i]!=a) {
					answer[index]=arr[i];
					index++;
				}
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 4,3,2,1 };
		int[]answer = solution(arr);
		System.out.println();
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]+" ");
		}
	}

}
