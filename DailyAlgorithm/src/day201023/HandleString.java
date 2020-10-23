package day201023;

/*
● 문자열 다루기 기본
	문제 설명
		문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, 
		solution을 완성하세요. 
		예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.
	
	제한 사항
		- s는 길이 1 이상, 길이 8 이하인 문자열입니다.
*/
public class HandleString {

	//charAt이용 , for문 돌리기
	public boolean solution(String s) {
		int len = s.length();
		if(len==4||len==6) {
			for (int i = 0; i < len; i++) {
				if(!(s.charAt(i)>='0'&&s.charAt(i)<='9'))
					return false;
			}
		}else
			return false;
		return true;
	}
	
	//Integer.parseInt 시 발생하는 예외 이용
	public boolean solution2(String s) {
		int len = s.length();
		if (len == 4 || len == 6) {
			try {
				int a = Integer.parseInt(s);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		} else
			return false;
	}
	
	public static void main(String[] args) {
		HandleString h = new HandleString();
		String s = "12345";
		System.out.println(h.solution(s)?
				"숫자로만 구성":"숫자아닌거 섞였거나 4자리 혹은 6자리가 아님");
	}

}
