#include <cstdio>
int nn(int l,int h,int m, int n, int a[][1000])
{
	int b=0;
	if(l>=0&&l<m&&h>=0&&h<n)
	{
		if(a[l][h]==1)
		return 0;
		else if(l==m-1)
		return 1;
		else
		{
			a[l][h]=1;
			if(h>0&&a[l][h-1]==0)
			{
				b+=nn(l,h-1,m,n,a);
			}
			if((h<(n-1))&&a[l][h+1]==0)
			{
			 b+=nn(l,h+1,m,n,a);
			}
			if((l<(m-1))&&a[l+1][h]==0)
			{
			 b+=nn(l+1,h,m,n,a);
			}
			if(l>0&&a[l-1][h]==0)
			{
			 b+=nn(l-1,h,m,n,a);
			}
			a[l][h]=0;
			return b;
		}
	}
}
int main(){
	int z,i,j,m,n,a[1000][1000]={0};
	char t[1001];
	scanf("%d%d\n",&m,&n);
	for(i=0;i<m;i++)
	{
	fgets(t,1001,stdin);
	for(j=0;j<n;j++)
	a[i][j]=t[j]-'0';
	}
	for(z=0,i=0;i<n;i++)
	if(a[0][i]==0)z+=nn(0,i,m,n,a);
	printf("%s",z?"YES":"NO");
	return 0;
}
