package study;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AlgoChapter3 {
	static Scanner sc = new Scanner(System.in);

	// ?��?���??��
	int seqSearch(int[] a, int n, int key) {
		int i = 0;

		// ?��?���??�� while
//		while(true) {
//			if(i==n){
//				return -1;
//			}
//			if(a[i]==key)
//				return i;
//			i++;
//		}

		// ?��?���??�� for
		for (int j = 0; j < n; j++) {
			if (a[j] == key)
				return i;
		}
		return -1;
	}

	void doSearch() {
		System.out.println("?��?��?�� 개수: ");
		int num = sc.nextInt();
		int[] x = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		System.out.println("�??��?�� �? : ");
		int ky = sc.nextInt();
		int idx = seqSearch(x, num, ky);

		if (idx == -1)
			System.out.println("�? 값의 ?��?���? ?��?��?��?��");
		else
			System.out.println(ky + "??(?��) x[" + idx + "]?�� ?��?��?��?��.");
	}

	// ?��?���??�� (보초�?) sentinel
	// if 문이 ?���? 비교?��?�� ?��?���? ?��?��
	// ==> 반복종료?�� ???�� ?��?��?��?���? ?��?���? ?��반으�? 줄어?��
	int seqSearchSen(int[] a, int n, int key) {
		int i = 0;
		a[n] = key;
		while (true) {
			if (a[i] == key)
				break;
			i++;
		}
		return i == n ? -1 : i;
	}

	void doSearchSen() {
		System.out.println("?��?��?�� 개수: ");
		int num = sc.nextInt();
		int[] x = new int[num + 1];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		System.out.println("�??��?�� �? : ");
		int ky = sc.nextInt();
		int idx = printSearch(x, num, ky);

		if (idx == -1)
			System.out.println("�? 값의 ?��?���? ?��?��?��?��");
		else
			System.out.println(ky + "??(?��) x[" + idx + "]?�� ?��?��?��?��.");
	}

	// Q1
	// seqSearchSen()?�� while문을 for문으�? 바꾸�?
	int seqSearchSen2(int[] a, int n, int key) {
		int i = 0;
		a[n] = key;
		for (int j = 0; j < n; j++) {
			if (a[j] == key) {
				i = j;
				break;
			}
		}
		return i == n ? -1 : i;
	}

	int seqSearchSen3(int[] a, int n, int key) {
		int i;
		a[n] = key; // 보초�? 추�?
		for (i = 0; a[i] != key; i++);
		return i == n ? -1 : i;
	}

	// Q2
	int printSearch(int[] a, int n, int key) {
		System.out.print("   |");
		for (int k = 0; k < n; k++)
			System.out.printf("%4d", k);
		System.out.println();

		System.out.print("---+");
		for (int k = 0; k < 4 * n + 2; k++)
			System.out.print("-");
		System.out.println();

		for (int i = 0; i < n; i++) {
			System.out.print("   |");
			System.out.printf(String.format("%%%ds*\n", (i * 4) + 3), "");
			System.out.printf("%3d|", i);
			for (int k = 0; k < n; k++)
				System.out.printf("%4d", a[k]);
			System.out.println("\n   |");
			if (a[i] == key)
				return i; // �??��?���?
		}
		return -1; // �??��?��?��
	}
	
	//Q3
	void searchIdx() {
		System.out.print("?��?��?���?");
		int num = sc.nextInt();
		int[] x = new int[num]; // ?��?��?�� num?�� 배열
		int[] y = new int[num]; // ?��?��?�� num?�� 배열

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]�?");
			x[i] = sc.nextInt();
		}
		System.out.print("찾는 값："); // ?�� 값을 ?��?�� 받음
		int ky = sc.nextInt();

		int count = 0;
		for (int i = 0; i < num; i++) {
			if (x[i] == ky)
				y[count++] = i;
		}

		if (count == 0)
			System.out.println("�? 값의 ?��?���? ?��?��?��?��.");
		else
			for (int i = 0; i < count; i++) {
				System.out.println("�? 값�? " + "x[" + y[i] + "]?�� ?��?��?��?��.");
			}
		System.out.println(y.length);
	}
	
	//Q4
	//?���? �??��과정 출력
	void printBinSearch() {
		System.out.print("?��?��?���?");
		int num = sc.nextInt();
		int[] x = new int[num]; // ?��?��?�� num?�� 배열

		System.out.println("?��름차?��?���? ?��?��?��?��?��.");

		System.out.print("x[0]�?"); // �? ?�� ?��?���? ?��?�� ?��?��
		x[0] = sc.nextInt();

		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "]�?");
				x[i] = sc.nextInt();
			} while (x[i] < x[i - 1]); // ?��?�� ?��?�� ?��?��보다 ?��?���? ?��?�� ?��?��
		}

		System.out.print("찾는 값："); // ?�� 값을 ?��?�� 받음
		int ky = sc.nextInt();

		int idx = binSearchEx(x, num, ky); // 배열 x?��?�� 값이 ky?�� ?��?���? �??��

		if (idx == -1)
			System.out.println("�? 값의 ?��?���? ?��?��?��?��.");
		else
			System.out.println(ky + "?? x[" + idx + "]?�� ?��?��?��?��.");
	}
	private int binSearchEx(int[] a, int n, int key) {
		System.out.print("   |");
		for (int k = 0; k < n; k++)
			System.out.printf("%4d", k);
		System.out.println();

		System.out.print("---+");
		for (int k = 0; k < 4 * n + 2; k++)
			System.out.print("-");
		System.out.println();

		int pl = 0; // �??��범위 �? ?��?�� index
		int pr = n - 1; // �??��범위 �? ?��?�� index

		do {
			int pc = (pl + pr) / 2; // 중앙?��?��?�� index
			System.out.print("   |");
			if (pl != pc)
				System.out.printf(String.format("%%%ds<-%%%ds+", (pl * 4) + 1, (pc - pl) * 4), "", "");
			else
				System.out.printf(String.format("%%%ds<-+", pc * 4 + 1), "");
			if (pc != pr)
				System.out.printf(String.format("%%%ds->\n", (pr - pc) * 4 - 2), "");
			else
				System.out.println("->");
			System.out.printf("%3d|", pc);
			for (int k = 0; k < n; k++)
				System.out.printf("%4d", a[k]);
			System.out.println("\n   |");
			if (a[pc] == key)
				return pc; // �??��?���?
			else if (a[pc] < key)
				pl = pc + 1; // �??��범위�? ?���? ?��반으�? 좁힘
			else
				pr = pc - 1; // �??��범위�? ?���? ?��반으�? 좁힘
		} while (pl <= pr);
		return -1;
	}

	public static void main(String[] args) {
		AlgoChapter3 ag = new AlgoChapter3();
		ag.printBinSearch();
		sc.close();
	}
}
