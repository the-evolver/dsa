class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {

        unordered_map<string,vector<string>> mp;
        vector<vector<string>> v;
        for(string s : strs){
             string sorteds = s;
             sort(sorteds.begin(),sorteds.end());

             mp[sorteds].push_back(s);
        }

        for(auto it : mp){
              vector<string> c;
             for(auto str : it.second){
                  c.push_back(str);
             }
             v.push_back(c);
        }

        return v;
        
    }
};