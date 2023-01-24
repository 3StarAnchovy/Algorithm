#include<iostream>
using namespace std;

int main()
{
	int	T;
	int	N;
	int	D;
	int result;
	int temp;

	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		cin >> N >> D;
		result = N / (D * 2 + 1);
		temp = N % (D * 2 + 1);
		if ((temp > 0))
			result ++;
		cout << "#" << i + 1 << " " << result << '\n';
	}
}
