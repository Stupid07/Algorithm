#include <cstdio>
int main(){
	int n,k,s=1,i;
	scanf("%d%d",&n,&k);
	for(i=n;i>k;i--)
	s=s*i;
	for(i=2;i<=n-k;i++)
	s/=i;
	printf("%d",s);
	return 0;
}