#include <iostream>
using namespace std;

int main()
{
	int T;

	scanf("%d", &T);
	for (int i = 0; i < T; i ++)
	{
		long long input;

		scanf("%lld", &input);
		long long sum = 0;
		while (input > 9)
		{
			//action
			while(input != 0)
			{
				sum += input % 10;
				input /= 10;
			}
			input = sum;
			sum = 0;
		}
		printf("#%d %lld\n",i+1,input);
	}
}
