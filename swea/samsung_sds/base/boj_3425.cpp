#include <iostream>
#include <stack>
#include <string>
using namespace std;

stack<int> myStack;
string word;
int num;

int main()
{
	while (1)
	{
		cin >> word;
		if (word.compare("QUIT") == 0)
			return 0;
		else if (word.compare("NUM") == 0)
		{
			cin >> num;
			myStack.push(num);
		}
		else if (word.compare("POP") == 0)
			myStack.pop();
		else if (word.compare("INV") == 0)
		{
			int inv = myStack.top() * -1;
			myStack.pop();
			myStack.push(inv);
		}
		else if (word.compare("DUP") == 0)
			myStack.push(myStack.top());
		else if (word.compare("SWP") == 0)
		{
			int temp = myStack.top();
			myStack.pop();
			int temp2 = myStack.top();
			myStack.pop();
			myStack.push(temp);
			myStack.push(temp2);
		}

		else if (word.compare("TOP") == 0)
			cout << myStack.top();
	}
}
