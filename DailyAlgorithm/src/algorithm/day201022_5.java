package algorithm;
/*
● 수박수박수박수박수박수?
	문제 설명
		길이가 n이고, 수박수박수박수....와 같은 패턴을 유지하는 문자열을 리턴하는 함수,
		solution을 완성하세요. 
		예를들어 n이 4이면 수박수박을 리턴하고 3이라면 수박수를 리턴하면 됩니다.

	제한 조건
		-n은 길이 10,000이하인 자연수입니다.
*/
public class day201022_5 {
	public String solution(int n) {
		String answer="";
		for (int i = 1; i <= n; i++) {
			answer+=i%2==1?"수":"박";
		}
		return answer;
	}
	public static void main(String[] args) {
		day201022_5 s = new day201022_5();
		int n = 1;
		System.out.println(s.solution(n));
	}
}