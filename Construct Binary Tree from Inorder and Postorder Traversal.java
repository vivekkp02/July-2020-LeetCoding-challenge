/*
Given inorder and postorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
For example, given
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStart = 0;
	    int inEnd = inorder.length - 1;
	    int postStart = 0;
	    int postEnd = postorder.length - 1;
        return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd)
		    return null;
        int rootValue = postorder[postEnd];
		TreeNode root = new TreeNode(rootValue);
        int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == rootValue) {
			    k = i;
			    break;
		    }
	    } 
	    root.left = buildTree(inorder, inStart, k - 1, postorder, postStart, postStart + k - (inStart + 1));
	    // Becuase k is not the length, it it need to -(inStart+1) to get the length
	    root.right = buildTree(inorder, k + 1, inEnd, postorder, postStart + k- inStart, postEnd - 1);
	    // postStart+k-inStart = postStart+k-(inStart+1) +1
        return root;
    }
}
