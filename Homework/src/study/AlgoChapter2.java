package study;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AlgoChapter2 {
	static Scanner sc = new Scanner(System.in);


	// Q1
	// ?¬??? ??λ‘?...
	void MaxOf() {
		Random rand = new Random();
		int p = 1 + rand.nextInt(11);
		System.out.println("?€? μ΅λ?κ°μ κ΅¬ν©??€");
		System.out.println("?¬?? >>>" + p + "λͺ?");

		int[] height = new int[p];
		System.out.println("?€κ°μ? ?€?κ³? κ°μ΅??€");
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
		System.out.println("μ΅λ?κ°μ? " + max + "???€");
	}

	// Q2
	// λ°°μ΄??λ₯? ?­??Όλ‘? ? ? ¬
	void reverseArr() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		print(arr);
		for (int i = 0; i < arr.length / 2; i++) {
			System.out.println("arr[" + i + "]κ³? arr[" + (arr.length - i - 1) + "]? κ΅ν?©??€");
			changePositon(arr, i, arr.length - i - 1);
			print(arr);
		}
		System.out.println("?­?? ? ¬? λ§μ³€?΅??€.");
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
	// λ°°μ΄? λͺ¨λ ??? ?©? κ΅¬ν? λ©μ?
	void sumOfArr() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		System.out.println("λ°°μ΄λͺ¨λ ??? ?©?? " + result + "???€.");
	}

	//Q4
	//λ°°μ΄b? λͺ¨λ ??λ₯? λ°°μ΄a? λ³΅μ¬?? λ©μ?
	void copyArr() {
		int[]a= {1,2,3,4,5,6};
		int[]b= {};
//		int[]b=Arrays.copyOf(a, a.length);
		System.out.println("λ°°μ΄ aλ₯? bλ‘? λ³΅μ¬?©??€");
		System.out.print("??? b\n" );
		print(b);
		b=a.clone();
		System.out.println("[λ³΅μ¬? b]");
		print(b);
	}
	
	void copyArr2() {
		int[]a= {1,2,3,4,5,6};
		int[]b= new int[a.length];
		System.out.println("λ°°μ΄ aλ₯? bλ‘? λ³΅μ¬?©??€");
		System.out.print("[??? b]\n" );
		print(b);
		for (int i = 0; i < a.length; i++) {
			b[i]=a[i];
		}
		System.out.println("[λ³΅μ¬? b]");
		print(b);
	}

	//Q5
	//?΄λ²μ ?­??Όλ‘λ³΅?¬
	void rcopyArr() {
		int[]a= {1,2,3,4,5,6,7};
		int[]b=new int[a.length];
		System.out.println("λ°°μ΄ aλ₯? bλ‘? λ³΅μ¬?©??€");
		System.out.print("[??? b]\n" );
		print(b);
		for (int i = 0; i < a.length; i++) {
			b[a.length-i-1]=a[i];
		}
		System.out.println("[λ³΅μ¬? b]");
		print(b);
		
	}
	
	//Q6
	//λ°°μ΄? ?μͺ½μ ??«?λ¦¬κ? ???Ό ??λ¦¬λ?? ?£?΄?? λ©μ?
	void cardConv() {
		
	}
	
	//Q7
	//κΈ°μλ³??κ³Όμ ? ??Έ? ????΄? λ©μ?
	
	public static void main(String[] args) {
		AlgoChapter2 ag = new AlgoChapter2();
		ag.copyArr2();
		sc.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
