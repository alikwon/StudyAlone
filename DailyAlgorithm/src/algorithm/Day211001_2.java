package algorithm;

import java.text.ParseException;

/*
 * 주어진 AM,PM으로 되어있는 시간에 초 N을 더한후 
 * 24시간 형식으로 변환
 */
public class Day211001_2 {
	public String solution(String p, int n) {
		String[] answer = new String[3];

		// 공백으로 split
		// arr[0] : "PM" or "AM"
		// arr[1] : "시:분:초"
		String[] arr = p.split(" ");
		
		boolean isAM = arr[0].equals("AM");

		int[] timeArr = new int[3];

		// 연산을 위해 timeArr 에 형변환 후 옮겨담음
		// timeArr[0] = hour
		// timeArr[1] = min
		// timeArr[2] = sec
		for (int i = 0; i < arr[1].split(":").length; i++) {
			timeArr[i] = Integer.parseInt(arr[1].split(":")[i]);
		}
		

		//PM이고 12시가 아닌경우 12시를 더해줌
		if (!isAM && timeArr[0] != 12) {
			timeArr[0] += 12;
		}
		
		//AM이고 12시인 경우 자정이므로 0시
		if (timeArr[0] == 12 && isAM) {
			timeArr[0] = 0;
		}

		// 지나간 초만큼 더하기
		timeArr[2] += n;
		
		if (timeArr[2] >= 60) {
			timeArr[1] += timeArr[2] / 60;
			timeArr[2] %= 60;
		}
		if (timeArr[1] >= 60) {
			timeArr[0] += timeArr[1] / 60;
			timeArr[1] %= 60;
		}
		if (timeArr[0] >= 24) {
			timeArr[0] %= 24;
		}

		for (int i = 0; i < timeArr.length; i++) {
			String str = String.valueOf(timeArr[i]);
			answer[i] = str.length() < 2 ? "0" + str : str;
		}
		return String.join(":", answer);
	}

	public static void main(String[] args) throws ParseException {
		Day211001_2 d = new Day211001_2();
		String p = "PM 01:00:00";
		int n = 10;
		System.out.println(d.solution(p, n));
	}
}
