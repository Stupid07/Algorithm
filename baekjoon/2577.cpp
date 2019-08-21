#include <cstdio>
int main(){
	int s=1,z=3,a,n[10]={0};
	char t[11]={0};
	for(;z;z--,s*=a)scanf("%d",&a);
	z=sprintf(t,"%d",s);
	for(z--;z>=0;z--)
	n[t[z]-48]++;
	for(z=0;z<10;z++)
	printf("%d\n",n[z]);
	return 0;
}