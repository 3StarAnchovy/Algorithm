#include <iostream>
#include <queue>
using namespace std;

int main()
{
	for(int i = 0; i < 10; i ++)
	{
		int t;
		int input;
		queue<int> arr;
		int iNum = 1;

		cin >> t;
		//init
		for (int i = 0; i < 8; i ++)
		{
			cin >> input;
			arr.push(input);
		}
		while (arr.back() != 0)
		{
			int temp = arr.front();
			arr.pop();
			if (temp - iNum <= 0)
			{
				arr.push(0);
				break;
			}
			else
				arr.push(temp - iNum);
			iNum ++;
			if (iNum == 6)
				iNum = 1;
		}
		cout << "#" << i + 1 << " ";
		while (!arr.empty())
		{
			cout << arr.front() << " ";
			arr.pop();
		}
		cout << "\n";
	}
}
