#include <cstdio>
int main(){
	int i,s,t,n,z,c[1000]={0};
	double p;
	for(scanf("%d",&t);t;t--)
	{
		scanf("%d",&n);
		for(i=0,s=0;i<n;i++)
		{scanf("%d",c+i);
		s+=c[i];}
		for(s/=n,i=0,z=0;i<n;i++)
		if(c[i]>s)z++;
		p=(double)z/n * 100;
		printf("%.3lf%%\n",p);
	}
	return 0;
}