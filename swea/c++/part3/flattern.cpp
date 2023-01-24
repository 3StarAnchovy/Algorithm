#include <iostream>
#include <algorithm>
using namespace std;

int findMaxIndex(int box[])
{
	int max_idx = 0;
	int max = box[0];

	for (int i = 0; i < 100; i ++)
	{
		if (max < box[i])
		{
			max = box[i];
			max_idx = i;
		}
	}
	return max_idx;
}

int findMinIndex(int box[])
{
	int min_idx = 0;
	int min = box[0];

	for (int i = 0; i < 100; i ++)
	{
		if (min > box[i])
		{
			min = box[i];
			min_idx = i;
		}
	}
	return min_idx;
}


int main()
{
	for (int i = 0; i < 10; i ++)
	{
		int box[100];
		int cnt;

		cin >> cnt;
		for (int i = 0; i < 100; i ++)
			cin >> box[i];
		for (int i = 0; i < cnt; i ++)
		{
			int max_idx = findMaxIndex(box);
			int min_idx = findMinIndex(box);
			box[max_idx] --;
			box[min_idx] ++;
		}
		cout <<"#" << i + 1 << " " <<box[findMaxIndex(box)] - box[findMinIndex(box)] << '\n';
	}
}
