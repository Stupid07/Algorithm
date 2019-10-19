#include <stdio.h>

int num[10001];

int main(void) {
	int N,number,i,j,k,t=0;
	scanf("%d",&N);
	for(i=0;i<N;i++)
	{
		scanf("%d",&number);
		num[number]++;
	}
	
	for(i=1;t!=N;i++)
	{
		k = num[i];
		for(j=0;j<k;j++)
		{printf("%d\n",i);
		t++;}
	}
	return 0;
}