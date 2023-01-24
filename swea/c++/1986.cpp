#include <iostream>
using namespace std;

bool isJjak(int num)
{
	if ((num & 1) != 1)
		return true;
	return false;
}

int main()
{
	int flag;
	int N;
	int T;
	int result;
	int temp;

	flag = -1;
	result = 0;
	temp = 0;
	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		cin >> N;
		for (int i = 1; i <= N; i ++)
		{
			if(isJjak(i))
				temp = flag * i;
			else
				temp = i;
			result += temp;
		}
		cout <<"#"<<i + 1<<" "<<result<<"\n";
		result = 0;
	}

}
