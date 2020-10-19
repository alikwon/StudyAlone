package study;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AlgoChapter2 {
	static Scanner sc = new Scanner(System.in);


	// Q1
	// ?‚¬?Œ?ˆ˜?„ ?‚œ?ˆ˜ë¡?...
	void MaxOf() {
		Random rand = new Random();
		int p = 1 + rand.nextInt(11);
		System.out.println("?‚¤?˜ ìµœë?ê°’ì„ êµ¬í•©?‹ˆ?‹¤");
		System.out.println("?‚¬?Œ?ˆ˜ >>>" + p + "ëª?");

		int[] height = new int[p];
		System.out.println("?‚¤ê°’ì? ?‹¤?Œê³? ê°™ìŠµ?‹ˆ?‹¤");
		for (int i = 0; i < p; i++) {
			height[i] = 100 + rand.nextInt(90);
			System.out.println("height[" + i + "]" + height[i]);
		}
		int max = height[0];
		for (int i = 0; i < height.length; i++) {
			if (height[i] > max) {
				max = height[i];
			}
		}
		System.out.println("ìµœë?ê°’ì? " + max + "?…?‹ˆ?‹¤");
	}

	// Q2
	// ë°°ì—´?š”?†Œë¥? ?—­?ˆœ?œ¼ë¡? ? •? ¬
	void reverseArr() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		print(arr);
		for (int i = 0; i < arr.length / 2; i++) {
			System.out.println("arr[" + i + "]ê³? arr[" + (arr.length - i - 1) + "]?„ êµí™˜?•©?‹ˆ?‹¤");
			changePositon(arr, i, arr.length - i - 1);
			print(arr);
		}
		System.out.println("?—­?ˆœ? •? ¬?„ ë§ˆì³¤?Šµ?‹ˆ?‹¤.");
	}
	
	void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	void changePositon(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	// Q3
	// ë°°ì—´?˜ ëª¨ë“ ?š”?†Œ?˜ ?•©?„ êµ¬í•˜?Š” ë©”ì„œ?“œ
	void sumOfArr() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		System.out.println("ë°°ì—´ëª¨ë“ ?š”?†Œ?˜ ?•©?? " + result + "?…?‹ˆ?‹¤.");
	}

	//Q4
	//ë°°ì—´b?˜ ëª¨ë“ ?š”?†Œë¥? ë°°ì—´a?— ë³µì‚¬?•˜?Š” ë©”ì„œ?“œ
	void copyArr() {
		int[]a= {1,2,3,4,5,6};
		int[]b= {};
//		int[]b=Arrays.copyOf(a, a.length);
		System.out.println("ë°°ì—´ aë¥? bë¡? ë³µì‚¬?•©?‹ˆ?‹¤");
		System.out.print("?›?˜?˜ b\n" );
		print(b);
		b=a.clone();
		System.out.println("[ë³µì‚¬?›„ b]");
		print(b);
	}
	
	void copyArr2() {
		int[]a= {1,2,3,4,5,6};
		int[]b= new int[a.length];
		System.out.println("ë°°ì—´ aë¥? bë¡? ë³µì‚¬?•©?‹ˆ?‹¤");
		System.out.print("[?›?˜?˜ b]\n" );
		print(b);
		for (int i = 0; i < a.length; i++) {
			b[i]=a[i];
		}
		System.out.println("[ë³µì‚¬?›„ b]");
		print(b);
	}

	//Q5
	//?´ë²ˆì—” ?—­?ˆœ?œ¼ë¡œë³µ?‚¬
	void rcopyArr() {
		int[]a= {1,2,3,4,5,6,7};
		int[]b=new int[a.length];
		System.out.println("ë°°ì—´ aë¥? bë¡? ë³µì‚¬?•©?‹ˆ?‹¤");
		System.out.print("[?›?˜?˜ b]\n" );
		print(b);
		for (int i = 0; i < a.length; i++) {
			b[a.length-i-1]=a[i];
		}
		System.out.println("[ë³µì‚¬?›„ b]");
		print(b);
		
	}
	
	//Q6
	//ë°°ì—´?˜ ?•ìª½ì— ?•„?«?ë¦¬ê? ?•„?‹ˆ?¼ ?œ—?ë¦¬ë?? ?„£?–´?‘?Š” ë©”ì„œ?“œ
	void cardConv() {
		
	}
	
	//Q7
	//ê¸°ìˆ˜ë³??™˜ê³¼ì •?„ ?ƒ?„¸?ˆ ?‚˜???‚´?Š” ë©”ì„œ?“œ
	
	public static void main(String[] args) {
		AlgoChapter2 ag = new AlgoChapter2();
		ag.copyArr2();
		sc.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
