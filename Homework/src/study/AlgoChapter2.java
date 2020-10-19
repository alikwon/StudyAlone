package study;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AlgoChapter2 {
	static Scanner sc = new Scanner(System.in);


	// Q1
	// ?��?��?��?�� ?��?���?...
	void MaxOf() {
		Random rand = new Random();
		int p = 1 + rand.nextInt(11);
		System.out.println("?��?�� 최�?값을 구합?��?��");
		System.out.println("?��?��?�� >>>" + p + "�?");

		int[] height = new int[p];
		System.out.println("?��값�? ?��?���? 같습?��?��");
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
		System.out.println("최�?값�? " + max + "?��?��?��");
	}

	// Q2
	// 배열?��?���? ?��?��?���? ?��?��
	void reverseArr() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		print(arr);
		for (int i = 0; i < arr.length / 2; i++) {
			System.out.println("arr[" + i + "]�? arr[" + (arr.length - i - 1) + "]?�� 교환?��?��?��");
			changePositon(arr, i, arr.length - i - 1);
			print(arr);
		}
		System.out.println("?��?��?��?��?�� 마쳤?��?��?��.");
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
	// 배열?�� 모든?��?��?�� ?��?�� 구하?�� 메서?��
	void sumOfArr() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		System.out.println("배열모든?��?��?�� ?��?? " + result + "?��?��?��.");
	}

	//Q4
	//배열b?�� 모든?��?���? 배열a?�� 복사?��?�� 메서?��
	void copyArr() {
		int[]a= {1,2,3,4,5,6};
		int[]b= {};
//		int[]b=Arrays.copyOf(a, a.length);
		System.out.println("배열 a�? b�? 복사?��?��?��");
		System.out.print("?��?��?�� b\n" );
		print(b);
		b=a.clone();
		System.out.println("[복사?�� b]");
		print(b);
	}
	
	void copyArr2() {
		int[]a= {1,2,3,4,5,6};
		int[]b= new int[a.length];
		System.out.println("배열 a�? b�? 복사?��?��?��");
		System.out.print("[?��?��?�� b]\n" );
		print(b);
		for (int i = 0; i < a.length; i++) {
			b[i]=a[i];
		}
		System.out.println("[복사?�� b]");
		print(b);
	}

	//Q5
	//?��번엔 ?��?��?��로복?��
	void rcopyArr() {
		int[]a= {1,2,3,4,5,6,7};
		int[]b=new int[a.length];
		System.out.println("배열 a�? b�? 복사?��?��?��");
		System.out.print("[?��?��?�� b]\n" );
		print(b);
		for (int i = 0; i < a.length; i++) {
			b[a.length-i-1]=a[i];
		}
		System.out.println("[복사?�� b]");
		print(b);
		
	}
	
	//Q6
	//배열?�� ?��쪽에 ?��?��?��리�? ?��?��?�� ?��?��리�?? ?��?��?��?�� 메서?��
	void cardConv() {
		
	}
	
	//Q7
	//기수�??��과정?�� ?��?��?�� ?��???��?�� 메서?��
	
	public static void main(String[] args) {
		AlgoChapter2 ag = new AlgoChapter2();
		ag.copyArr2();
		sc.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
