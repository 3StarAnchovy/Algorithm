#include <iostream>
using namespace std;

int getMax(int arr[])
{
	int max = 0;
	for (int i = 0; i < 100; i ++)
	{
		if (max < arr[i])
			max = arr[i];
	}

	return (max);
}

int main()
{
	for (int i = 0; i < 10; i ++)
	{
		int t;
		int arr[100][100];
		int row[100] = {0};
		int col[100] = {0};
		int left_dae = 0;
		int right_dae = 0;
		cin >> t;
		//init
		for (int i = 0; i < 100; i ++)
		{
			for (int j = 0; j < 100; j ++)
				cin >> arr[i][j];
		}

		//sum row & col
		for (int i = 0; i < 100; i ++)
		{
			for (int j = 0; j < 100; j ++)
			{
				row[i] += arr[i][j];
				col[j] += arr[i][j];
			}
		}

		//sum 대각
		for (int i = 0; i < 100 ; i ++)
		{
			left_dae += arr[i][i];
			right_dae += arr[i][100 - (i + 1)];
		}

		//find_max
		int row_max = getMax(row);
		int col_max = getMax(col);
		int dae_max = max(left_dae, right_dae);
		int a_max = max(row_max,col_max);
		int b_max = max(col_max,dae_max);
		int result = max(a_max,b_max);


		cout << "#" << i + 1 << " " << result << "\n";
	}
}
