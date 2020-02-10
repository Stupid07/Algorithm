main(){
	int a[3],i,t,j=2;
	char n[4]={0};
	scanf("%d%d%d",a,a+1,a+2);
	for(;j>0;j--)
	for(i=0;i<j;i++)
	if(a[i]>a[i+1]){t=a[i]; a[i]=a[i+1]; a[i+1]=t;}
	scanf("%s",n);
	for(;j<3;j++)
	printf("%d ",a[n[j]-65]);
}