#include <iostream>
#include <string>
using namespace std;

// string getBinary(int iNum)
// {
// 	string bNum = "";
// 	while (iNum != 0)
// 	{
// 		bNum.append(to_string((iNum % 2)));
// 		iNum /= 2;
// 	}
// 	cout <<bNum;
// }

int main()
{
	int TC;
	int N;
	int M;
	string result = "ON";

	cin >> TC;
	//getBinary(TC);

	for (int i = 0; i < TC; i++)
	{
		cin >> N >> M;
		for (int j = 0; j < N; j++)
		{
			if ((M % 2) != 1)
			{
				result = "OFF";
				break;
			}
			M /= 2;
		}
		cout << "#" << i + 1 << " " << result << '\n';
		result = "ON";
	}
}
