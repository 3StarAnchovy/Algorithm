#include <iostream>
#include <string>
using namespace std;

int check_string(char a)
{
	string no_hole = "CEFGHIJKLMNSTUVWXYZ";
	string one_hole = "ADOPQR";
	string two_hole = "B";

	for (int i = 0; i < no_hole.length(); i ++)
	{
		if (a == no_hole[i])
			return 0;
		if (a == one_hole[i])
			return 1;
		if (a == two_hole[0])
			return 2;
	}
}

int main()
{
	string no_hole = "CEFGHIJKLMNSTUVWXYZ";
	string one_hole = "ADOPQR";
	string two_hole = "B";
	int temp[10] = {0};

	int T;

	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		string result = "SAME";
		string a;
		string b;

		cin >> a;
		cin >> b;

		int a_len = a.length();
		int b_len = b.length();
		if(a_len != b_len)
			result = "DIFF";
		else
		{
			for (int i = 0; i < a_len; i ++)
			{
				if(check_string(a[i]) != check_string(b[i]))
				{
					result = "DIFF";
					break;
				}
			}
		}
		cout << "#" << i + 1 << " " << result << "\n";
	}
}
