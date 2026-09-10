/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int averageOfSubtree(TreeNode* root) {
        pair<int,pair<int,int>> p = solve(root);
        return p.first;
    }

    pair<int,pair<int,int>> solve(TreeNode* root){
        if(root == NULL){
            return {0,{0,0}};
        }
        if(root-> left == NULL && root-> right == NULL) return {1,{root-> val,1}};

        pair<int,pair<int,int>> l = solve(root-> left);
        pair<int,pair<int,int>> r = solve(root-> right);

        pair<int,pair<int,int>> ans;
        ans.first = l.first + r.first;
        int avg = (l.second.first + r.second.first + root-> val) / (l.second.second + r.second.second + 1);
        if(avg == root-> val) ans.first++;
        ans.second.first = (l.second.first + r.second.first + root-> val);
        ans.second.second = (l.second.second + r.second.second + 1);

        return ans;

    }
};