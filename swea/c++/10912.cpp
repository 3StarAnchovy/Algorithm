#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main()
{
	int T;

	cin >> T;
	for(int i = 0; i < T; i ++)
	{
		string input;
		char result[100] ={0};
		int cnt = 0;

		cin >> input;
		sort(input.begin(),input.end());
		for(int i = 0; i < input.length(); i ++) // 마지막 문자열 예외처리
		{
			if(input[i] == input[i + 1])
				i ++;
			else
			{
				result[cnt] = input[i];
				cnt ++;
			}
		}
		if (cnt == 0)
			cout << "#" << i + 1 << " " << "Good" << '\n';
		else
			cout << "#" << i + 1 << " " << result << '\n';
	}
}
