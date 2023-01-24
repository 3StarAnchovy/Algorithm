#include <iostream>
using namespace std;

int main()
{
	for (int i = 0; i < 10; i ++)
	{
		int num;
		string input[8];
		cin >> num;
		for (int i = 0; i < 8; i ++)
			cin >> input[i];
		int cnt = 0;
		for (int i = 0; i < 8; i ++)
		{
			for (int j = 0; j <= 8 - num; j ++) // 행 체크
			{
				for(int k = 0 ; k < num / 2; k ++)
				{
					if (input[i][j + k] != input[i][4 - (j + k) - 1]) break;
					else if(k == num / 2 - 1)
						cnt ++;
				}
			}
			cout << cnt << '\n';
		}

	}
}
