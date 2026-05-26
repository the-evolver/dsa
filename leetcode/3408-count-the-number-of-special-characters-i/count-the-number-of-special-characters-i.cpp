class Solution {
public:
    int numberOfSpecialChars(string word) {

        vector<int> sm(26,0);
        vector<int> lg(26,0);

        for(char x : word){
             if(x >= 'a'){
                sm[x-'a']++;
             }else
               lg[x-'A']++;
        }
        int cnt = 0;
        for(int i = 0 ; i < 26 ;i++){
             if(sm[i] > 0 && lg[i] > 0) cnt++;
        }
        return cnt;
    }
};