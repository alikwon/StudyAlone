package day201022;

/*
● 소수 찾기
	문제 설명
		1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, 
		solution을 만들어 보세요.
	
		소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
		(1은 소수가 아닙니다.)

	제한 조건
		-n은 2이상 1000000이하의 자연수입니다.
*/
public class FindPrimeNum {

	public int solution(int n) {
		int answer = 1;
		boolean chk;
		for (int i = 3; i <= n; i++) {
			chk = true;
			if (i % 2 == 0) {
				continue;
			} else {
				for (int j = 3; j <= i / 2; j++) {
					if (i % j == 0) {
						chk = false;
						break;
					}
				}
				if (chk) {
					answer++;
				}
			}
		}
		return answer;
	}

	public int solution2(int n) {
		int answer = 0;
		int[] arr = new int[n + 1]; // true 이면 해당 인덱스 소수.
		arr[0] = arr[1] = 0;

		for (int i = 2; i <= n; i += 1) {
			arr[i] = 1;
		}

		// 2 부터 숫자를 키워가며 배수들을 제외(false 할당)
		for (int i = 2; i * i <= n; i ++) {
			for (int j = i * i; j <= n; j += i) {
				arr[j] = 0; // 2를 제외한 2의 배수 false
			}
		}

		for (int i = 0; i <= n; i += 1) {
			if (1 == arr[i]) {
				answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		FindPrimeNum f = new FindPrimeNum();
		int n = 100;
		System.out.println(f.solution2(n));
	}

}
