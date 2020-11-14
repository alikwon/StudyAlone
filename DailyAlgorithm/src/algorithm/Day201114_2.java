package algorithm;

/*
● 전화번호 목록


[문제 설명]
	전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
	전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
	
	- 구조대 : 119
	- 박준영 : 97 674 223
	- 지영석 : 11 9552 4421
	전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
	어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 
	그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
	
[제한사항]
	- phone_book의 길이는 1 이상 1,000,000 이하입니다.
	- 각 전화번호의 길이는 1 이상 20 이하입니다.	
*/
public class Day201114_2 {

	public boolean solution(String[] pb) {
		int cnt = 0;
		for (int i = 0; i < pb.length; i++) {
			cnt = 0;
			for (int j = 0; j < pb.length; j++) {
				if (pb[i].indexOf(pb[j]) == 0) {
					cnt += 1;
				}
				if (cnt > 1) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean solution2(String[] pb) {
		for (int i = 0; i < pb.length - 1; i++) {
			for (int j = i + 1; j < pb.length; j++) {
				if (pb[i].startsWith(pb[j]))
					return false;
				if (pb[j].startsWith(pb[i]))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Day201114_2 d = new Day201114_2();
		String[] pb1 = { "119", "97674223", "1195524421" };
		String[] pb2 = { "123", "456", "789" };
		String[] pb3 = { "12", "123", "1235", "567", "88" };

		System.out.println(d.solution(pb2));
	}
}
