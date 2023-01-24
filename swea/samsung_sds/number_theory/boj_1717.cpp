#include <iostream>
using namespace std;

int unionArray[1000001];

int doFind(int x)
{
	if(unionArray[x] == x)
		return x;
	return unionArray[x] = doFind(unionArray[x]);
}

int doUnion(int x, int y)
{

}

int main(void)
{
	int N, M;
	cin >> N >> M;
	for (int i = 0; i<=N; i ++)
		unionArray[i] = i;
	for (int i = 0; i<= M; i ++)
	{
		int flag, a, b;
		cin >> flag >> a >> b;
		if (flag == 0)
		{

		}
		else if (flag == 1)
		{

		}
	}
}
