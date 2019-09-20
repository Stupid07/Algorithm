#include <stdio.h>
#define ANSWER "Wa-pa-pa-pa-pa-pa-pow!"
#define WRONG "Woof-meow-tweet-squeek"

int main(void) {
	int N,a,b,c=3;
	scanf("%d",&N);
	while(N)
	{
		scanf("%d %d",&a,&b);
		switch(a)
		{
			case 1: if(b==3 || b ==4) {c--; break;}
			case 3: if(b== 1 || b== 4) {c--; break;}
			case 4: if(b== 1 || b== 3) {c--; break;}
			default: c++; N=1; break;
		}
		N--;
	}
	printf("%s",c?WRONG:ANSWER);
	return 0;
}