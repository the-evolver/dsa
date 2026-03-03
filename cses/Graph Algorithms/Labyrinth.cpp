#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define endl "\n"


void push_In_queue(queue<pair<int,int>> & qu,int i,
    int j,vector<vector<char>>& adj,
    vector<vector<bool>>& vis, 
    vector<vector<pair<int,int>>>& parent,
    vector<vector<char>>& dirUsed){

        if(i-1 >= 0 && vis[i-1][j] == false && (adj[i-1][j] == '.' || adj[i-1][j] == 'B')){
            vis[i-1][j] = true;
            parent[i-1][j] = {i, j};
            dirUsed[i-1][j] = 'U';
            qu.push({i-1,j});
            
            
        }
        if(j-1 >=0 && vis[i][j-1] == false && (adj[i][j-1] == '.' || adj[i][j-1] == 'B')){
            vis[i][j-1] = true;
            parent[i][j-1] = {i, j};
            dirUsed[i][j-1] = 'L';
            qu.push({i,j-1});
           
            
        }
        if(i+1 < adj.size() && vis[i+1][j] == false && (adj[i+1][j] == '.' || adj[i+1][j] == 'B')){
            vis[i+1][j] = true;
            parent[i+1][j] = {i, j};
            dirUsed[i+1][j] = 'D';
            qu.push({i+1,j});
           
            
        }
        if(j+1 < adj[0].size() && vis[i][j+1] == false && (adj[i][j+1] == '.' || adj[i][j+1] == 'B' )){
            vis[i][j+1] = true;
            parent[i][j+1] = {i, j};
            dirUsed[i][j+1] = 'R';
           
            qu.push({i,j+1});
            
            
        }


}

void bfs(vector<vector<char>>& adj, pair<int,int> start, pair<int,int> end){

  int r = adj.size(),c = adj[0].size();

  vector<vector<bool>> vis(r,vector<bool>(c,false));
  queue<pair<int,int>> qu;

  qu.push({start.first,start.second});
  vector<vector<pair<int,int>>> parent(r, vector<pair<int,int>>(c, {-1,-1}));
  vector<vector<char>> dirUsed(r, vector<char>(c, ' '));
  
  bool pathFound = false;
  vis[start.first][start.second] = true;
  while(qu.size()){
         auto [i,j] = qu.front();
         qu.pop();
         if(i == end.first && j == end.second){ 

             string path = "";
             int ci = i, cj = j;
             while(ci != start.first || cj != start.second){
                path += dirUsed[ci][cj];
                auto [pi, pj] = parent[ci][cj];
                ci = pi; cj = pj;
            }
            reverse(path.begin(), path.end());
            cout << "YES\n" << path.size() << "\n" << path << "\n";
            pathFound = true;
            break;
            
            //  cout<<"YES"<<endl<<currPath.size()<<endl;
            //  cout<<currPath<<endl;
            //  pathFound = true;
            //  break;
             
         }
        
         push_In_queue(qu,i,j,adj,vis,parent,dirUsed);


  }
  if(pathFound == false){
    cout<<"NO"<<endl;
  }
  return;

}
void solve() {

    int row,col;
    cin>>row>>col;
    vector<vector<char>> adj(row,vector<char>(col));
    pair<int,int> start,end;
    for(int i = 0 ; i < row;i++){
         for(int j = 0 ; j < col;j++){
            cin>>adj[i][j];
            if(adj[i][j] == 'A'){
                start.first = i;
                start.second = j;
            }
            if(adj[i][j] == 'B'){
                end.first = i;
                end.second = j;
            }
         }
    }
   
    bfs(adj,start,end);

   
   
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


/*
    0 - 1
    0-2
    0-3
    1-2
    1-3
*/