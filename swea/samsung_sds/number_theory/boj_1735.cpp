#include <iostream>
using namespace std;

int rec_gcd(int ja, int mo)
{
	if(mo == 0)
		return ja;
	return (rec_gcd(mo, ja % mo));
}

int main(void)
{
	int gcd;
	int a,b,c,d;

	cin >>a >> b;
	cin >> c >> d;

	int mo = b * d;
	int ja_1 = a * d;
	int ja_2 = c * b;


	int ja = (ja_1 + ja_2);
	if(ja < mo)
		gcd = rec_gcd(ja,mo);
	else
		gcd = rec_gcd(mo,ja);
	cout << ja/gcd << ' ' << mo/gcd << '\n';
}
