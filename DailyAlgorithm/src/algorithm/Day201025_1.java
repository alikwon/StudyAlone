package algorithm;

/*
● 2016년
	문제 설명
		2016년 1월 1일은 금요일입니다.2016년 a월 b일은 무슨 요일일까요? 
		두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, 
		solution을 완성하세요. 
		요일의 이름은 일요일부터 토요일까지 
		각각 SUN,MON,TUE,WED,THU,FRI,SAT입니다. 
		예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.
	
	제한 조건
		- 2016년은 윤년입니다.
		- 2016년 a월 b일은 실제로 있는 날입니다. 
		  (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
*/
public class Day201025_1 {
	
	public String solution(int a, int b) {
        String [] s = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int sum=0;
        for(int i=1;i<a;i++){
            if(i==2)
                sum+=29;
            else if(i==4||i==6||i==9||i==11)
                sum+=30;
            else
                sum+=31;
        }
        return s[(sum+b)%7];
    }
	
	//다른사람 풀이
	public String solution2(int a, int b) {
	      int[] c = {31,29,31,30,31,30,31,31,30,31,30,31};
	      String[] s ={"FRI","SAT","SUN","MON","TUE","WED","THU"};
	      int aDate = 0;
	      for(int i = 0 ; i< a-1; i++){
	          aDate += c[i];
	      }
	      aDate += b-1;
	      return s[aDate %7];
	  }
	public static void main(String[] args){
		
	}
}
