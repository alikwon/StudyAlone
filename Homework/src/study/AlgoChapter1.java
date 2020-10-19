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
		System.out.println("1ë²ˆì§¸ ?ˆ«? ?…? ¥ : ");
		int a = sc.nextInt();
		System.out.println("2ë²ˆì§¸ ?ˆ«? ?…? ¥ : ");
		int b = sc.nextInt();
		System.out.println("3ë²ˆì§¸ ?ˆ«? ?…? ¥ : ");
		int c = sc.nextInt();
		System.out.println("4ë²ˆì§¸ ?ˆ«? ?…? ¥ : ");
		int d = sc.nextInt();
		System.out.println("[1]ìµœë?ê°’êµ¬?•˜ê¸?\t[2]ìµœì†Œê°’êµ¬?•˜ê¸?>>>");
		int choice = sc.nextInt();
		if (choice == 1) {
			int result = max4(a, b, c, d);
			System.out.println("ìµœë?ê°’ì? " + result + "?…?‹ˆ?‹¤.");
		} else if (choice == 2) {
			int result = min4(a, b, c, d);
			System.out.println("ìµœì†Œê°’ì? " + result + "?…?‹ˆ?‹¤.");
		} else {
			System.out.println("?˜ëª»ëœ ?…? ¥");
		}
	}

	void calcMin() {
		System.out.println("1ë²ˆì§¸ ?ˆ«? ?…? ¥ : ");
		int a = sc.nextInt();
		System.out.println("2ë²ˆì§¸ ?ˆ«? ?…? ¥ : ");
		int b = sc.nextInt();
		System.out.println("3ì²«ë²ˆì§? ?ˆ«? ?…? ¥ : ");
		int c = sc.nextInt();

		int result = min3(a, b, c);
		System.out.println("ìµœì†Œê°’ì? " + result + "?…?‹ˆ?‹¤");

	}

	// 4ê°? ê°’ì¤‘ ìµœë?ê°?
	int max4(int a, int b, int c, int d) {
		int[] numList = { a, b, c, d };
		Arrays.sort(numList);
		return numList[numList.length - 1];
	}

	// 4ê°? ê°’ì¤‘ ìµœì†Œê°?
	int min4(int a, int b, int c, int d) {
		int[] numList = { a, b, c, d };
		Arrays.sort(numList);
		return numList[0];
	}

	// 3ê°? ê°’ì¤‘ ìµœì†Œê°?
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
		System.out.println("1ë¶??„° nê¹Œì??˜ ?•©?„ êµ¬í•©?‹ˆ?‹¤");
		System.out.println("n?˜ ê°? : ");
		int n = sc.nextInt();

		int sum = 0;
		int i = 1;
		while (i <= n) {
			sum += i;
			i++;
		}
		System.out.println("i : " + i);
		System.out.println("1ë¶??„° " + n + "ê¹Œì??˜ ?•©?? " + sum + "?…?‹ˆ?‹¤");
	}

	// Q7
	void calcSum() {
		System.out.println("?ˆ«??…? ¥ : ");
		int a = sc.nextInt();
		int result = 0;
		for (int i = a; i > 0; i--) {
			result += i;
		}
		System.out.println(result);
	}

	// Q8
	void calcSum2() {
		System.out.println("?ˆ«??…? ¥?•˜?„¸?š” : ");
		int a = sc.nextInt();
		int sum = (1 + a) * a / 2;
		System.out.println(sum);
	}

	// Q9
	void calcSum3() {
		System.out.println("a ?…? ¥ : ");
		int a = sc.nextInt();
		System.out.println("b ?…? ¥ : ");
		int b = sc.nextInt();
		int sum = 0;
		if (a <= b)
			sum = (a + b) * (b - a + 1) / 2;
		else
			sum = (a + b) * (a - b + 1) / 2;
		System.out.println("a?? b?‚¬?´ ? •?ˆ˜?˜ ?•© : " + sum);
	}

	// Q10
	void subBA() {
		System.out.println("a ?…? ¥ : ");
		int a = sc.nextInt();
		while (true) {
			System.out.println("b ?…? ¥ : ");
			int b = sc.nextInt();
			if (b <= a) {
				System.out.println("bê°’ì? aê°’ë³´?‹¤ ì»¤ì•¼?•©?‹ˆ?‹¤");
				continue;
			} else {
				int result = b - a;
				System.out.println("b-a?Š” " + result + "?…?‹ˆ?‹¤");
				break;
			}
		}
	}

	// Q11
	// ?–‘?˜ ? •?ˆ˜ë¥? ?…? ¥?•˜ê³? ?ë¦¿ìˆ˜ë¥? ì¶œë ¥
	void digitOfNum() {
		while (true) {
			System.out.print("?ˆ«? ?…? ¥>>>");
			int a = sc.nextInt();
			if (a <= 0) {
				System.out.println("?–‘?˜ ? •?ˆ˜ë¥? ?…? ¥?•˜?„¸?š”");
				continue;
			}
			int result = 0;
			while (true) {
				a /= 10;
				result++;
				if (a == 0) {
					System.out.println("a?Š” " + result + "?ë¦? ?ˆ«??„");
					break;
				}
			}
			break;
		}

	}

	// Q12
	// ê³±ì…ˆ?‘œ ì¶œë ¥
	void gugudanTable() {
		System.out.println(" ?”‚1\t2\t3\t4\t5\t6\t7\t8\t9");
		System.out.println("???”¼????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
		for (int i = 1; i < 10; i++) {
			System.out.print(i + "?”‚");
			for (int j = 1; j < 10; j++) {
				System.out.print(i * j + "\t");
			}
			System.out.println();
		}
	}

	// Q13
	// ?§?…ˆ?‘œ ì¶œë ¥
	void plusTable() {
		System.out.println(" ?”‚1\t2\t3\t4\t5\t6\t7\t8\t9");
		System.out.println("???”¼????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????");
		for (int i = 1; i < 10; i++) {
			System.out.print(i + "?”‚");
			for (int j = 1; j < 10; j++) {
				System.out.print(i + j + "\t");
			}
			System.out.println();
		}
	}

	// Q14
	// ?…? ¥?•œ?ˆ˜ë¥? ?•œë³??œ¼ë¡? ?•˜?Š” ? •?‚¬ê°í˜•?„ * ê¸°í˜¸ë¡?
	void printSquare() {
		while (true) {
			System.out.println("?‹¨ ?ˆ˜ë¥? ?…? ¥?•˜?„¸?š”>>>");
			int a = sc.nextInt();
			if (a <= 0) {
				System.out.println("0ë³´ë‹¤ ì»¤ì•¼?•©?‹ˆ?‹¤. ?‹¤?‹œ?…? ¥?•˜?„¸?š”");
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
	// ì§ê° ?´?“±ë³? ?‚¼ê°í˜•ì¶œë ¥
	void printTriangle() {
		while (true) {
			System.out.println("ëª? ?‹¨ ?‚¼ê°í˜•?¸ê°??š” ?>>>");
			int n = sc.nextInt();
			if (n <= 1) {
				System.out.println("1ë³´ë‹¤ ?°?ˆ˜ë¥? ?…? ¥?•˜?„¸?š”!");
				continue;
			}
			System.out.println("ì§ê°?¸ ë¶?ë¶„ì? ?–´?””?¸ê°??š”");
			System.out.println("[1]?™¼?•„?˜  [2]?™¼?œ„  [3]?˜¤ë¥¸ì•„?˜  [4]?˜¤ë¥¸ìœ„");
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

	// ?˜¤ë¥¸ìœ„
	void triangleRU(int n) {
		System.out.println("?˜¤ë¥¸ìª½ ?œ„ê°? ì§ê°?¸ ?´?“±ë³? ?‚¼ê°í˜•?„ ì¶œë ¥?•©?‹ˆ?‹¤");
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

	// ?˜¤ë¥¸ì•„?˜
	void triangleRB(int n) {
		System.out.println("?˜¤ë¥¸ìª½ ?•„?˜ê°? ì§ê°?¸ ?´?“±ë³? ?‚¼ê°í˜•?„ ì¶œë ¥?•©?‹ˆ?‹¤");
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

	// ?™¼?œ„
	void triangleLU(int n) {
		System.out.println("?™¼ìª? ?œ„ê°? ì§ê°?¸ ?´?“±ë³? ?‚¼ê°í˜•?„ ì¶œë ¥?•©?‹ˆ?‹¤");
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// ?™¼?•„?˜
	void triangleLB(int n) {
		System.out.println("?™¼ìª? ?•„?˜ê°? ì§ê°?¸ ?´?“±ë³? ?‚¼ê°í˜•?„ ì¶œë ¥?•©?‹ˆ?‹¤");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// Q16
	// n?‹¨?˜ ?”¼?¼ë¯¸ë“œ
	void printSpira() {
		int n=0;
		int space=0;
		while(true) {
			System.out.println("ëª? ?‹¨ ?”¼?¼ë¯¸ë“œ ?¸ê°??š”?>>");
			int a = sc.nextInt();
			
			System.out.println("[1]?ˆ«?ë¡? ì¶œë ¥   [2]*ëª¨ì–‘?œ¼ë¡? ì¶œë ¥");
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
