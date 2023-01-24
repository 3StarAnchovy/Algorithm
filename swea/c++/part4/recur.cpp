#include <iostream>
using namespace std;

int doRecursion(int n, int m, int result)
{
	if (m != 0)
		return result * ;
	else
	{
		result *= n;
		m --;
		doRecursion(n,m, result);
	}
}

int main()
{
	for (int i = 0; i < 10; i ++)
	{
		int T;
		int N,M;
		int result = 1;

		cin >> T;
		cin >> N >> M;

		cout << doRecursion(N,M,result) << '\n';
	}
}
