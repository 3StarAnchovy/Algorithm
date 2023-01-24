#include <iostream>
#include <string>
using namespace std;

int main()
{
	int T;

	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		string tc;
		string input[10000];
		string sNumArray[10] = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
		int iNumArray[10] = {0, };
		int num;

		cin >> tc >> num;

		//input
		for (int i = 0; i < num; i ++)
			cin >> input[i];
		for (int i = 0; i < num; i ++)
		{
			for (int j = 0; j < 9; j ++)
			{
				if (sNumArray[j].compare(input[i]) == 0)
					iNumArray[j] ++;
			}
		}
		cout << "#" << i + 1 <<"\n";
		for (int i = 0; i < 10; i ++)
		{
			for(int j = 0; j < iNumArray[i]; j ++)
				cout << sNumArray[i] << " ";
		}
		cout << "\n";
	}
}
