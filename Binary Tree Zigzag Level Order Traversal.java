/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();        
        if(root == null)
            return result;        
        Stack<TreeNode> currentRowStack = new Stack<>();
        Stack<TreeNode> nextRowStack = new Stack<>();        
        boolean left = false;        
        currentRowStack.push(root);        
        List<Integer> currentList = new ArrayList<>();
        while(!currentRowStack.isEmpty()){
            TreeNode node = currentRowStack.pop();
            currentList.add(node.val);
            if(left){
                if(node.right!=null) nextRowStack.push(node.right);
                if(node.left!=null) nextRowStack.push(node.left);
            }else{
                if(node.left!=null) nextRowStack.push(node.left);
                if(node.right!=null) nextRowStack.push(node.right);
            }            
            if(currentRowStack.isEmpty()){
                result.add(currentList);
                Stack<TreeNode> temp = currentRowStack;
                currentRowStack = nextRowStack;
                nextRowStack = temp;
                currentList = new ArrayList<>();
                left = !left;
            }
        }
        return result;
    }
}
