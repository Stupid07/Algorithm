#include <stdio.h>

int main(void) {
	int b[2],r=3,k,t;
	while(r){
		b[0]=b[1]=0;
		k=4;
		while(k){
			scanf("%d",&t);
			b[t]++;
			k--;
		}
		if(b[1]==4){
			puts("E");
		}else{
			printf("%c\n",64+b[0]);
		}
		r--;
	}
	return 0;
}