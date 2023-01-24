#include <iostream>
using namespace std;

int main()
{
	int T;

	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		int num;
		cin >> num;
		cout << '#' <<i + 1 << ' ' << num / 3 << '\n';
	}
}
