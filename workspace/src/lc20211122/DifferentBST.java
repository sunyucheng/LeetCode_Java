package lc20211122;

public class DifferentBST {
	public static void main(String[] args){
		//����һ������ n ����ǡ�� n ���ڵ�����ҽڵ�ֵ�� 1 �� n ������ͬ�� ���������� �ж����֣�
		numTrees(5);
	}
	
	//�������㷨�Ĺؼ�����������ȷ�������Ҫ��ʲô
    public static int numTrees(int n) {
        return count(1,n);
    }

    //������l��h�����������count(l,h)��bst
    //��1-n�����������������
    public static int count(int l, int h){
        //�ս��Ҳ��һ�����
        if(l > h){
            return 1;
        }
        int res = 0;
        //����ÿһ�����ڵ�
        for(int i = l; i <= h; i++){
            //���������������
            int left = count(l, i - 1);
            //���������������
            int right = count(i+1, h);
            res += left * right;
        }
        return res;
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
