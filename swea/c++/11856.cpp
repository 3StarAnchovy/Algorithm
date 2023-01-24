#include <iostream>
using namespace std;

int main()
{
	int	T;
	string input;
	string alpha = "QWERTYUIOPASDFGHJKLZXCVBNM";
	int cnt[26] = {0};
	int result_cnt;
	string result = "No";

	cin >> T;
	for(int i = 0; i < T; i ++)
	{
		cin >> input;
		for (int i = 0; i < input.length(); i ++)
		{
			for (int j = 0; j < 26; j ++)
			{
				if (input[i] == alpha[j])
					cnt[j]++;
			}
		}
		result_cnt = 0;
		for(int i = 0; i < 26; i ++)
		{
			if (cnt[i] == 2)
			{
				result_cnt ++;
			}
		}
		if (result_cnt == 2)
			result = "Yes";
		cout << "#" << i + 1 << ' '<< result << '\n';
		for (int i = 0; i < 26; i ++)
			cnt[i] = 0;
		result = "No";
	}

}
