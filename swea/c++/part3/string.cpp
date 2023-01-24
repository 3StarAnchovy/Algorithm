#include <iostream>
#include <string>
using namespace std;

int main()
{
	for(int i = 0; i < 10 ; i ++)
	{
		int t;
		string find;
		string input;
		int cnt = 0;
		cin >> t;
		cin >> find;
		cin >> input;
		for (int i = 0; i < input.length(); i ++)
		{
			if (find[0] == input[i])
			{
				for (int j = 0; j < find.length(); j ++)
				{
					if (find[j] != input[i + j])
						break;
					if (j == find.length() - 1)
						cnt ++;
				}
			}
		}
		cout << '#' << i + 1 << ' ' << cnt << '\n';
	}
}
