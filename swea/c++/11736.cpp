#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main()
{
	int T;
	int input[20];

	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		int N;
		int cnt = 0;
		cin >> N;
		for (int i = 0; i < N; i ++) //init
			cin >> input[i];
		//action
		for(int i = 1; i < N - 1; i ++)
		{
			int left = input[i - 1];
			int mid = input[i];
			int right = input[i + 1];
			if (left < mid && mid < right || left > mid && mid > right)
				cnt ++;
		}
		cout << '#' << i + 1 << ' ' << cnt << '\n';
	}
}
