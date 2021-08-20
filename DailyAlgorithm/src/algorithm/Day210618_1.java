package algorithm;

import java.util.HashMap;
import java.util.Map;

public class Day210618_1 {
	public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCnt = 0;
        int same = 0;
        for (int l : lottos) {
        	if(l==0) {
        		zeroCnt++;
        		continue;
        	}
			for (int w : win_nums) {
				if(l==w) {
					same++;
					break;
				}
			}
		}
        return new int[] {7-(same+zeroCnt),7-same};
    }
	
	public static void main(String[] args) {
		Day210618_1 d = new Day210618_1();
		int[] lottos1 = { 44, 1, 0, 0, 31, 25 };
		int[] lottos2 = { 0, 0, 0, 0, 0, 0 };
		int[] lottos3 = { 45, 4, 35, 20, 3, 9 };

		int[] win_nums1 = { 31, 10, 45, 1, 6, 19 }; // [3,5]
		int[] win_nums2 = { 38, 19, 20, 40, 15, 25 };// [1,6]
		int[] win_nums3 = { 20, 9, 3, 45, 4, 35 }; // [1,1]
		
		int[] result = d.solution(lottos2, win_nums2);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+"/");
		}
	}
}
