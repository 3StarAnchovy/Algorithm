#include <iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	for (int i = 0; i < 10; i ++)
	{
		int N;
		int building[1000] = {0};
		cin >> N;
		for (int i = 0; i < N; i ++)
			cin >> building[i];
		int result = 0;
		for (int i = 2 ; i < N; i ++)
		{
			int left_1 = building[i] - building[i - 2];
			int left_2 = building[i] - building[i - 1];
			int right_1 = building[i] - building[i + 2];
			int right_2 = building[i] - building[i + 1];
			if(left_1 > 0 && left_2 > 0 && right_1 > 0 && right_2 > 0)
			{
				int left = min(left_1,left_2);
				int right = min(right_1, right_2);
				int total = min(left,right);
				result += total;
			}
		}
		cout << "#" << i + 1 << " " << result << '\n';
	}
}
