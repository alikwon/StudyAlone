package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AlgoChapter1 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		AlgoChapter1 ag = new AlgoChapter1();
		ag.printSpira();
		sc.close();
	}

	void calcMaxOrMin() {
		System.out.println("1번째 ?��?�� ?��?�� : ");
		int a = sc.nextInt();
		System.out.println("2번째 ?��?�� ?��?�� : ");
		int b = sc.nextInt();
		System.out.println("3번째 ?��?�� ?��?�� : ");
		int c = sc.nextInt();
		System.out.println("4번째 ?��?�� ?��?�� : ");
		int d = sc.nextInt();
		System.out.println("[1]최�?값구?���?\t[2]최소값구?���?>>>");
		int choice = sc.nextInt();
		if (choice == 1) {
			int result = max4(a, b, c, d);
			System.out.println("최�?값�? " + result + "?��?��?��.");
		} else if (choice == 2) {
			int result = min4(a, b, c, d);
			System.out.println("최소값�? " + result + "?��?��?��.");
		} else {
			System.out.println("?��못된 ?��?��");
		}
	}

	void calcMin() {
		System.out.println("1번째 ?��?�� ?��?�� : ");
		int a = sc.nextInt();
		System.out.println("2번째 ?��?�� ?��?�� : ");
		int b = sc.nextInt();
		System.out.println("3첫번�? ?��?�� ?��?�� : ");
		int c = sc.nextInt();

		int result = min3(a, b, c);
		System.out.println("최소값�? " + result + "?��?��?��");

	}

	// 4�? 값중 최�?�?
	int max4(int a, int b, int c, int d) {
		int[] numList = { a, b, c, d };
		Arrays.sort(numList);
		return numList[numList.length - 1];
	}

	// 4�? 값중 최소�?
	int min4(int a, int b, int c, int d) {
		int[] numList = { a, b, c, d };
		Arrays.sort(numList);
		return numList[0];
	}

	// 3�? 값중 최소�?
	int min3(int a, int b, int c) {
		int[] numList = { a, b, c };
		int min = numList[0];
		for (int i = 1; i < numList.length; i++) {
			if (min > numList[i]) {
				min = numList[i];
			}
		}
		return min;
	}

	// Q6
	void sumWhile() {
		System.out.println("1�??�� n까�??�� ?��?�� 구합?��?��");
		System.out.println("n?�� �? : ");
		int n = sc.nextInt();

		int sum = 0;
		int i = 1;
		while (i <= n) {
			sum += i;
			i++;
		}
		System.out.println("i : " + i);
		System.out.println("1�??�� " + n + "까�??�� ?��?? " + sum + "?��?��?��");
	}

	// Q7
	void calcSum() {
		System.out.println("?��?��?��?�� : ");
		int a = sc.nextInt();
		int result = 0;
		for (int i = a; i > 0; i--) {
			result += i;
		}
		System.out.println(result);
	}

	// Q8
	void calcSum2() {
		System.out.println("?��?��?��?��?��?��?�� : ");
		int a = sc.nextInt();
		int sum = (1 + a) * a / 2;
		System.out.println(sum);
	}

	// Q9
	void calcSum3() {
		System.out.println("a ?��?�� : ");
		int a = sc.nextInt();
		System.out.println("b ?��?�� : ");
		int b = sc.nextInt();
		int sum = 0;
		if (a <= b)
			sum = (a + b) * (b - a + 1) / 2;
		else
			sum = (a + b) * (a - b + 1) / 2;
		System.out.println("a?? b?��?�� ?��?��?�� ?�� : " + sum);
	}

	// Q10
	void subBA() {
		System.out.println("a ?��?�� : ");
		int a = sc.nextInt();
		while (true) {
			System.out.println("b ?��?�� : ");
			int b = sc.nextInt();
			if (b <= a) {
				System.out.println("b값�? a값보?�� 커야?��?��?��");
				continue;
			} else {
				int result = b - a;
				System.out.println("b-a?�� " + result + "?��?��?��");
				break;
			}
		}
	}

	// Q11
	// ?��?�� ?��?���? ?��?��?���? ?��릿수�? 출력
	void digitOfNum() {
		while (true) {
			System.out.print("?��?�� ?��?��>>>");
			int a = sc.nextInt();
			if (a <= 0) {
				System.out.println("?��?�� ?��?���? ?��?��?��?��?��");
				continue;
			}
			int result = 0;
			while (true) {
				a /= 10;
				result++;
				if (a == 0) {
					System.out.println("a?�� " + result + "?���? ?��?��?��");
					break;
				}
			}
			break;
		}

	}

	// Q12
	// 곱셈?�� 출력
	void gugudanTable() {
		System.out.println(" ?��1\t2\t3\t4\t5\t6\t7\t8\t9");
		System.out.println("???��????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
		for (int i = 1; i < 10; i++) {
			System.out.print(i + "?��");
			for (int j = 1; j < 10; j++) {
				System.out.print(i * j + "\t");
			}
			System.out.println();
		}
	}

	// Q13
	// ?��?��?�� 출력
	void plusTable() {
		System.out.println(" ?��1\t2\t3\t4\t5\t6\t7\t8\t9");
		System.out.println("???��????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
		for (int i = 1; i < 10; i++) {
			System.out.print(i + "?��");
			for (int j = 1; j < 10; j++) {
				System.out.print(i + j + "\t");
			}
			System.out.println();
		}
	}

	// Q14
	// ?��?��?��?���? ?���??���? ?��?�� ?��?��각형?�� * 기호�?
	void printSquare() {
		while (true) {
			System.out.println("?�� ?���? ?��?��?��?��?��>>>");
			int a = sc.nextInt();
			if (a <= 0) {
				System.out.println("0보다 커야?��?��?��. ?��?��?��?��?��?��?��");
				continue;
			}
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < a; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		}
	}

	// Q15
	// 직각 ?��?���? ?��각형출력
	void printTriangle() {
		while (true) {
			System.out.println("�? ?�� ?��각형?���??�� ?>>>");
			int n = sc.nextInt();
			if (n <= 1) {
				System.out.println("1보다 ?��?���? ?��?��?��?��?��!");
				continue;
			}
			System.out.println("직각?�� �?분�? ?��?��?���??��");
			System.out.println("[1]?��?��?��  [2]?��?��  [3]?��른아?��  [4]?��른위");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				triangleLB(n);
				break;
			case 2:
				triangleLU(n);
				break;
			case 3:
				triangleRB(n);
				break;
			case 4:
				triangleRU(n);
				break;
			default:
				break;
			}
			break;
		}

	}

	// ?��른위
	void triangleRU(int n) {
		System.out.println("?��른쪽 ?���? 직각?�� ?��?���? ?��각형?�� 출력?��?��?��");
		int a = 0;
		for (int i = n; i >= 1; i--) {
			a = n - i;
			while (a > 0) {
				System.out.print(" ");
				a--;
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// ?��른아?��
	void triangleRB(int n) {
		System.out.println("?��른쪽 ?��?���? 직각?�� ?��?���? ?��각형?�� 출력?��?��?��");
		int a = 0;
		for (int i = 1; i <= n; i++) {
			a = n - i;
			while (a > 0) {
				System.out.print(" ");
				a--;
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// ?��?��
	void triangleLU(int n) {
		System.out.println("?���? ?���? 직각?�� ?��?���? ?��각형?�� 출력?��?��?��");
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// ?��?��?��
	void triangleLB(int n) {
		System.out.println("?���? ?��?���? 직각?�� ?��?���? ?��각형?�� 출력?��?��?��");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// Q16
	// n?��?�� ?��?��미드
	void printSpira() {
		int n=0;
		int space=0;
		while(true) {
			System.out.println("�? ?�� ?��?��미드 ?���??��?>>");
			int a = sc.nextInt();
			
			System.out.println("[1]?��?���? 출력   [2]*모양?���? 출력");
			int choice= sc.nextInt();
			if(choice==1) {
				for (int i = 1; i <= a; i++) {
					space=a-i;
					n= (i-1)*2+1;
					while(space>0) {
						System.out.print(" ");
						space--;
					}
					for (int j = 1; j <= i; j++) {
						while(n>0) {
							System.out.print(i%10);
							n--;
						}
					}
					System.out.println();
				}
			}else if(choice==2) {
				for (int i = 1; i <= a; i++) {
					space=a-i;
					n= (i-1)*2+1;
					while(space>0) {
						System.out.print(" ");
						space--;
					}
					for (int j = 1; j <= i; j++) {
						while(n>0) {
							System.out.print("*");
							n--;
						}
					}
					System.out.println();
				}
			}
			System.out.println();
		}
	}

}
