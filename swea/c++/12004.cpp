#include <iostream>
using namespace std;

int main()
{
	int T;

	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		int num;
		string result = "No";
		cin >> num;
		for (int i = 1; i < 10; i ++)
		{
			if (num / i <= 9 && num % i == 0)
				result = "Yes";
		}
		cout << '#' << i + 1 << ' ' << result << '\n';
	}
}
