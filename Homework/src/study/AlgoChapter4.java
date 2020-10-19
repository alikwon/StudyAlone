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
	//?‹¤?Šµ 4-2ë¥? ? œ?™¸?•˜ê³? IntStack?´? ˆ?Š¤?˜ ë©”ì„œ?“œë¥? ?‚¬?š©?•˜?Š” ?”„ë¡œê·¸?¨ ?‘?„±
	private void practice4_2() {
		IntStack is = new IntStack(64);
		
		while(true) {
			System.out.println("?˜„?¬ ?°?´?„°?ˆ˜ : "+is.size()+"/"+is.capacity());
			System.out.println("[1]?‘¸?‹œ [2]?Œ [3]?”¼?¬ [4]???”„ [5]?¸?±?Š¤?˜¤ë¸? \n[6]?´ë¦¬ì–´ [7]?´ì¦ˆì— ?”„?‹° [8]?´ì¦ˆí? [0]ì¢…ë£Œ");
			
			int menu = sc.nextInt();
			if(menu==0) break;
			
			int x;
			switch (menu) {
			case 1:	//?‘¸?‰¬
				System.out.println("?°?´?„°: ");
				x=sc.nextInt();
				try {
					is.push(x);
				} catch (IntStack.OverflowIntStackException e) {
					System.out.println("?Š¤?ƒ?´ ê°??“ì°¼ìŠµ?‹ˆ?‹¤");
				}
				break;
			case 2:	//?Œ
				try {
					x=is.pop();
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("?Š¤?ƒ?´ ë¹„ì–´?ˆ?–´?š”");
				}
				break;
			case 3:	//?”¼?¬
				try {
					x=is.peek();
					System.out.println("?”¼?¬?•œ ?°?´?„°?Š” "+x+"?…?‹ˆ?‹¤");
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("?Š¤?ƒ?´ ë¹„ì–´?ˆ?–´?š”");
				}
				break;
			case 4: //?¤?”„
				is.dump();
				break;
			case 5:	//?¸?±?Š¤?˜¤ë¸?
				try {
					System.out.println("ì°¾ì„ ?ˆ«?ë¥? ?…? ¥?•˜?„¸?š”>>>");
					int a = sc.nextInt();
					x=is.indexOf(a);
					if(x==-1) {
						System.out.println("?…? ¥ê°’ì´ ?Š¤?ƒ?— ?—†?–´?š”");
					}else {
						System.out.println("?…? ¥ê°’ì? ?Š¤?ƒ?˜ ["+x+"]ë²? index?— ?ˆ?Šµ?‹ˆ?‹¤");
					}
				} catch (IntStack.EmptyIntStackException e) {
					System.out.println("?Š¤?ƒ?´ ë¹„ì–´?ˆ?–´?š”");
				}
				break;
			case 6:
				is.clear();
				System.out.println("?Š¤?ƒ?˜ ëª¨ë“ ê°’ì´ ?‚­? œ??–´?š”");
				break;
			case 7:
				if(is.isEmpty()) System.out.println("?Š¤?ƒ?´ ë¹„ì–´?ˆ?Šµ?‹ˆ?‹¤");
				else System.out.println("?Š¤?ƒ?´ ë¹„ì–´?ˆì§? ?•Š?Šµ?‹ˆ?‹¤");
				break;
			case 8:
				if(is.isFull()) System.out.println("?Š¤?ƒ?´ ê°??“ì°¼ìŠµ?‹ˆ?‹¤");
				else System.out.println("?Š¤?ƒ?— ?—¬?œ ê³µê°„?´ ?‚¨?•„?ˆ?–´?š”");
			default:
				System.out.println("?•Œë§ì? ?•­ëª©ì„ ?„ ?ƒ?•˜?„¸?š”");
				break;
			}
		}
	}
	
	//Q2
	//?„?˜?˜ ê°ì²´?˜• ?°?´?„°ë¥? ?Œ“?„ ?ˆ˜ ?ˆ?Š” ? œ?„¤ë¦? ?Š¤?ƒ?´?˜?Š¤ Gstack<E> ë¥? ?‘?„±?•˜?„¸?š”
	// ???´ >>> Gstack ?´?˜?Š¤ ?ŒŒ?¼
	
	//Q3
	//?•˜?‚˜?˜ ë°°ì—´?„ ê³µìœ ?•˜?—¬ 2ê°œì˜ ?Š¤?ƒ?„ êµ¬í˜„?•˜?Š” int?˜• ?°?´?„°?š© ?Š¤?ƒ ?´?˜?Š¤ë¥? ë§Œë“œ?„¸?š”
	//?Š¤?ƒ?— ???¥?•˜?Š” ?°?´?„°?Š” int?˜• ê°?, ë°°ì—´?˜ ì²˜ìŒê³? ??„ ?‚¬?š©
	// ???´ >>> IntStack_4_3 ?´?˜?Š¤?ŒŒ?¼
	
}
