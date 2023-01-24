#include <iostream>
#include <algorithm>
using namespace std;

bool compare(int x, int y)
{
	return x > y;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;

	cin >> T;
	for (int i = 0; i < T; i++)
	{
		int input[7];
		int a = 0;
		int sum[210] = {0};
		//input
		for (int i = 0; i < 7; i++)
			cin >> input[i];
		for (int i = 0; i < 5; i++)
		{
			for (int j = i + 1; j < 6; j++)
			{
				for (int k = j + 1; k < 7; k++)
				{
					sum[a] = input[i] + input[j] + input[k];
					a++;
				}
			}
		}
		sort(sum, sum + 210, compare);
		int b = 1;
		for (int j = 1; j < 210; j++)
		{
			if (sum[j] != sum[j - 1])
				b++;
			if (b == 5)
			{
				cout << "#" << i + 1 << " " << sum[j] << "\n";
				break;
			}
		}
		//cout << "#" << i + 1 << " " <<  << '\n';
	}
}
