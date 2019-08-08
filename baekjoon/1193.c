#include <stdio.h>
int main(void){
	int x=0,i=0;
	scanf("%d",&x);
	for(i=1;(x-=i)>0;i++);
	x+=i;
	if(i%2==0)
		printf("%d/%d",x,i+1-x);
    else
		printf("%d/%d",i+1-x,x);
	return 0;
}