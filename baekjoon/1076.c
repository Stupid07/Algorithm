#include <stdio.h>
#include <string.h>
main() {
int i=0,t,k=0,p=0;
char n[7];
char * m[10]={"black","brown","red","orange","yellow","green","blue","violet","grey","white"};
for(;i<3;i++)
{
memset(n,'\0',7);
for(scanf("%s",n),t=0;strcmp(n,m[t])!=0;t++);
if(i==0)k=t*10;
else if(i==1)printf("%d",k+=t);
else if(k!=0)for(;p<t;p++)printf("0");
}
puts("");
}