#include <iostream>
using namespace std;

int main()
{
	string week[7] = {"MON" , "TUE" , "WED", "THU", "FRI", "SAT", "SUN"};
	int T;

	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		string input;
		int result;
		cin >> input;
		for (int j = 0; j < 7; j ++)
		{
			if (input.compare(week[j]) == 0)
			{
				if (j == 6)
					result = 7;
				else
					result =  7 - j - 1;
			}
		}
		cout << '#' << i + 1 << ' ' << result << '\n';
	}
}
