#include <stdio.h>
int main(void) {
	long long i,N,f[2]={1,1};
	scanf("%ld",&N);
	for(i=2;i<N;i++) f[i&1]+=f[(i-1)&1];
	printf("%ld",f[(N-1)&1]);
	return 0;
}