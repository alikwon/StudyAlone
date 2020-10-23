package algorithm;
/*
●문자열을 정수로 바꾸기

	문제 설명
		문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요.

	제한 조건
		-s의 길이는 1 이상 5이하입니다.
		-s의 맨앞에는 부호(+, -)가 올 수 있습니다.
		-s는 부호와 숫자로만 이루어져있습니다.
		-s는 0으로 시작하지 않습니다.
*/

public class day201022_4 {
	public static int solution(String s) {
        String []arr=s.split("");
        if(arr[0].equals("-")){
            String a="";
            for(int i=1;i<arr.length;i++){
                a+=arr[i];
            }
            int n=Integer.parseInt(a);
            return -n;
        }
        return Integer.parseInt(s);
    }
	public static void main(String[] args) {
		System.out.println(solution("1234"));;
	}
}
