#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main()
{
	int T;

	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		int input;
		string p = "0";

		cin >> input;
		while(p.length() <= input) // 이따 반복횟수 수정
		{
			string temp = p;
			reverse(temp.begin(),temp.end()); // action_g
			for (int i = 0; i < temp.length(); i ++) // action_f
			{
				if (temp[i] == '0')
					temp[i] = '1';
				else
					temp[i] = '0';
			}
			p.append("0");
			p.append(temp);
		}
		cout << "#" << i + 1 <<" " << p[input - 1] << '\n';
	}
}
