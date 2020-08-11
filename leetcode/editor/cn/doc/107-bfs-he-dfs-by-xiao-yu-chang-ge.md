### 解题思路
此处撰写解题思路

### 代码

```cpp
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        if(root == NULL)
        return {};
        int depth = GetDepth(root);
        queue<TreeNode*> q;
        q.push(root);
        vector<vector<int>> res (depth, vector<int>());
        TreeNode* tmp = root;
        while(!q.empty()){
            int len = q.size();
            depth--;
            for(int i = 0; i < len; ++i){
                tmp = q.front();
                q.pop();
                res[depth].push_back(tmp->val);
                if(tmp->left != NULL)
                q.push(tmp->left);
                if(tmp->right != NULL)
                q.push(tmp->right);
            }           
        }
        return res;
    }

    int GetDepth(TreeNode* root){
        if(root == NULL)
        return 0;
        int left = GetDepth(root->left);
        int right = GetDepth(root->right);
        return left > right ? left + 1 : right + 1;
    }
};


//DFS
class Solution {
private:
    vector<vector<int>> res;

public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        if(root == NULL)
        return {};
        int depth = GetDepth(root);
        vector<vector<int>> arr (depth, vector<int>());
        res = arr;
        dfs(root, depth - 1);
        return res;
    }

    void dfs(TreeNode* root, int depth){
        if(root == NULL || depth < 0)
        return;
        res[depth].push_back(root->val);
        dfs(root->left, depth - 1);
        dfs(root->right, depth - 1);
    }

    int GetDepth(TreeNode* root){
        if(root == NULL)
        return 0;
        int left = GetDepth(root->left);
        int right = GetDepth(root->right);
        return left > right ? left + 1 : right + 1;
    }
};
```