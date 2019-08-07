main(){
int x,y,w,h;
scanf("%d%d%d%d",&x,&y,&w,&h);
x=w-x>x?x:w-x;
y=h-y>y?y:h-y;
printf("%d",x>y?y:x);
}