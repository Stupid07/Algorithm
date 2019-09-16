#include <stdio.h>

int main(void) {
	int T,n1,n2;
	for(scanf("%d",&T);T;T--){
		scanf("%d %d",&n1,&n2);
		printf("%d\n",n1+n2);
	}
	return 0;
}