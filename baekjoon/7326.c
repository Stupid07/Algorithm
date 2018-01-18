#define f(y) ((y&1)?(y+y-1):(y+y))
#include <stdio.h>
int main(void) {
	int N,x,y;
	for(scanf("%d",&N);N;N--)
	{
		scanf("%d %d",&x,&y);
		if(y == x||y == x-2){
			printf("%d\n",(y==x-2)?(f(y)+2):f(y));
		}else{
			printf("No Number\n");
		}
	}
	return 0;
}