#include <iostream>
using namespace std;

int main()
{
	int T;

	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		string input;
		int a = 1;
		int b = 1;

		cin >> input;
		for(int i = 0; i < input.length(); i ++)
		{
			if (input[i] == 'L')
			{
				a = a;
				b = a + b;
			}
			else
			{
				a = a + b;
				b = b;
			}
		}
		cout << "#" << i + 1 << " " << a << " " << b << '\n';
	}
}
