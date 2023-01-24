#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

string planet[10] = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

int main(void)
{
    int t;
    cin >> t;
    
    for(int i = 1; i <= t; i++)
    {
        string tc, s;
        int count[10] = {0, };
        int n;
        cin >> tc >> n;
        
        for(int j = 0; j < n; j++)
        {
            cin >> s;
            if(s == "ZRO")
                count[0]++;
            else if(s == "ONE")
                count[1]++;
            else if(s == "TWO")
                count[2]++;
            else if(s == "THR")
                count[3]++;
            else if(s == "FOR")
                count[4]++;
            else if(s == "FIV")
                count[5]++;
            else if(s == "SIX")
                count[6]++;
            else if(s == "SVN")
                count[7]++;
            else if(s == "EGT")
                count[8]++;
            else if(s == "NIN")
                count[9]++;
        }
        
        cout << tc << endl;
        for(int j = 0; j < 10; j++)
        {
            if(count[j] != 0)
            {
                for(int k = 0; k < count[j]; k++)
                    cout << planet[j] << " ";
            }
        }
        cout << endl;
    }
    return 0;
}