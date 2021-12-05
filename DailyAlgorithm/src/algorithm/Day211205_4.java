package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
● 베스트앨범

[문제 설명]
	스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 
	노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
	┌───────────────────────────────────────────────────────────────────┐
	│ 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.								│
	│ 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.								│
	│ 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.	│
	└───────────────────────────────────────────────────────────────────┘	
	노래의 장르를 나타내는 문자열 배열 genres와 
	노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 
	베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
		
[제한사항]
	- genres[i]는 고유번호가 i인 노래의 장르입니다.
	- plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
	- genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
	- 장르 종류는 100개 미만입니다.
	- 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
	- 모든 장르는 재생된 횟수가 다릅니다.
*/
public class Day211205_4 {

	public int[] solution(String[] genres, int[] plays) {
		ArrayList<Song> genreRankList = makeGenreRankList(genres, plays);

		ArrayList<Song> songRankList = makeSongRankList(genres, plays);

		ArrayList<Integer> list = new ArrayList<>();
		for (Song s : genreRankList) {
			int cnt = 0;
			for (Song ss : songRankList) {
				if(ss.genre.equals(s.genre)) {
					list.add(ss.idx);
					cnt++;
				}
				if(cnt>=2) {
					break;
				}
			}
			
		}
		System.out.println(list.toString());
		int[] answer= new int[list.size()];
		int idx = 0;
		for (Integer i : list) {
			answer[idx] = i;
			idx++;
		}
		return answer;
	}

	public ArrayList<Song> makeSongRankList(String[] genres, int[] plays) {
		ArrayList<Song> list = new ArrayList<>();
		for (int i = 0; i < genres.length; i++) {
			list.add(new Song(i, genres[i], plays[i]));
		}
		Collections.sort(list);
		return list;
	}

	public ArrayList<Song> makeGenreRankList(String[] genres, int[] plays) {
		ArrayList<Song> list = new ArrayList<>();
		HashMap<String,Integer> map = new HashMap<>();
		
		for (int i = 0; i < plays.length; i++) {
			if(!map.containsKey(genres[i])) {
				map.put(genres[i], plays[i]);
				continue;
			}
			map.put(genres[i], map.get(genres[i]) + plays[i]);
		}
		for (String key : map.keySet()) {
			list.add(new Song(key, map.get(key)));
		}
		Collections.sort(list);
		return list;
	}

	class Song implements Comparable<Song> {
		int idx;
		String genre;
		int play;

		public Song(int idx, String genres, int play) {
			this.idx = idx;
			this.genre = genres;
			this.play = play;
		}

		public Song(String genres, int play) {
			this.genre = genres;
			this.play = play;
		}

		@Override
		public String toString() {
			return "[번호=" + idx + ", 장르명=" + genre + ", 재생수=" + play + "]";
		}

		@Override
		public int compareTo(Song s) {
			return s.play - this.play;
		}

	}

	public static void main(String[] args) {
		Day211205_4 d = new Day211205_4();
		String[] genres = { "classic", "pop", "classic", "classic", "classic" };
		int[] plays = { 500, 1000, 400, 300, 200};
		// return = [0, 6, 5, 2, 4, 1]

		int[] answer = d.solution(genres, plays);
		for (int i : answer) {
			System.out.print(i + " ");
		}
	}
}