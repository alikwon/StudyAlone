package algorithm;

public class Day210505_1 {
	public int[] solution(long n) {
        int[] answer = {};
        int length = (int)(Math.log10(n)+1);
		answer = new int[length];
		for	(int i = 0; i < answer.length ; i++) {
			long s = n%10;
			answer[i] = (int)s;
			n /= 10;
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Day210505_1 d = new Day210505_1();
		int[]arr = d.solution(12345);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
