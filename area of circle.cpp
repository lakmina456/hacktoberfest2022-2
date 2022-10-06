#include <iostream>
using namespace std;
float circarea(int);
int main()
{
	int a;
	cout<<("Enter radius :");
	cin>>a;
	
	cout<<"Area of a circle "<<circarea(a);
	


return 0;
}
float circarea(int a)
{
	float f;
	f=(float)a*22/7;
	return f;
}
