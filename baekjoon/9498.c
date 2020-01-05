main(){
int n;
char m=65;
scanf("%d",&n);
printf("%c",n>89?m:n>79?m+=1:n>69?m+=2:n>59?m+=3:(m+=5));
}