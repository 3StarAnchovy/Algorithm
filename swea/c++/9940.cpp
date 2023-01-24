#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	int T;
	cin >> T;

	for (int i = 0; i < T; i ++)
	{
		int num;
		int arr[100000] = { 0 };
		string result = "Yes";

		cin >> num;
		for (int i = 0; i < num ; i ++)
			cin >> arr[i];
		sort(arr, arr + num);
		for (int i = 0; i < num - 1 ; i ++)
		{
			if (arr[i] + 1 != arr[i + 1])
			{
				result = "No";
				break;
			}
		}
		cout << '#' << i + 1 << ' ' << result << '\n';
	}
}
