package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

/*
● [1차] 다트 게임

[문제 설명]
	카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 
	다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 
	모두가 간단히 즐길 수 있다.
	갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 
	다트 게임의 점수 계산 로직은 아래와 같다.
	
	- 다트 게임은 총 3번의 기회로 구성된다.
	- 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
	- 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 
	    점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
	- 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 
	    해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 
	    아차상(#) 당첨 시 해당 점수는 마이너스된다.
	- 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 
	    이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
	- 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 
	    이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
	- 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 
	    이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
	- Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
	- 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
	- 0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 
	    총점수를 반환하는 함수를 작성하라.

[입력 형식]
	점수|보너스|[옵션]으로 이루어진 문자열 3세트.
	예) 1S2D*3T

	- 점수는 0에서 10 사이의 정수이다.
	- 보너스는 S, D, T 중 하나이다.
	- 옵선은 *이나 # 중 하나이며, 없을 수도 있다.

[출력 형식]
	3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다.
	예) 37
*/
public class Day201105_1 {

	public int solution(String dart) {
		int answer = 0;

		String[] strs = new String[3];
		int[] nums = new int[3];
		// 숫자를 제외한 배열 만들기
		String[] tmp = dart.split("[0-9]{1,2}");
		// 공백제거를 위해 for문돌리기
		int idx = 0;
		for (int i = 0; i < tmp.length; i++)
			if (!tmp[i].equals(""))
				strs[idx++] = tmp[i];
		// 숫자만 배열로 만들기
		// |: or과 같은의미, []:집합 또는 범위, {0,1}: 0개 또는 1개
		tmp = dart.split("[S|D|T][#|*]{0,1}");
		// int배열에 옮기기
		for (int i = 0; i < tmp.length; i++) {
			nums[i] = Integer.parseInt(tmp[i]);
		}

		for (int i = 0; i < nums.length; i++) {
			switch (strs[i].charAt(0)) {
			case 'D':
				nums[i] *= nums[i];
				break;
			case 'T':
				nums[i] *= nums[i] * nums[i];
				break;
			}
			if (strs[i].length() > 1) {
				if (strs[i].charAt(1) == '*') {
					if (i > 0) {
						nums[i - 1] *= 2;
					}
					nums[i] *= 2;
				} else if (strs[i].charAt(1) == '#') {
					nums[i] *= -1;
				}
			}
		}
		for (int i = 0; i < nums.length; i++) {
			answer += nums[i];
		}
		return answer;
	}

	// 다른사람 풀이
	public int solution2(String dart) {
		char[] darts = dart.toCharArray();
		int[] score = new int[3];
		int cnt = -1;

		for (int i = 0; i < darts.length; i++) {
			if (darts[i] >= '0' && darts[i] <= '9') {
				cnt++;
				if (darts[i] == '1' && darts[i + 1] == '0') {
					score[cnt] = 10;
					i++;
				} else {
					score[cnt] = darts[i] - '0';
				}
			} else if (darts[i] == 'D') {
				score[cnt] *= score[cnt];
			} else if (darts[i] == 'T') {
				score[cnt] *= score[cnt] * score[cnt];
			} else if (darts[i] == '*') {
				if (cnt > 0) {
					score[cnt - 1] *= 2;
				}
				score[cnt] *= 2;
			} else if (darts[i] == '#') {
				score[cnt] *= -1;
			}
		}
		return score[0] + score[1] + score[2];
	}

	public static void main(String[] args) {
		Day201105_1 d = new Day201105_1();
		String test = "";
		String dartResult1 = "1S2D*3T"; // 37
		String dartResult2 = "1D2S#10S"; // 9
		String dartResult3 = "1D2S0T"; // 3
		String dartResult4 = "1S*2T*3S"; // 23
		String dartResult5 = "1D#2S*3S"; // 5
		String dartResult6 = "1T2D3D#"; // -4
		String dartResult7 = "1D2S3T*"; // 59
		System.out.println(d.solution2(dartResult6));
	}
}
