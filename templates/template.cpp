#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define endl "\n"

void dfs(vector<vector<char>>& arr,vector<vector<bool>>& vis , int i,int j , int n , int m){
	 if( i == n || i == -1 || j == m || j == -1 || arr[i][j] != '.' || vis[i][j] == true){
	       return;
	 }
	 
	 vis[i][j] = true;
	 dfs(arr,vis,i+1,j,n,m);
	 dfs(arr,vis,i-1,j,n,m);
	 dfs(arr,vis,i,j+1,n,m);
	 dfs(arr,vis,i,j-1,n,m);
}

void calc(int n,int m,vector<vector<char>>& arr){
   
   int rooms = 0; // basically different regions i need to get
   vector<vector<bool>> vis(n,vector<bool>(m,false));

   for(int i = 0 ; i < n ; i++){
        for(int j = 0 ; j < m ; j++){
              if(arr[i][j] == '.' && vis[i][j] == false){
                  rooms++;
                  dfs(arr,vis,i,j,n,m); // any traversal algorithm to call 
              }
        }
   }
	
    cout<<rooms<<endl;

}

void solve() {
    
   int n,m;
	cin>>n>>m;

	vector<vector<char>> arr(n,vector<char>(m));
	for(int i = 0 ; i < n ;i++){
	     for(int j = 0 ; j < m ; j++){
	           cin>>arr[i][j];
	     }
	}

	calc(n,m,arr);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    int t = 1;
    // cin >> t;

    while (t--) {
        solve();
    }

    return 0;
}
