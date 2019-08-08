#include <stdio.h>

int min = 1000000;

void rec(int x,int y)
{
	if(min> y)
	{
		if(x==1)
		 min = y;
		else
		{
			if((x%3)==0) rec(x/3,y+1);
			if((x&1)==0) rec(x>>1,y+1);
			rec(x-1,y+1);
		}	
	}
}

int main(void) {
	int x;
	scanf("%d",&x);
	rec(x,0);
	printf("%d",min);
	return 0;
}