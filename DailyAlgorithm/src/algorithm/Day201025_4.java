package algorithm;

/*
● 모의고사
	문제 설명
		수포자는 수학을 포기한 사람의 준말입니다. 
		수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
		
		1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
		2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
		3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
		
		1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
		가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 
		solution 함수를 작성해주세요.
	
	제한 조건
		- 시험은 최대 10,000 문제로 구성되어있습니다.
		- 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
		- 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
*/
public class Day201025_4 {

	public int[] solution(int[] answers) {
		//1번 수포자의 패턴
        int[] a = { 1, 2, 3, 4, 5 };
        //2번 수포자의 패턴
		int[] b = { 2, 1, 2, 3, 2, 4, 2, 5 };
		//3번 수포자의 패턴
		int[] c = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		//각 수포자들의 맞춘 문제개수
		int []cnt = new int[3];
		for (int i = 0; i < answers.length; i++) {
			if (a[i % a.length] == answers[i])
				cnt[0]++;
			if (b[i % b.length] == answers[i])
				cnt[1]++;
			if (c[i % c.length] == answers[i])
				cnt[2]++;
		}
		
		//승리자 index
		int winner = 0;
		//동점자
		int tie= -1;
		//동점자 수
		int win = 1;
		
		for(int i=1;i<cnt.length;i++) {
			if(cnt[winner]<cnt[i]) {
				winner=i;
			}else if(cnt[winner]==cnt[i]) {
				tie=i;
				win++;
			}
		}
		
		if(win==1) {
			int[] answer = {winner+1};
			return answer;
		}else if(win==2) {
			int[]answer= {winner+1,tie+1};
			return answer;
		}else {
			int[]answer= {1,2,3};
			return answer;
		}
	}
	
	public static void main(String[] args) {
		Day201025_4 d = new Day201025_4();
		int[]arr = {1,3,2,4,2};
		arr=d.solution(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%s ",arr[i]);
		}
	}
}
