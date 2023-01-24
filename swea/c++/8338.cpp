#include <iostream>

using namespace std;

int main()
{
	int T;

	scanf("%d", &T);
	for (int i = 0; i < T; i++)
	{
		int N;
		int input[9];
		int result = 0;
		int hap;
		int gop;
		scanf("%d", &N);
		for (int i = 0; i < N; i++)
			scanf("%d", &input[i]);
		if (N == 1)
			result = input[0];
		else
		{
			hap = input[0] + input[1];
			gop = input[0] * input[1];
			if (hap > gop)
				result = hap;
			else
				result = gop;
			for (int i = 2; i < N; i++)
			{
				hap = result + input[i];
				gop = result * input[i];
				if (hap > gop)
					result = hap;
				else
					result = gop;
			}
		}

		printf("#%d %d \n", i + 1, result);
	}
}
