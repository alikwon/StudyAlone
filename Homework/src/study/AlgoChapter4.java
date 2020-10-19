package study;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class AlgoChapter4 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		AlgoChapter4 ag = new AlgoChapter4();
		ag.practice4_2();
		sc.close();
	}

	//Q1
	//?��?�� 4-2�? ?��?��?���? IntStack?��?��?��?�� 메서?���? ?��?��?��?�� ?��로그?�� ?��?��
	private void practice4_2() {
		IntStack is = new IntStack(64);
		
		while(true) {
			System.out.println("?��?�� ?��?��?��?�� : "+is.size()+"/"+is.capacity());
			System.out.println("[1]?��?�� [2]?�� [3]?��?�� [4]???�� [5]?��?��?��?���? \n[6]?��리어 [7]?��즈엠?��?�� [8]?��즈�? [0]종료");
			
			int menu = sc.nextInt();
			if(menu==0) break;
			
			int x;
			switch (menu) {
			case 1:	//?��?��
				System.out.println("?��?��?��: ");
				x=sc.nextInt();
				try {
					is.push(x);
				} catch (IntStack.OverflowIntStackException e) {
					System.out.println("?��?��?�� �??��찼습?��?��");
				}
				break;
			case 2:	//?��
				try {
					x=is.pop();
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("?��?��?�� 비어?��?��?��");
				}
				break;
			case 3:	//?��?��
				try {
					x=is.peek();
					System.out.println("?��?��?�� ?��?��?��?�� "+x+"?��?��?��");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("?��?��?�� 비어?��?��?��");
				}
				break;
			case 4: //?��?��
				is.dump();
				break;
			case 5:	//?��?��?��?���?
				try {
					System.out.println("찾을 ?��?���? ?��?��?��?��?��>>>");
					int a = sc.nextInt();
					x=is.indexOf(a);
					if(x==-1) {
						System.out.println("?��?��값이 ?��?��?�� ?��?��?��");
					}else {
						System.out.println("?��?��값�? ?��?��?�� ["+x+"]�? index?�� ?��?��?��?��");
					}
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("?��?��?�� 비어?��?��?��");
				}
				break;
			case 6:
				is.clear();
				System.out.println("?��?��?�� 모든값이 ?��?��?��?��?��");
				break;
			case 7:
				if(is.isEmpty()) System.out.println("?��?��?�� 비어?��?��?��?��");
				else System.out.println("?��?��?�� 비어?���? ?��?��?��?��");
				break;
			case 8:
				if(is.isFull()) System.out.println("?��?��?�� �??��찼습?��?��");
				else System.out.println("?��?��?�� ?��?��공간?�� ?��?��?��?��?��");
			default:
				System.out.println("?��맞�? ?��목을 ?��?��?��?��?��");
				break;
			}
		}
	}
	
	//Q2
	//?��?��?�� 객체?�� ?��?��?���? ?��?�� ?�� ?��?�� ?��?���? ?��?��?��?��?�� Gstack<E> �? ?��?��?��?��?��
	// ???�� >>> Gstack ?��?��?�� ?��?��
	
	//Q3
	//?��?��?�� 배열?�� 공유?��?�� 2개의 ?��?��?�� 구현?��?�� int?�� ?��?��?��?�� ?��?�� ?��?��?���? 만드?��?��
	//?��?��?�� ???��?��?�� ?��?��?��?�� int?�� �?, 배열?�� 처음�? ?��?�� ?��?��
	// ???�� >>> IntStack_4_3 ?��?��?��?��?��
	
}
