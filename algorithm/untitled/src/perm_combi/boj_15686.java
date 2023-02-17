package day0217;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_15686 {
	static class Position
	{
		int r;
		int c;
		
		public Position(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N;
	static int M;
	static int[][] map;
	static Position[] picked;
	static int chicken_cnt = 0;
	static int house_cnt = 0;
	static int result = Integer.MAX_VALUE;
	static int house_size;
	
	static ArrayList<Position> chicken_arr = new ArrayList<Position>();
	static ArrayList<Position> house_arr = new ArrayList<Position>();
	
	//조합으로 일단 뽑음
	//뽑은거 BFS 할 이유가 있을까?
	//이거 그냥 
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		M = scanner.nextInt();
		
		map = new int[N][N];
		picked = new Position[M];
		for(int i = 0; i < N; i ++)
		{
			for(int j = 0; j < N; j ++)
			{
				map[i][j] = scanner.nextInt();
				if(map[i][j] == 2)
				{
					chicken_cnt ++;
					chicken_arr.add(new Position(i, j));
				}
				
				else if(map[i][j] == 1)
				{
					house_cnt ++;
					house_arr.add(new Position(i, j));
				}
			}
		}
		
		house_size = house_arr.size();
		
		pickChicken(0,0);
		System.out.println(result);
	}

	private static void pickChicken(int cnt, int start) {
		if(cnt == M)
		{
			int sum = 0;
			for(int i = 0; i < house_size; i ++) // house arr
			{
				int min = Integer.MAX_VALUE;
				for(int j = 0; j < M; j ++) // picked
				{
					//정섭 왈 -> 거리를 따로 백업해두는게 낫지 않
					int distance = Math.abs(house_arr.get(i).r - picked[j].r) + Math.abs(house_arr.get(i).c - picked[j].c);
					if(min > distance)
					{
						min = distance;
					}
				}
				sum += min;
			}
			if(result > sum)
				result = sum;
			return ;
		}
		
		for(int i = start; i < chicken_cnt; i ++)
		{
			picked[cnt] = chicken_arr.get(i);
			pickChicken(cnt + 1, i + 1);
		}
		
	}
}
