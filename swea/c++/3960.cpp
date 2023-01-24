#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main()
{
	int T;

	cin >> T;

	for (int i = 0; i < T; i ++)
	{
		string A,B;
		char sum[203];

		cin >> A >> B;

		int a_len = A.length();
		int b_len = B.length();
		int big_len = (a_len,b_len);
		int temp = 0;

		for(int i = big_len - 1; i >= 0; i --)
		{
			char digit = A[i] + B[i] - '0' + temp;
			if (digit >= 10 + '0')
			{
				temp = 1;
				digit -= 10;
			}
			else
				temp = 0;
		}
	}
}

