#include <stdio.h>
#include <math.h>
int main(void) {
	int M,N,i,j,m,min=0,sum=0;
	scanf("%d\n",&M);
	scanf("%d",&N);
	for(i=M;i<=N;i++)
	{
		m=(int)sqrt(i);
		for(j=2;j<=m;j++)
			if(i%j==0)break;
		if(i>1&&j>m)
		{
			if(sum==0) min=i;
			sum+=i;
		}
	}
	if(sum==0)
	printf("%d",-1);
	else
	printf("%d\n%d",sum,min);
	return 0;
}