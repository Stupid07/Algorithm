#include <cstdio>
int g(int x,int y)
{if(y==0) return x;
else return g(y,x%y);}
int main(){
	int a,b,w;
	scanf("%d %d",&a,&b);
	if(a>b)w=g(a,b);
	else w=g(b,a);
	printf("%d\n%d",w,(a*b)/w);
	return 0;
}