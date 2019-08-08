#include <stdio.h>

int main(void) {
	int m,x,y,b=1;
	for(scanf("%d",&m);m;m--){
		scanf("%d %d",&x,&y);
		if(x==b) b=y;
		else if(y==b) b=x;
	}
	printf("%d",b);
	return 0;
}