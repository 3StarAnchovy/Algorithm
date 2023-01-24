#include <iostream>
#include <cmath>
using namespace std;

int main()
{
	int T;

	cin >> T;
	for (int i = 0; i < T; i ++)
	{
		float input;
		float sum = 0;
		for (int i = 0 ; i < 10; i ++)
		{
			cin >> input;
			sum += input;
		}
		cout << "#" <<i + 1 <<" "<< floor(sum / 10 + 0.5) << "\n";
	}
}
