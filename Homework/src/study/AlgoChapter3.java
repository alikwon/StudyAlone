package study;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AlgoChapter3 {
	static Scanner sc = new Scanner(System.in);

	// ?„ ?˜•ê²??ƒ‰
	int seqSearch(int[] a, int n, int key) {
		int i = 0;

		// ?„ ?˜•ê²??ƒ‰ while
//		while(true) {
//			if(i==n){
//				return -1;
//			}
//			if(a[i]==key)
//				return i;
//			i++;
//		}

		// ?„ ?˜•ê²??ƒ‰ for
		for (int j = 0; j < n; j++) {
			if (a[j] == key)
				return i;
		}
		return -1;
	}

	void doSearch() {
		System.out.println("?š”?†Œ?˜ ê°œìˆ˜: ");
		int num = sc.nextInt();
		int[] x = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		System.out.println("ê²??ƒ‰?•  ê°? : ");
		int ky = sc.nextInt();
		int idx = seqSearch(x, num, ky);

		if (idx == -1)
			System.out.println("ê·? ê°’ì˜ ?š”?†Œê°? ?—†?Šµ?‹ˆ?‹¤");
		else
			System.out.println(ky + "??(?Š”) x[" + idx + "]?— ?ˆ?Šµ?‹ˆ?‹¤.");
	}

	// ?„ ?˜•ê²??ƒ‰ (ë³´ì´ˆë²?) sentinel
	// if ë¬¸ì´ ? „ê³? ë¹„êµ?•´?„œ ?•˜?‚˜ë§? ?‚¬?š©
	// ==> ë°˜ë³µì¢…ë£Œ?— ???•œ ?Œ?‹¨?šŸ?ˆ˜ê°? ?‹¤? œë¡? ? ˆë°˜ìœ¼ë¡? ì¤„ì–´?“¦
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
		System.out.println("?š”?†Œ?˜ ê°œìˆ˜: ");
		int num = sc.nextInt();
		int[] x = new int[num + 1];

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = sc.nextInt();
		}
		System.out.println("ê²??ƒ‰?•  ê°? : ");
		int ky = sc.nextInt();
		int idx = printSearch(x, num, ky);

		if (idx == -1)
			System.out.println("ê·? ê°’ì˜ ?š”?†Œê°? ?—†?Šµ?‹ˆ?‹¤");
		else
			System.out.println(ky + "??(?Š”) x[" + idx + "]?— ?ˆ?Šµ?‹ˆ?‹¤.");
	}

	// Q1
	// seqSearchSen()?˜ whileë¬¸ì„ forë¬¸ìœ¼ë¡? ë°”ê¾¸ê¸?
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
		a[n] = key; // ë³´ì´ˆë¥? ì¶”ê?
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
				return i; // ê²??ƒ‰?„±ê³?
		}
		return -1; // ê²??ƒ‰?‹¤?Œ¨
	}
	
	//Q3
	void searchIdx() {
		System.out.print("?š”?†Ÿ?ˆ˜ï¼?");
		int num = sc.nextInt();
		int[] x = new int[num]; // ?š”?†Ÿ?ˆ˜ num?¸ ë°°ì—´
		int[] y = new int[num]; // ?š”?†Ÿ?ˆ˜ num?¸ ë°°ì—´

		for (int i = 0; i < num; i++) {
			System.out.print("x[" + i + "]ï¼?");
			x[i] = sc.nextInt();
		}
		System.out.print("ì°¾ëŠ” ê°’ï¼š"); // ?‚¤ ê°’ì„ ?…? ¥ ë°›ìŒ
		int ky = sc.nextInt();

		int count = 0;
		for (int i = 0; i < num; i++) {
			if (x[i] == ky)
				y[count++] = i;
		}

		if (count == 0)
			System.out.println("ê·? ê°’ì˜ ?š”?†Œê°? ?—†?Šµ?‹ˆ?‹¤.");
		else
			for (int i = 0; i < count; i++) {
				System.out.println("ê·? ê°’ì? " + "x[" + y[i] + "]?— ?ˆ?Šµ?‹ˆ?‹¤.");
			}
		System.out.println(y.length);
	}
	
	//Q4
	//?´ì§? ê²??ƒ‰ê³¼ì • ì¶œë ¥
	void printBinSearch() {
		System.out.print("?š”?†Ÿ?ˆ˜ï¼?");
		int num = sc.nextInt();
		int[] x = new int[num]; // ?š”?†Ÿ?ˆ˜ num?¸ ë°°ì—´

		System.out.println("?˜¤ë¦„ì°¨?ˆœ?œ¼ë¡? ?…? ¥?•˜?„¸?š”.");

		System.out.print("x[0]ï¼?"); // ë§? ?• ?š”?†Œë¥? ?½?–´ ?“¤?„
		x[0] = sc.nextInt();

		for (int i = 1; i < num; i++) {
			do {
				System.out.print("x[" + i + "]ï¼?");
				x[i] = sc.nextInt();
			} while (x[i] < x[i - 1]); // ?•˜?‚˜ ?•?˜ ?š”?†Œë³´ë‹¤ ?‘?œ¼ë©? ?‹¤?‹œ ?…? ¥
		}

		System.out.print("ì°¾ëŠ” ê°’ï¼š"); // ?‚¤ ê°’ì„ ?…? ¥ ë°›ìŒ
		int ky = sc.nextInt();

		int idx = binSearchEx(x, num, ky); // ë°°ì—´ x?—?„œ ê°’ì´ ky?¸ ?š”?†Œë¥? ê²??ƒ‰

		if (idx == -1)
			System.out.println("ê·? ê°’ì˜ ?š”?†Œê°? ?—†?Šµ?‹ˆ?‹¤.");
		else
			System.out.println(ky + "?? x[" + idx + "]?— ?ˆ?Šµ?‹ˆ?‹¤.");
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

		int pl = 0; // ê²??ƒ‰ë²”ìœ„ ë§? ?•?˜ index
		int pr = n - 1; // ê²??ƒ‰ë²”ìœ„ ë§? ?’¤?˜ index

		do {
			int pc = (pl + pr) / 2; // ì¤‘ì•™?š”?†Œ?˜ index
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
				return pc; // ê²??ƒ‰?„±ê³?
			else if (a[pc] < key)
				pl = pc + 1; // ê²??ƒ‰ë²”ìœ„ë¥? ?’¤ìª? ? ˆë°˜ìœ¼ë¡? ì¢í˜
			else
				pr = pc - 1; // ê²??ƒ‰ë²”ìœ„ë¥? ?•ìª? ? ˆë°˜ìœ¼ë¡? ì¢í˜
		} while (pl <= pr);
		return -1;
	}

	public static void main(String[] args) {
		AlgoChapter3 ag = new AlgoChapter3();
		ag.printBinSearch();
		sc.close();
	}
}
