package algorithm;

import java.util.ArrayList;
import java.util.Stack;

/*
● 크레인 인형뽑기 게임

	[문제설명]
		https://programmers.co.kr/learn/courses/30/lessons/64061
		
	[제한사항]
		- board 배열은 2차원 배열로 크기는 5 x 5 이상 30 x 30 이하입니다.
		- board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다.
			- 0은 빈 칸을 나타냅니다.
			- 1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며
				같은 숫자는 같은 모양의 인형을 나타냅니다.
		- moves 배열의 크기는 1 이상 1,000 이하입니다.
		- moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.
*/
public class Day201030_2 {

	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		ArrayList<Integer>list = new ArrayList<>();
		int top=0;
		for (int i = 0; i < moves.length; i++) {
			int move = moves[i]-1;
			if(list.size()>0)
				top=list.get(list.size()-1);
			for (int j = 0; j < board.length; j++) {
				if(board[j][move]!=0) {
					if(top==board[j][move]) {
						list.remove(list.size()-1);
						answer+=2;
					}else {
						list.add(board[j][move]);
					}
					board[j][move]=0;
					break;
				}
			}
		}
		
		return answer;
	}
	public int solution2(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer>st=new Stack<Integer>();
		int top=0;
		int move;
		for (int i = 0; i < moves.length; i++) {
			move = moves[i]-1;
			if(!st.isEmpty())
				top=st.peek();
			for (int j = 0; j < board.length; j++) {
				if(board[j][move]!=0) {
					if(top==board[j][move]) {
						st.pop();
						answer+=2;
					}else {
						st.push(board[j][move]);
					}
					board[j][move]=0;
					break;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Day201030_2 d = new Day201030_2();
		
		int[][]board= {
					{0,0,0,0,0},
					{0,0,1,0,3},
					{0,2,5,0,1},
					{4,2,4,4,2},
					{3,5,1,3,1}};
		
		
		int[]moves= {1,5,3,5,1,2,1,4};
		System.out.println("스코어 : "+d.solution2(board, moves));
	}
}


















