package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
● 그룹 단어 체커 분류

[문제설명]
	그룹 단어란 단어에 존재하는 모든 문자에 대해서, 
	각 문자가 연속해서 나타나는 경우만을 말한다. 
	
	예를 들면, 
	ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, 
	kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, 
	aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
	
	단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.

[입력]
첫째 줄에 단어의 개수 N이 들어온다. N은 100보다 작거나 같은 자연수이다. 
둘째 줄부터 N개의 줄에 단어가 들어온다. 
단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.

[출력]
첫째 줄에 그룹 단어의 개수를 출력한다.

*/
public class Day201111_3 {

	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int answer=0;
//		int n = Integer.parseInt(br.readLine());
//		char[]c=null;
//		char tmp = ' ';
//		int cnt=0;
//		for (int i = 0; i < n; i++) {
//			String str = br.readLine();
//			cnt=0;
//			c=str.toCharArray();
//			tmp=c[0];
//			for (int j = 1; j < c.length; j++) {
//				if(tmp!=c[j]) {
//					cnt++;
//					tmp=c[j];
//				}
//			}
//			for (int j = 0; j <c.length-1; j++) {
//	        	tmp=0;
//				for (int k = 1; k <c.length-j ; k++) {
//					if(c[k-1]>c[k]) {
//						tmp=c[k];
//						c[k]=c[k-1];
//						c[k-1]=tmp;
//					}
//				}
//			}
//			tmp=c[0];
//			for (int j = 1; j < c.length; j++) {
//				if(tmp!=c[j]) {
//					cnt--;
//					tmp=c[j];
//				}
//			}
//			if(cnt==0) {
//				answer++;
//			}
//		}
//		br.close();
//		bw.write(answer+"");
//		bw.flush();
//		bw.close();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = n;
		for (int i = 0; i < n; i++) {
			int[] arr = new int[26];
			String str = br.readLine();
			arr[str.charAt(0) - 97] += 1;
			for (int j = 1; j < str.length(); j++) {
				if (str.charAt(j - 1) == str.charAt(j)) {
					continue;
				} else {
					arr[str.charAt(j)-97] += 1;
				}
			}
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] > 1) {
					cnt--;
					break;
				}
			}
		}
		br.close();
		System.out.println(cnt);
	}
}
