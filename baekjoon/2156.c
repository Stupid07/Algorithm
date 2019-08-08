#include <stdio.h>

int max(int a,int b){
	if(a>b){
		return a;
	}else 
		return b;
}

int main(void) {
	int i,n,c0[2]={0},c1[2]={0},c2[2]={0},d;
	scanf("%d",&n);
	for(i=0;i<n;i++){
		scanf("%d",&d);
		c0[i&1]=max(max(c0[(i-1)&1],c1[(i-1)&1]),c2[(i-1)&1]);
		c1[i&1]=c0[(i-1)&1]+d;
		c2[i&1]=c1[(i-1)&1]+d;
	}
	printf("%d",max(max(c0[(n-1)&1],c1[(n-1)&1]),c2[(n-1)&1]));
	return 0;
}