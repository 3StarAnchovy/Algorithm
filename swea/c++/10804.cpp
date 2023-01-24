#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main()
{
	int T;

	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		string input;

		cin >> input;
		for (int i = 0; i < input.length(); i ++)
		{
			if (input[i] == 'b')
				input[i] = 'd';
			else if (input[i] == 'd')
				input[i] = 'b';
			else if (input[i] == 'p')
				input[i] = 'q';
			else if (input[i] == 'q')
				input[i] = 'p';
		}
		reverse(input.begin(), input.end());
		cout << "#" << i + 1 << " " << input << '\n';
	}
}
