#include <iostream>
using namespace std;

int main()
{
	int T;

	scanf("%d", &T);
	for (int i = 0; i < T; i++)
	{
		int N;
		string result = "NO";
		string input;
		int dae_cnt[20][20] = {0};
		int check_sae[20] = {0};

		scanf("%d", &N);
		for (int i = 0; i < N; i++)
		{
			cin >> input;
			//가로 체크
			int ga_cnt = 0;
			for (int j = 0; j < N; j++)
			{
				if (input[j] == 'o')
				{
					ga_cnt++;
					check_sae[j]++;
					dae_cnt[i][j]++;
					//대각 카운팅
				}
			}
			if (ga_cnt >= 5)
				result = "YES";
		}
		for (int i = 0; i < N; i++)
		{
			if (check_sae[i] >= 5)
				result = "YES";
		}
		//대각 체킹
		int a = 0;
		int b = 0;

		for (int i = 0; i < N; i ++)
		{
			if(dae_cnt[i][i] ==1)
				a ++;
			if(dae_cnt[i][N - 1 -i] == 1)
				b ++;
		}
		if (a >= 5 || b >= 5)
			result = "YES";
		cout << '#' << i + 1 << ' ' << result << '\n';
	}
}
