#include <iostream>
using namespace std;

int main()
{
	string	alpha = "abcdefghijklmnopqrstuvwxyz";
	string	input;
	int		T;
	int		j = 0;
	int		result;

	cin >> T;
	result = 0;
	for (int i = 0; i < T; i ++)
	{
		cin >> input;
		while (alpha[j] == input[j])
		{
			result ++;
			j ++;
			if (result == 26)
				break;
		}
		cout << "#" <<i + 1 << " " << result << '\n';
		result = 0;
		j = 0;
	}
}
