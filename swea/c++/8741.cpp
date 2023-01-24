#include <iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cout.tie(NULL);
	cin.tie(NULL);

	int T;

	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		string input;
		char result[4];
		result[3] = '\0';
		for(int j = 0; j < 3; j ++)
		{
			cin >> input;
			result[j] = input[0] - ('a' - 'A');
		}
		cout << "#" << i + 1 << " " << result << "\n";
	}
}
