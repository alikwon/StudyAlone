package algorithm;

import java.util.Scanner;

/*
● 사다리 게임

그림 - https://www.synapsoft.co.kr/wp-content/uploads/2020/07/ladder-game01.png

	위 그림은 커피 내기를 할 때 유용한 사다리 게임입니다.
	잘 생각해 보면, 사다리 게임은 가로선을 (높이, 왼쪽의 세로줄 번호) 형태로 나타낼 수 있습니다.
	예컨대, 위 사다리 게임은 
	(1, 1), (6, 1), (9, 1), (3, 2), (5, 2) ….와 같이 표현할 수 있습니다.
	
	아래 예제와 같이, 
	사다리 게임의 데이터와 출발 지점을 입력하면 도착 지점을 출력하는 프로그램을 작성하세요.
	
	※ 사다리 정보는 터미널 입력을 받아도 되고, 코드 내부에 직접 작성하셔도 됩니다.
	
	※ 프로그래밍 언어의 제약은 없으며, 외부 라이브러리를 쓰시는 경우 용도를 같이 명시해 주세요.
*/
public class Day201110_2 {

	public static void main(String[] args) {
		Day201110_2 d = new Day201110_2();
		Scanner sc = new Scanner(System.in);
		int men = 0; // 사다리게임에 참여할 인원
		// 인원수 입력을 위한 반복문
		// 입력 잘못했을 시 반복
		while (true) {
			try {
				System.out.println("몇명인가요?>>>");
				men = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력입니다. 숫자를 정확히 입력하세요");
				continue;
			}
		}

		// 행은 10개 , 열은 인원수 만큼 2차원배열생성
		int[][] ladder = new int[10][men];

		String input = null;
		String[] arr = null;
		// 사다리에 선을 긋는 반복문
		System.out.println("사다리 정보를 입력하세요(x는 입력완료)");
		d.printLadder(ladder);
		while (true) {
			try {
				input = sc.nextLine();
				if (input.equals("x")) {
					System.out.println("<<<정보입력완료>>>");
					break;
				}
				arr = input.split(" ");
				int height = Integer.parseInt(arr[0]) - 1;
				int line = Integer.parseInt(arr[1]) - 1;

				if (d.chkDrawLine(ladder, height, line)) {
					System.out.println(line + 1 + "번 라인 " + (height + 1) + "행에 선을 긋습니다.");
					// 선이 그어지면 선의 왼쪽은 1, 선의 오른쪽은 2를 입력해줌
					ladder[height][line] = 1;
					ladder[height][line + 1] = 2;
				} else {
					System.out.println("선을 그을 수 없는 위치입니다");
					continue;
				}
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력입니다");
				continue;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("\"행 줄\" 로 정확히 입력하세요");
				continue;
			}
			d.printLadder(ladder);
		}

		// 완성된 사다리 출력
		System.out.println("----------< 완성된 사다리 >----------");
		d.printLadder(ladder);

		// 출발지점 선택 후 결과 확인을 위한 반복문
		int result = 0;
		while (true) {
			System.out.println("출발지점 입력(x는 종료)\n>>");
			input = sc.nextLine().trim();

			if (input.equals("x")) {
				System.out.println("-----종료합니다-----");
				break;
			}
			try {
				result = Integer.parseInt(input) - 1;
				for (int i = 0; i < ladder.length; i++) {
					// 0이면 그냥 지나가고
					if (ladder[i][result] > 0) {
						// 1이면 오른쪽으로 이동 --> 라인이 +1 이 됨
						// 1이아니면 (2라면) 왼쪽으로 이동 -->라인이 -1이 됨
						result = ladder[i][result] == 1 ? result + 1 : result - 1;
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력입니다.");
				continue;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("출발라인이 아닙니다");
				continue;
			}
			System.out.println("도착지점 : " + (result + 1));
		}
		sc.close();
	}

	// 선을 그을 수 있는 위치인지 체크
	private boolean chkDrawLine(int[][] lad, int height, int line) {
		// false리턴하는 경우
		// 1.라인이 범위를 벗어날 때
		// 2.행이 범위를 벗어날 때
		// 3.이미 선이 있을 때
		if (line >= lad[0].length - 1 || line < 0) {
			return false;
		} else if (height < 0 || height > 9) {
			return false;
		} else if (!(lad[height][line] < 1) || !(lad[height][line + 1] < 1)) {
			return false;
		}
		return true;
	}

	// 사다리 출력
	private void printLadder(int[][] lad) {
		System.out.print(" ");
		for (int i = 0; i < lad[0].length; i++) {
			System.out.printf("%3s", i + 1);
		}
		System.out.println();
		for (int i = 0; i < lad.length; i++) {
			System.out.printf("%2s", i + 1);
			for (int j = 0; j < lad[0].length; j++) {
				if (lad[i][j] == 1) {
					System.out.printf("%3s", " ├─");
				} else if (lad[i][j] == 2) {
					System.out.printf("%3s", "─┤ ");
				} else if (lad[i][j] == 0) {
					System.out.printf("%3s", " │ ");
				}
			}
			System.out.println();
		}
		System.out.print(" ");
		for (int i = 0; i < lad[0].length; i++) {
			System.out.printf("%3s", i + 1);
		}
		System.out.println();
	}
}
