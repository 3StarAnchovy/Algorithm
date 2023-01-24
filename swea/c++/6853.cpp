#include <iostream>
using namespace std;

int main()
{
	int T;

	cin >> T;
	for (int i = 0; i < T; i++)
	{
		int x1, y1, x2, y2;
		int N;
		int inner_cnt = 0;
		int outer_cnt = 0;

		cin >> x1 >> y1 >> x2 >> y2;
		int left_x = min(x1, x2);
		int right_x = max(x1, x2);
		int up_x = max(y1, y2);
		int down_x = min(y1, y2);
		cin >> N;
		for (int i = 0; i < N; i++)
		{
			int x, y;

			cin >> x >> y;

			//inner_check
			if (x > left_x && x < right_x && y > down_x && y < up_x)
				inner_cnt++;
			if ((x < left_x || x > right_x) && (y < down_x || y > up_x)) // 이거 수정
				outer_cnt++;
		}
		int line_cnt = N - inner_cnt - outer_cnt;
		cout << "#" << i + 1 << " " << inner_cnt << " " << line_cnt << " " << outer_cnt << "\n";
	}
}
