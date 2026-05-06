class Solution {
public:
    vector<vector<char>> rotateTheBox(vector<vector<char>>& boxGrid) {

        int row = boxGrid.size();
        int col = boxGrid[0].size();

        vector<vector<char>> ans(col,vector<char>(row,'.'));

        for(int i = 0 ; i < row ; i++){
            int cnt = 0;
            for(int j = 0 ; j < col ; j++){
                if(boxGrid[i][j] == '#')cnt++;
                else if(boxGrid[i][j] == '*'){
                   
                    int stoneTofill = cnt;
                    cnt = 0;
                    int nr = j - 1 , nc = row - 1 - i;
                    ans[j][row-1-i] = '*';
                    while(stoneTofill--){
                           ans[nr][nc] = '#';
                           nr--;
                    }
                }

            }
            if(cnt > 0){
                    int stoneTofill = cnt;
                    cnt = 0;
                    int nr = col - 1 , nc = row - 1 - i;
                    
                    while(stoneTofill--){
                           ans[nr][nc] = '#';
                           nr--;
                    }
            }

        }

        return ans;
    }
};