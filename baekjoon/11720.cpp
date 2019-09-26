#include <cstdio>
int main(){
	int n,s=0;
	char a[101]={0};
	scanf("%d\n",&n);
	fgets(a,n+1,stdin);
	for(n--;n>=0;n--)
	s+=(a[n]-48);
	printf("%d",s);
	return 0;
}