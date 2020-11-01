package algorithm;

import java.util.HashMap;
import java.util.Map;

/*
● [카카오 인턴] 키패드 누르기
	[문제 설명]
		스마트폰 전화 키패드의 각 칸에 다음과 같이 숫자들이 적혀 있습니다.
		
		이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
		맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며,
		엄지손가락을 사용하는 규칙은 다음과 같습니다.
		
		1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 
			키패드 이동 한 칸은 거리로 1에 해당합니다.
		2. 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
		3. 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
		4. 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 
			두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
			4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 
				 왼손잡이는 왼손 엄지손가락을 사용합니다.
				 
		순서대로 누를 번호가 담긴 배열 numbers, 
		왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 
		각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 
		return 하도록 solution 함수를 완성해주세요.
		
	[제한사항]
		- numbers 배열의 크기는 1 이상 1,000 이하입니다.
		- numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
		- hand는 "left" 또는 "right" 입니다.
		- "left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
		- 왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.
*/
public class Day201101_2 {

	public String solution(int[] numbers, String hand) {
		Map<String, int[]> map = new HashMap<>(); // 좌표를 위한 맵
		map.put("1", new int[]{0,0}); map.put("2", new int[]{1,0}); map.put("3", new int[]{2,0});
		map.put("4", new int[]{0,1}); map.put("5", new int[]{1,1}); map.put("6", new int[]{2,1});
		map.put("7", new int[]{0,2}); map.put("8", new int[]{1,2}); map.put("9", new int[]{2,2});
		map.put("*", new int[]{0,3}); map.put("0", new int[]{1,3}); map.put("#", new int[]{2,3});
		
		String answer = "";
		String left="*";	//왼손 처음위치
		String right="#";	//오른손 처음위치
		int leftDis,rightDis;
		
		boolean usedHand; // 왼손=true,오른손=false
		for (int n:numbers) {
			usedHand=true;// 기본 왼손
			switch (n) {
			case 1: case 4: case 7:
				break;
			case 3: case 6: case 9:
				usedHand=false;
				break;
			default:
				leftDis=calcDis(map, left, n);
				rightDis=calcDis(map, right, n);
				if(leftDis==rightDis) {
					usedHand=hand.equals("left")?true:false;
				}else if(leftDis>rightDis) {
					usedHand=false;
				}
				break;
			}
			if(usedHand) {
				left=""+n;
			}else {
				right=""+n;
			}
			answer+=usedHand?"L":"R";
			System.out.println();
		}
		return answer;
	}

	private int calcDis(Map<String, int[]> map,String pos, int num) {
		String n = "" + num;
		int a = Math.abs(map.get(pos)[0] - map.get(n)[0]);
		int b = Math.abs(map.get(pos)[1] - map.get(n)[1]);
		return a + b;
	}

	public static void main(String[] args) {
		Day201101_2 d = new Day201101_2();
		int[] numbers1 = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		int[] numbers2 = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
		int[] numbers3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		String hand1 = "right";
		String hand2 = "left";
		
		//LRLLLRLLRRL
		System.out.println(d.solution(numbers1, hand1));
	}
}
