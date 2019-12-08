#include <stdio.h>

int main(void) {
	int count,i,j,N,x,y,a[50][3];
	scanf("%d",&N);
	for(i=0;i<N;i++)
	{
		count=1;
		scanf("%d %d",&x,&y);
		for(j=0;j<i;j++)
		{
			if(a[j][0] < x && a[j][1] < y) (a[j][2])++;
			if(a[j][0] > x && a[j][1] > y) count++;
		}
		a[i][0]=x;
		a[i][1]=y;
		a[i][2]=count;
	}
	for(i=0;i<N;i++)
	printf("%d ",a[i][2]);
	return 0;
}