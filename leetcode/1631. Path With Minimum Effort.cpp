#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define endl "\n"

int minimumEffortPath(vector<vector<int>>& heights) {
        int n = heights.size();
        int m = heights[0].size();

        vector<vector<int>> dist(n, vector<int>(m, INT_MAX));

        priority_queue<
            pair<int, pair<int,int>>,
            vector<pair<int,pair<int,int>>>,
            greater<pair<int,pair<int,int>>>
        > pq;

        pq.push({0, {0, 0}});   // effort, cell
        dist[0][0] = 0;

        int dirs[5] = {1,0,-1,0,1};

        while (!pq.empty()) {
            auto top = pq.top(); pq.pop();

            int effort = top.first;
            int x = top.second.first;
            int y = top.second.second;

            if (x == n-1 && y == m-1) 
                return effort;   // Dijkstra guarantee

            if (effort > dist[x][y]) continue;

            for (int k = 0; k < 4; k++) {
                int nx = x + dirs[k];
                int ny = y + dirs[k+1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                int w = abs(heights[nx][ny] - heights[x][y]);
                int newEffort = max(effort, w);

                if (newEffort < dist[nx][ny]) {
                    dist[nx][ny] = newEffort;
                    pq.push({newEffort, {nx, ny}});
                }
            }
        }

        return dist[n-1][m-1];
}


void solve() {
    vector<vector<int>>heights;
    int r,c;
    cin>>r>>c;
    for(int i= 0;i < r;i++){
        for(int j= 0;j < c;j++){
            cin>>heights[i][j];
        }
    }
    minimumEffortPath(heights);
   
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