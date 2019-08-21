#include <cstdio>
int main(){
	int n,a,i,c=0;
	scanf("%d",&n);
	if(n%5==0)
	printf("%d",n/5);
	else
	{
		for(i=n;i>2;i-=3,c++)
		{	
			if(i%5==0) break;
			else if(i == 3){c++;break;}
		}
		printf("%d",i<3?-1:(i/5+c));
	}
	return 0;
}