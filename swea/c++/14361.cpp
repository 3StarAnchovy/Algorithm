#include <iostream>
#include <string>
using namespace std;

int main()
{
	char input[8];
	int T;
	int iOri;
	string sOri;
	char temp;

	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		string result = "impossible";
		cin >> input;
		iOri = stoi(input);
		for (int i = 0; i < 8; i ++)
		{
			for (int j = 1; j < 8; j ++)
			{
				if (input[i] != '\0' && input[j] != '\0')
				{
					temp = input[i];
					input[i] = input[j];
					input[j] = temp;
					if (input[0] != 0 && (stoi(input) % iOri == 0 )&& (stoi(input)) != 1)
					{
						result = "possible";
						break;
					}
				}
			}
		}
		cout << '#' << i + 1 << ' '<< result << '\n';
	}
}
