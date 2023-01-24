#include <iostream>
#include <string>
using namespace std;

int main()
{
	int T;
	string sNum;
	cin >> T;

	for (int i = 0; i < T; i ++)
	{
		int max, min;
		cin >> sNum;
		int iNum = stoi(sNum);
		int len = sNum.length();
		max = iNum;
		min = iNum;
		for(int i = 0; i < len - 1; i ++)
		{
			for (int j = 1; j < len; j ++)
			{
				if (i == 0 && sNum[j] == '0') //처음에 0 들어오는거 체크
					continue;
				string temp = sNum;
				char iTemp;
				iTemp = temp[j];
				temp[j] = temp[i];
				temp[i] = iTemp;
				int result = stoi(temp);
				if (result > max)
					max = result;
				if (result < min)
					min = result;
			}
		}
		cout << '#' << i + 1 << ' ' << min << ' ' << max << '\n';
	}
}
