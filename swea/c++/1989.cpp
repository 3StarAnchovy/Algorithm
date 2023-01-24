#include <iostream>
using namespace std;

int main()
{
	int T;

	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		int result = 0;
		string input;

		cin >> input;
		int len = input.length();
		for(int i = 0; i < len / 2; i ++)
		{
			if (input[i] != input[len - 1 - i])
				break;
			if (i == (len / 2) - 1)
				result ++;
		}
		cout << "#" << i + 1 << " " << result << "\n";
	}
}
