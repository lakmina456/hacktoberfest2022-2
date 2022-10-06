
#include <bits/stdc++.h> 
using namespace std;
int main()
{   
  int n;
  cout<<"Enter size of matrix (NxN): ";
  cin>>n;
  int arr[n][n];
  cout<<"\nEnter matrix elements:\n";
  for(int i=0;i<n;i++)
  {
      for(int j=0;j<n;j++)
      {
          cin>>arr[i][j];
      }
  }
  for (int i=0;i<n/2;i++) 
  { 
    for (int j=i;j<n-i-1;j++) 
    { 
            int temp=arr[i][j]; 
            arr[i][j]=arr[n-1-j][i]; 
            arr[n-1-j][i]=arr[n-1-i][n-1-j]; 
            arr[n-1-i][n-1-j]=arr[j][n-1-i]; 
            arr[j][n-1-i]=temp; 
    } 
  }
    

  cout<<"\nMatrix after rotating 90 degree clockwise:\n";
  for(int i=0;i<n;i++)
  {
      for(int j=0;j<n;j++)
      {
          cout<<arr[i][j]<<" ";
      }
      cout<<"\n";
  }
  return 0;
}
