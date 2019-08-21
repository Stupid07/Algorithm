#include <stdio.h>
 
int main(void) {
	int a,b,s=0,m=0,r=4;
	while(r){
		scanf("%d %d",&a,&b);
		s+=(b-a);
		if(m<s) m=s;
		r--;
	}
	printf("%d",m);
	return 0;
}