#include <iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;

	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		string input;

		cin >> input;
		int check = input[input.length() - 1] - '0';

		if (check % 2 == 0)
			cout << "#" << i + 1 << " " << "Even" <<"\n";
		else
			cout << "#" << i + 1 << " " << "Odd" <<"\n";
	}
}
