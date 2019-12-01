#include <stdio.h>
int main(void) {
	int n,x,i,k;
	scanf("%d %d",&n,&x);
	for(i = 0; i < n; i ++)
	{
		scanf("%d",&k);
		if(k<x)
		printf("%d ",k);
	}
	return 0;
}