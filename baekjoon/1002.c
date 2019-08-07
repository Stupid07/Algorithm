#include <stdio.h>
int main(void) {
	int t=0 ,  number = 0;
	int x1 = 0 , y1 = 0 , r1 = 0 ;
	int x2 = 0 , y2 = 0 , r2 = 0 ;
	int line = 0 , dif = 0, length  = 0 ;
	int i;
	scanf("%d",&t);
	for(i = 0; i < t; i++)
	{
		scanf("%d %d %d %d %d %d",&x1,&y1,&r1,&x2,&y2,&r2);
		line = ((x1 - x2)*(x1 - x2)) + ((y1 - y2)*(y1- y2));
		dif = r2 - r1;
		length = r1 + r2;
		length *= length;
		dif *= dif;
		if(line == 0)
		{
			if(dif == 0 )
			number = -1;
			else
			number = 0;
		}
		else if(length >line)
		{
			if(dif < line)
			 number = 2;
			 else if(dif == line)
			 number = 1;
			 else
			 number = 0;
		}
		else if(length == line)
		{
			number = 1;
		}
		else
		{
			 number = 0;
		}
		
		if(i < t-1)
		printf("%d\n",number);
		else
		printf("%d",number);
	}
	return 0;
}