#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define endl "\n"

// int dfs(vector<vector<int>>& heights,int i,int j, int row,int col,vector<vector<bool>>& vis){
//     if(i == -1 || j == -1 || i == row || j == col || vis[i][j] == true){
//          return INT_MAX;
//     }
//     vis[i][j] = true;
//     int w1 = dfs(heights,i+1,j,row,col,vis);
//     int w2 = dfs(heights,i-1,j,row,col,vis);
//     int w3 = dfs(heights,i,j+1,row,col,vis);
//     int w4 = dfs(heights,i,j-1,row,col,vis);

//     vis[i][j] = false;
//     return min(w1,min(w2,min(w3,w4)));


// }
// int minimumEffortPath(vector<vector<int>>& heights) {
//         int n = heights.size();
//         int m = heights[0].size();

//         vector<vector<int>> dist(n, vector<int>(m, INT_MAX));

//         priority_queue<
//             pair<int, pair<int,int>>,
//             vector<pair<int,pair<int,int>>>,
//             greater<pair<int,pair<int,int>>>
//         > pq;

//         pq.push({0, {0, 0}});   // effort, cell
//         dist[0][0] = 0;

//         int dirs[5] = {1,0,-1,0,1};

//         while (!pq.empty()) {
//             auto top = pq.top(); pq.pop();

//             int effort = top.first;
//             int x = top.second.first;
//             int y = top.second.second;

//             if (x == n-1 && y == m-1) 
//                 return effort;   // Dijkstra guarantee

//             if (effort > dist[x][y]) continue;

//             for (int k = 0; k < 4; k++) {
//                 int nx = x + dirs[k];
//                 int ny = y + dirs[k+1];

//                 if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

//                 int w = abs(heights[nx][ny] - heights[x][y]);
//                 int newEffort = max(effort, w);

//                 if (newEffort < dist[nx][ny]) {
//                     dist[nx][ny] = newEffort;
//                     pq.push({newEffort, {nx, ny}});
//                 }
//             }
//         }

//         return dist[n-1][m-1];
// }

int makeConnected(int n, vector<vector<int>>& connections) {
        
}

void dfs(int curr , vector<bool>& vis,vector<vector<int>>& adj){
    if(vis[curr]) return;

    vis[curr] = true;
    for(auto x : adj[curr]){
          dfs(x,vis,adj);
    }


}

void solve() {

    int n,m;
    cin>>n>>m;
    vector<vector<int>> adj(n+1);
    for(int i = 1 ; i <= m ; i++){
        int a,b;
        cin>>a>>b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    vector<bool> vis(n+1,false);
    vector<int> parent;
    int comp = 0;
    for(int i = 1 ; i <= n ; i++){
        if(vis[i] == false){
            comp++;
            parent.push_back(i);
            dfs(i,vis,adj);
        }
    }
     cout<<comp-1<<endl;
     for(int j = 1 ; j < parent.size();j++){
        cout<<parent[j-1]<<" "<<parent[j]<<endl; 
     }
   
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    int t = 1;
    while (t--) {
        solve();
    }

    return 0;
}


