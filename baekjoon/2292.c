#include <stdio.h>
int main(void) {
	int i,n,sum=1;
	scanf("%d",&n);
	for(i=1;sum<n;i++)
		sum+=(6*i);
	printf("%d",i);
	return 0;
}
