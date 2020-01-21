#include <stdio.h>

int rec(int x)
{
	if(x==0) return 1;
	else if(x>0) return (rec(x-1)+rec(x-2)+rec(x-3));
	else return 0;
}

int main(void) {
	int T,n;
	scanf("%d",&T);
	while(T)
	{
		scanf("%d",&n);
		printf("%d\n",rec(n));
		T--;
	}
	return 0;
}