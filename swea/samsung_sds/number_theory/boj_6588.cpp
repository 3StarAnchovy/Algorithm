#include <iostream>
#include <cmath>
using namespace std;

int isPrimeNumber(int num)
{
	for (int i = 2; i <= sqrt(num); i++)
	{
		if ((num % i) == 0)
			return 0;
	}
	return 1;
}

int main(void)
{
	int n;
	int a, b;

	while (1)
	{
		cin >> n;
		if (n == 0)
			break;
		for (int i = n / 2; i >= 3; i--) // n/2부터 (a,b가 값이 같을때부터)
		{
			a = i;
			b = n - a;
			if (isPrimeNumber(a) && isPrimeNumber(b))
			{
				cout << n << " = " << a << " + " << b;
			}
		}
	}
}
