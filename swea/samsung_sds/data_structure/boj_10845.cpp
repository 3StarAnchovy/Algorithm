#include <iostream>
#include <queue>
using namespace std;

int main(void)
{
	queue<int> myQueue;
	int input;
	int num;
	string command;

	cin >> input;
	for (int i = 0; i < input; i++)
	{
		cin >> command;
		if (command == "push")
		{
			cin >> num;
			myQueue.push(num);
		}
		else if (command == "pop")
		{
			if (!myQueue.empty())
			{
				cout << myQueue.front() << "\n";
				myQueue.pop();
			}
			else
				cout << -1<< "\n";
		}
		else if (command == "size")
			cout << myQueue.size()<< "\n";
		else if (command == "empty")
			cout << myQueue.empty()<< "\n";
		else if (command == "front")
		{
			if (!myQueue.empty())
				cout << myQueue.front()<< "\n";
			else
				cout << -1<< "\n";
		}
		else if (command == "back")
		{
			if (!myQueue.empty())
				cout << myQueue.back()<< "\n";
			else
				cout << -1 << "\n";
		}
		//cout << "\n";
	}
}
