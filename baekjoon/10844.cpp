#include <iostream>
#include <cstdio>
#define DIV 1000000000
using namespace std;

int main(void)
{
	int N,i,j;
	long long result = 0,dp[2][10] = {{0,1,1,1,1,1,1,1,1,1},{}};
	scanf("%d", &N);
	for (i = 1; i < N; i++)
	{
		for(j= 0;j<10;j++)
		{
		
		
				if(j==0) dp[i&1][0] = dp[(i-1)&1][1]; 
				else if(j==9) dp[i&1][9] = dp[(i-1)&1][8]; 
				else dp[i&1][j] = (dp[(i-1)&1][j-1] + dp[(i-1)&1][j+1])%DIV;
			
		}
	}
	
	for(i = 0;i<10;i++)
	result = (result + dp[(N-1)&1][i])%DIV;
	printf("%lld", result);
	return 0;
}