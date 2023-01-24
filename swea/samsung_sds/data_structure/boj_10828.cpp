#include <iostream>
#include <stack>
using namespace std;

int main(void)
{
	stack<int> myStack;
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
			myStack.push(num);
		}
		if (command == "pop")
		{
			if (myStack.empty() == 0)
			{
				cout << myStack.top() << "\n";
				myStack.pop();
			}
			else
				cout << "-1" << "\n";
		}
		if (command == "top")
		{
			if (myStack.empty() == 0)
				cout << myStack.top() << "\n";
			else
				cout << "-1" << "\n";
		}
		if (command == "size")
			cout << myStack.size() << "\n";
		if (command == "empty")
			cout << myStack.empty() << "\n";
	}
}
