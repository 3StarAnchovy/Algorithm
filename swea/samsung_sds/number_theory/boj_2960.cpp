#include <iostream>
#include <cmath>
#include <vector>
using namespace std;

int isPrimeNumber(int num)
{
	for (int i = 2; i <= sqrt(num) ; i ++)
	{
		if ((num % i) == 0)
			return 0;
	}
	return 1;
}

int main(void)
{
	int N,K;
	cin >> N >> K;
	vector<int> arr;

	for(int i = 2; i <= N ; i ++)
	{
		if(isPrimeNumber(i) == 1)
		{
			arr.push_back(i);
		}
	}
	for (int i = 0; i <arr.size(); i ++)
		cout <<arr[i] << ' ';
}
