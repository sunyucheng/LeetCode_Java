package lc20211119;

public class VerifyBST {
	static boolean flag = true;
	public static void main(String[] args){
		TreeNode root = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(3);
		root.left = node1;
		root.right = node2;
		flag = isValidBST(root);
		System.out.println(flag);
	}

	//�����õ��Ƿ����жϷ���
	public static boolean isValidBST(TreeNode root) {
	    //��������ֵ�ж�
	    if(root == null){
	        return false;
	    }
	    flag = help(root, null, null);
	        return flag;
	}

	//���ڵݹ�ĺ���,���õ����������
	//�޶���rootΪ���������ڵ��������max.val > root.val > min.val,��Ϊbst������������Ҳ������
	public static boolean help(TreeNode root, TreeNode min, TreeNode max){
	    //�ݹ��˳�������
	    if(root == null){
	        return true;
	    }
	    //�޶�������������ʱ������ֵ��root.val
	    help(root.left, min, root);
	    if(min != null && root.val <= min.val){
	        flag = false;
	    }
	    if(max != null && root.val >= max.val){
	        flag = false;
	    }
	    //�޶�������������ʱ�����Сֵ��root.val
	    help(root.right, root, max);
	    return flag;
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


