#include <cstdio>
int main(){
	char string[8]={'\0'};
	int i,j,z,n,count=0,dif[2] = {0},temp;
	scanf("%d",&n);
	for(i=1;i<=n;i++)
	{
		sprintf(string,"%d",i);
		for(j=0,z=1;string[j]!='\0';j++)
		{
			if(j==0)
			temp = string[j]-'0';
			else if(j==1)
			{
				dif[j%2] = temp -string[j]-'0';
				temp = string[j]-'0';
			}
			else
			{
				dif[j%2]= temp- string[j] -'0';
				temp = string[j]-'0';
				if(dif[j%2]!=dif[(j+1)%2])
				{z = 0;break;}
			}
		}
		if(z)
		count++;
	}
	printf("%d",count);
	return 0;
}