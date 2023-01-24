#include <iostream>
using namespace std;

int main()
{
	int	T;
	string	input;
	string	result = "YES";
	int		lose_cnt = 0;

	cin >> T;
	for(int i = 0; i < T; i ++)
	{
		cin >> input;
		for(int j = 0; j < input.length(); j ++)
		{
			if (input[j] != 'o')
				lose_cnt ++;
			if (lose_cnt >= 8)
			{
				result = "NO";
				break;
			}
		}
		cout << "#" <<i + 1 << " " << result << '\n';
		result = "YES";
		lose_cnt = 0;
	}
}
