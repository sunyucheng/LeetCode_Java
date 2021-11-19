package lc20211119;

public class SearchBST {
	static TreeNode res = new TreeNode();
	public static void main(String[] args){
		//����BST��
		TreeNode root = new TreeNode(4);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(3);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node2.right = node4;
		//������Ҫ���ҵ������ĸ��ڵ�ֵ
		System.out.println(searchBST2(root, 2).val);
	}
	
	//���õ������������ģʽ
	public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);
        return left != null ? left :right;
    }
	
	//���õ���BST�������ʣ������ڶ��ַ���˼��
    public static TreeNode searchBST2(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            res = root;
        }
        if(root.val > val){
            res = searchBST(root.left, val);
        }
        if(root.val < val){
             res = searchBST(root.right, val);
        }
        return res;
    }
}

