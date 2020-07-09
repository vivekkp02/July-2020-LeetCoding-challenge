/*
Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same 
structure as a full binary tree, but some nodes are null. The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in 
the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:
Input: 
           1
         /   \
        3     2
       / \     \  
      5   3     9 
Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).

Example 2:
Input: 
          1
         /  
        3    
       / \       
      5   3     
Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).

Example 3:
Input: 
          1
         / \
        3   2 
       /        
      5      
Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).

Example 4:
Input: 
          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).

Note: Answer will in the range of 32-bit signed integer.
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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;        
        int result = 1;
        Deque<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        queue.add(root);
        map.put(root, 0);        
        while(!queue.isEmpty()){
            int size = queue.size();
            int start = map.get(queue.peekFirst());
            int end = map.get(queue.peekLast());
            for(int i = 0; i<size; i++){
                TreeNode node = queue.poll();
                int index = map.get(node);
                if(node.left != null){
                    queue.offer(node.left);
                    map.put(node.left, 2*index+1);
                }                
                if(node.right != null){
                    queue.offer(node.right);
                    map.put(node.right, 2*index+2);
                }
                result = Math.max(result, end - start + 1);
            }             
        }
        return result;        
    }
}
