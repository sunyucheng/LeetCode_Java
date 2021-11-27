package lc20211127;

public class ManBinaryTree_CountOfNodes {
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		System.out.println(countNodes(root));
	}
	
	//ע���������ѵ���������ȫ��������������ͨ�Ķ�����
    public static int countNodes(TreeNode root) {
        //����ͳ�����������ĸ߶ȣ��ж��Ƿ���һ����������
        //Ȼ������һ������
        if(root == null){
            return 0;
        }
        TreeNode temp1 = root;
        TreeNode temp2 = root;
        int left = 0;
        int right = 0;
        while(temp1 != null){
            temp1 = temp1.left;
            left++;
        }
        while(temp2 != null){
            temp2 = temp2.right;
            right++;
        }
        if(left == right){
            //��ΪMath�������صĶ���double���͵ģ�����Ҫת��Ϊint���͵�
            return (int)Math.pow(2, left) - 1;
        }else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
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
