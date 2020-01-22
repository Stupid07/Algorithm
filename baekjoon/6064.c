#include <stdio.h>

int GCD(int a,int b)
{
  if(b==0)return a;
  else return GCD(b,a%b);
}

int main(void)
{
  int M,N,x,y,T,max,i;
  for(scanf("%d",&T);T;T--)
  {
    scanf("%d %d %d %d",&M,&N,&x,&y);
    max = M * N / GCD(M,N);
    for(i=x;i<=max;i+=M)
    {  
    	if(i%N==y) break;
    	else if(i%N==0 && N==y) break;
    }
    if(i>max) printf("-1\n");
    else printf("%d\n",i);
  }
  return 0;
}