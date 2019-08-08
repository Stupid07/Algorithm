#include <cstdio>
int main() {
	int n,i=0;
	long double a[1000],m=0.0,s=0.0;
	scanf("%d",&n);
	for(;i<n;i++)
	{scanf("%llf",a+i);
	if(a[i]>m)m=a[i];}
	for(i=0;i<n;i++)
	s+=((a[i]/m)*100);
	s/=n;
	printf("%.2llf",s);
	return 0;
}