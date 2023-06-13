package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1_final {
	static boolean[] isUsed;
	static boolean[] picked;
	static int[] numbers;
	static int N, max;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			picked = new boolean[N];
			numbers = new int[N];
			max = 0;
			pick(0);
			
			System.out.println("#"+tc+" "+max);
		}
		
		br.close();
	}

	/**
	 * //1. ǳ�� ��Ʈ���� ���� -> ����
		//2. ��Ʈ����(list)
		//2-1. ���ʿ� ������ �����Ѵٸ� ����ŭ ����
		//2-2. �� ���� ������ �����Ѵٸ� �ش� ���� ����
		//2-3. ���� ��� ������ ���ٸ� ���� ���� ����
		//2-4. ������ ��� pass
	 * @param cnt
	 */
	private static void pick(int cnt) {
		if(cnt == N) {
			isUsed = new boolean[N];
			max = Math.max(max, game());
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(picked[i]) continue;
			picked[i] = true;
			numbers[cnt] = i;
			pick(cnt+1);
			picked[i]=false;
		}
		
	}

	private static int game() {
		int grade = 0;
		
		for(int i=0; i<N; i++) {
			int idx = numbers[i];
			isUsed[idx] = true;

			int left = leftCheck(idx);
			int right = rightCheck(idx);
			
			//2-3. ���� ��� ������ ���ٸ� ���� ���� ����
			if(left == -1 && right==-1) {
				grade += list.get(idx);
			}
			//2-2. �� ���� ������ �����Ѵٸ� �ش� ���� ����
			else if(left==-1 && right != -1) {
				grade += list.get(right);
			}
			else if(left != -1 && right == -1) {
				grade += list.get(left);
			}
			//2-1. ���ʿ� ������ �����Ѵٸ� ����ŭ ����
			else {
				grade +=(list.get(left)*list.get(right));
			}
		}
		
		return grade;
		
	}

	private static int rightCheck(int idx) {
		while(true) {
			if(idx >= N) return -1;
			
			if(!isUsed[idx]) {
				return idx;
			}
			else{
				idx++;
			}
		}
	}

	private static int leftCheck(int idx) {
		while(true) {
			if(idx < 0) return -1;
			
			if(!isUsed[idx]) {
				return idx;
			}
			else{
				idx--;
			}
		}
	}

}
