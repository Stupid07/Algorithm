#include <stdio.h>
int main(void)
{
	int n,a,b,c,t=0;
	scanf("%d",&n);t=n;
	for(c=0;n!=t||!c;c++)
	{a=t/10;b=t%10;a+=b;a%=10;t=b*10+a;}
	printf("%d",c);
	return 0;
}