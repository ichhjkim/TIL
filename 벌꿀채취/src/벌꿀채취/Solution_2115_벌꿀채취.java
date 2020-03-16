package 벌꿀채취;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취 {
	static int N, M, C;
	static int[][] map, maxMap; // map: 입력된 벌통 정보, maxMap: ㅑ, j위치에서 가질 수 잇는 최대 이익
	
	public static void main(String[] args) {
		
		BufferedReader in new BufferedReader(
				new InputStreamReader(System.in)
				);
		int T = Integer.parseInt(in.readLine());
		
		for (int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M =  Integer.parseInt(st.nextToken());
			C =  Integer.parseInt(st.nextToken());
			map = new int[N][N];
			maxMap = new int[N][N];
			
			for (int i=0;i<N;i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j=0; j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			// 1. 각 i, j 위치에서 연속된 M개를 고려하여 취할 수 있는 부분집합의 최대 이익 계싼
			
			private static void makeMaxMap() {
				for(int i=0;i<N; i++) {
					for (int j=0; j<= N-M;j++) {
						
					}
				}
			}
			// 2. 두 일꾼의 조함
			
			private static void makeMaxSubset (int i, int j, int cnt, int sum, int powSum) {
				
				
				// 선택
				
				// 비선택
			}
		}
		
		
	}
}
