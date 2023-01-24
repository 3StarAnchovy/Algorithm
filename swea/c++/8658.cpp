#include <iostream>
using namespace std;

int main()
{
	int T;

	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		int input;
		int max = 0;
		int min = 100000;

		for(int i = 0; i < 10; i ++)
		{
			cin >> input;
			int result = 0;
			while(input != 0)
			{
				result += input % 10;
				input /= 10;
			}
			if (result > max)
				max = result;
			if (result < min)
				min = result;
		}
		cout << "#" << i + 1 << " " << max << " " << min << "\n";
	}
}
