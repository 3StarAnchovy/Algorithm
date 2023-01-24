#include <iostream>
using namespace std;

bool isHol(int num)
{
	if (num & 1 == 1)
		return true;
	return false;
}

int main()
{
	int T;
	int sum;
	int num[10];

	cin >> T;

	//input
	for (int i = 0; i < T; i++)
	{
		sum = 0;
		for (int j = 0; j < 10; j++)
		{
			cin >> num[j];
			if(isHol(num[j]))
				sum += num[j];
		}
		cout << "#"<<i + 1 << " "<< sum <<"\n";
		sum = 0;
	}
}
