#include <iostream>
using namespace std;

int main()
{
	int T;
	string input;
	int mmyyFlag;
	int yymmFlag;

	cin >> T;
	for(int i = 0; i < T; i ++)
	{
		mmyyFlag = 0;
		yymmFlag = 0;
		cin >> input;
		if(input[0] >= '1' && input[1] >= '3')
			yymmFlag = 1;
	}
}