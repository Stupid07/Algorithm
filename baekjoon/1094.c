main(){int x,c=0;
for(scanf("%d",&x);x;x=x>>1)c+=x&1;
printf("%d",c);}