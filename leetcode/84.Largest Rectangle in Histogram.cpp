class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {

        int n = heights.size();
        vector<int> nxtS(n,n);
        vector<int> prevS(n,-1);
        int j;
        stack<pair<int,int>> nS,pS;
        for(int i = 0 ; i < n ; i++){
               j = n - 1 - i;

              while(nS.size() > 0 && nS.top().first > heights[i]){
                     auto [val,index] = nS.top();nS.pop();
                     nxtS[index] = i;

              }
              nS.push({heights[i],i});

               while(pS.size() > 0 && pS.top().first > heights[j]){
                     auto [val,index] = pS.top();pS.pop();
                     prevS[index] = j;

              }
              pS.push({heights[j],j});
        }
        long long maxArea = 0,currArea = 0;
        for(int i = 0 ; i < n ; i++){
                int leftContri =  ( prevS[i] == -1 ? i : i - (prevS[i] + 1)) ;
                int currContri =  1 ; //khud
                int rightContri = nxtS[i] - 1 - i;
                currArea = (long long)((leftContri + currContri + rightContri) * heights[i]);
                maxArea = max(maxArea,currArea);
        }
        return maxArea;

    }
};