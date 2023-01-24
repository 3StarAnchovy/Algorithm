#include <iostream>
using namespace std;

int main()
{
	int T;
	int cnt;
	string sInput;

	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		cin >> sInput;
		cnt = 0;
		for (int i = 0; i < sInput.length(); i ++)
		{
			if (sInput[i] == '(')
				cnt ++;
			if (sInput[i] == ')' && sInput[i - 1] != '(')
				cnt ++;
		}
		cout << "#" << i +1 << " " << cnt << '\n';
	}
}
