#include <iostream>
using namespace std;

int main()
{
	int T;
	string input;
	string result = "yes";
	int check[8] = {0};
	int ga_cnt;
	int look_cnt;

	cin >> T;
	for (int i = 0; i < T; i++)
	{
		look_cnt = 0;
		result = "yes";
		for (int i = 0; i < 8; i ++)
			check[i] = 0;
		for (int k = 0; k < 8; k++)
		{
			cin >> input;
			//가로 체크
			ga_cnt = 0;
			for (int i = 0; i < 8; i++)
			{
				if (input[i] == 'O' && ga_cnt == 0)
				{
					check[i] ++;
					ga_cnt++;
					look_cnt ++;
					continue;
				}
				if (input[i] == 'O' && ga_cnt != 0)
				{
					check[i] ++;
					result = "no";
				}
			}
			//세로 체크
			for (int j =0; j < 8; j ++)
			{
				if (check[j] >= 2)
					result = "no";
			}
		}
		if (look_cnt != 8)
			result = "no";
		cout << "#" << i + 1 << " "<< result << '\n';
	}
}
