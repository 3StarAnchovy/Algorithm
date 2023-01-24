#include <iostream>
#include <string>
using namespace std;

int isBest(string sGop)
{
	for (int i = 0; i < sGop.length() - 1; i ++)
	{
		if (sGop[i] + 1 != sGop[i + 1])
			return 0;
	}
	return 1;
}

int main()
{
	cin.tie(0);
    cout.tie(0);
    ios::sync_with_stdio(false);

	int T;

	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		int N;
		int input[1000];
		int result = -1;

		cin >> N;
		for (int i = 0; i < N; i ++)
			cin >> input[i];
		for (int i = 0; i < N - 1; i ++)
		{
			for (int j = 0; j < N; j ++)
			{
				int gop = input[i] * input[j];
				string sGop = to_string(gop);
				if (isBest(sGop) == 1 && gop > result)
					result = gop;
			}
		}
		cout << "#" << i + 1 << " " << result << "\n";
		//result를 long으로 바꿔야되나 싯팔
	}
}
