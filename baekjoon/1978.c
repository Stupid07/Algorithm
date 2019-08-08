#include <stdio.h>

int main(void) {
	int i,j,N,answer=0,k,prime[1001]={1,1,};
	for(i=2;i<32;i++)
	{
		for(j=i+i;j<1001;j+=i)
		prime[j]=1;
			
	}
	for(scanf("%d",&N);N;N--)
	{
		scanf("%d",&k);
		if(prime[k]==0) answer++;
	}
	printf("%d",answer);
	return 0;
}