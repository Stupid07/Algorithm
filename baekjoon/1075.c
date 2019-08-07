#include <stdio.h>
int main(void)
{
	int n,f,a,b;
	scanf("%d %d",&n,&f);
	a=n%f;
	b=n%100;
	b-=a;
	while(b>=0)b-=f;
	b+=f;
    b%=100;
    printf("%02d",b);
	return 0;
}