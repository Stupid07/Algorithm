#include <cstdio>
int main(){
	int t,i,c,s;
	char n[81];
	for(scanf("%d\n",&t);t;t--)
	{
		for(fgets(n,81,stdin),i=0,c=1,s=0;n[i]!='\0'&&n[i]!='\n';i++)
		if(n[i]=='O'){s+=c;c++;}else c=1;
		printf("%d\n",s);
	}
	return 0;
}