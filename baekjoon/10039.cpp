#include <cstdio>
int main(){
	int s=0,n,t=5;
	for(;t;t--)
	{scanf("%d",&n);
	if(n<40)s+=40;
	else s+=n;}
	printf("%d",s/5);
	return 0;
}