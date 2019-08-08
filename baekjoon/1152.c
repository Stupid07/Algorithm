#include <stdio.h>
main(){
int t=0,m=0;
char n;
while(scanf("%c",&n)!=EOF){
if((64<n&&n<91)||(96<n&&n<123))m++;
else if(m){m=0;t++;}}
printf("%d",m>0?t+1:t);
}
