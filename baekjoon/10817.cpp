#include <iostream>

using namespace std;
int main(void)
{
int num[3];
cin>>*(num)>>*(num+1)>>*(num+2);

for(int i = 0; i <2; i++)
for(int j= 0; j <2-i; j++)
{
	if(*(num+j) > *(num+j+1))
	{
		int temp = *(num+j);
		*(num+j) = *(num+j+1);
		*(num+j+1) = temp;
	}
}
cout<<*(num+1);
return 0;
}