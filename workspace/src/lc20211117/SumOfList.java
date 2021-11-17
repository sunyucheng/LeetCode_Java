package lc20211117;

public class SumOfList {
	public static void main(String[] args){
		
	}
	
	public void flatten(TreeNode root){
		if(root == null){
			return;
		}
		flatten(root.left);
		flatten(root.right);
		TreeNode node1 = root.right;
		TreeNode node2 = root.left;
		root.right = node2;
		root.left = null;
		TreeNode temp = root;
		while(temp.right != null){
			temp = temp.right;
		}
		temp.right = node1;
	}
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
