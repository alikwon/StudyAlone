package algorithm;

import java.util.Scanner;
import java.util.Stack;

/*
	● 올바른 괄호 찾기
*/
public class Day211204_1 {

	public String solution(String s) {
		
		// 열린 괄호와 닫힌 괄호의 갯수가 다를 때 NO
		if(s.length() % 2 == 1) {
			return "갯수 다름 NO";
		}
		
		char[] charArr = s.toCharArray();
		Stack<Character> st = new Stack<>();
		
		for(char c : charArr) {
			//1. (, {, [ 일 때 Stack에 push 후 continue
			if(checkBracketDirection(c) == 'R') {
				st.push(c);
				continue;
			}
			
			//2. ), }, ] 일 때 
			//2-1. 열린 괄호가 없을 때 NO
			if(st.size() == 0) {
				return "열린 게 없는데 닫힘 NO";
			}
			//2-2. 열린 괄호와 닫힌 괄호가 쌍이 아닐 때 NO
			if(st.pop() != getReverseBracket(c)) {
				return "서로 쌍이 아님 NO";
			}
		}
		
		//2-3. 열린 괄호로 끝날 때
		if(st.size() > 0) {
			return "열린 괄호로 끝남 NO";
		}
		
		return "YES";
	}
	
	public char checkBracketDirection(char c) {
		if(c == '(' || c == '{' || c == '[') {
			return 'R';
		}
		return 'L';
	}
	
	public char getReverseBracket(char c) {
		char ch = 0;
		if(c == ')') {
			ch = '(';
		} else if(c == '}') {
			ch = '{';
		} else if(c == ']') {
			ch = '[';
		}
		return ch;
	}
	

	public static void main(String[] args) {
		Day211204_1 d = new Day211204_1();
		Scanner sc = new Scanner(System.in);
		String str = null;
		while (true) {
			System.out.print("입력 : ");
			str = sc.nextLine();
			if(str.equals("exit")) {
				break;
			}
			System.out.println(d.solution(str));
		}
	}
}