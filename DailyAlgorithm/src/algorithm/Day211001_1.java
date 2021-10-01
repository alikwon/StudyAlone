package algorithm;

/*
● 부족한 금액 계산하기


[문제 설명]
	직사각형을 만드는 데 필요한 4개의 점 중 3개의 좌표가 주어질 때, 
	나머지 한 점의 좌표를 구하려고 합니다. 
	점 3개의 좌표가 들어있는 배열 v가 매개변수로 주어질 때, 
	직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 return 하도록 solution 함수를 완성해주세요. 
	단, 직사각형의 각 변은 x축, y축에 평행하며, 반드시 직사각형을 만들 수 있는 경우만 입력으로 주어집니다.
	 		
[제한사항]
	- v는 세 점의 좌표가 들어있는 2차원 배열입니다.
	- v의 각 원소는 점의 좌표를 나타내며, 좌표는 [x축 좌표, y축 좌표] 순으로 주어집니다.
	- 좌표값은 1 이상 10억 이하의 자연수입니다.
	- 직사각형을 만드는 데 필요한 나머지 한 점의 좌표를 [x축 좌표, y축 좌표] 순으로 담아 return 해주세요.
 */
public class Day211001_1 {
	public int[] solution(int[][] v) {
		int[] answer = new int[2];
		int x = -1;
		int y = -1;
		for (int i = 0; i < v.length; i++) {
			boolean [] notFind = {true, true};
			x = v[i][0];
			y = v[i][1];
			for (int j = 0; j < v.length; j++) {
				if(i != j && v[j][0] == x) notFind[0] = false;
				if(i != j && v[j][1] == y) notFind[1] = false;
			}
			if(notFind[0]) answer[0] = x;
			if(notFind[1]) answer[1] = y;
		}
		return answer;
	}

	public static void main(String[] args) {
		Day211001_1 d = new Day211001_1();
		int[][] arr = { { 1, 4 }, { 3, 4 }, { 3, 10 } };
		int [] answer = d.solution(arr);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
