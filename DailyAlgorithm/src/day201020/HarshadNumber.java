package day201020;

import java.util.Scanner;

//	● 히샤드수
//	- 문제설명
//		양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 
//		예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
//		자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
//
//	- 제한 조건
//		x는 1 이상, 10000 이하인 정수입니다.
public class HarshadNumber {
	public static boolean solution(int x) {
		int a = x;
		int sum = 0;
		while (x > 0) {
			sum += x % 10;
			x /= 10;
		}
		return a % sum == 0 ? true : false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자입력 >>");
		int x = sc.nextInt();
		System.out.println(solution(x)?"입력숫자는 하샤드 수입니다":"입력숫자는 하샤드 수가 아닙니다");
		sc.close();
	}

}
