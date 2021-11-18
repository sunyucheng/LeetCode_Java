package lc20211117;

public class SumOfList {
	public static void main(String[] args){
		//����һ������rootΪ���ڵ㣬�������������Ϊ123456
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		root.left = node1;
		root.right = node4;
		node1.left = node2;
		node1.right = node3;
		node4.right = node5;
		flatten(root);
		//������ʱ������������ı���
		TreeNode temp = root;
		while(true){
			if(temp == null){
				break;
			}
			System.out.println(temp.val);
			temp = temp.right;
		}
	}
	
	public static void flatten(TreeNode root){
		//�ݹ��˳�������
		if(root == null){
			return;
		}
		//���õ������ĺ�����������Ե׶��ϵĲ���
		flatten(root.left);
		flatten(root.right);
		//��ǰroot�ڵ���Ҫ���������ǽ����������ŵ�������������λ�ã�Ȼ��ԭ����������ƴ�ӵ�������������
		//���ȼ�¼�Ѿ����Ϊ�����������������������Ϊ�Ǻ�����������Ե�ǰ�����������Ѿ��������ˣ�
		TreeNode left = root.left;
		TreeNode right = root.right;
		//Ȼ���������ŵ�root�ڵ����������λ��
		root.right = left;
		root.left = null;
		//���ԭ�������������ӵ����ڵ������������
		//�ȶ���һ���������ĸ���ָ��
		TreeNode temp = root;
		while(true){
			if(temp.right == null){
				break;
			}
			temp = temp.right;
		}
		temp.right = right;
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
