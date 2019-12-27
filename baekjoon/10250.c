#include <stdio.h>
#include <math.h>
int main(void) {
	int T,H,W,N;
	for(scanf("%d",&T);T;T--)
	{
		scanf("%d %d %d",&H,&W,&N);
		printf("%d%02.0lf\n",N%H==0?H:N%H,ceil((double)N/H));
	}
	return 0;
}