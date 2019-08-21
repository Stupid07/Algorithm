#include <stdio.h>
int main(void) {
	int s=0,i=5,n=0;
	for(;i;i--)
	{
	scanf("%d",&n);
	s+=(n*n);
	}
	printf("%d",s%10);
	return 0;
}