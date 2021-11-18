package lc20211118;

import java.util.*;

public class FindRepeatTree {
	//������ĳ�Ա���ԣ�res����Ž���ļ��ϣ�hashmap����ͳ�����л�����������ֵĴ���
	static List<TreeNode> res = new ArrayList<>();
    static HashMap<String, Integer> hashmap = new HashMap<>(); 
	//���Է���
	public static void main(String[] args){
		//����һ������rootΪ���ڵ㣬�����ظ���������[4]��[2,4]
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(4);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;
		node4.left = node6;
		res = findDuplicateSubtrees(root);
		//��ӡ������еĽ��ֵ
		for(TreeNode x : res){
			System.out.println(x.val);
		}
	}
	
	//���õ��Ǻ�������Ŀ��
	public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null){
            return null;
        }
        findDuplicateSubtrees(root.left);
        findDuplicateSubtrees(root.right);
        String s = treeserial(root);
        //ʹ��hashmapͳ��ÿ���ڵ�����л����������ֵĴ���
        hashmap.put(s, hashmap.getOrDefault(s, 0) + 1);
        //���ظ��Ľڵ���ӵ��������
        if(hashmap.get(s) == 2){
            res.add(root);
        }
        return res;
    }
	
	//�������������л�Ϊ�ַ����ĺ��������õ��Ǻ�������Ŀ�ܣ���������������Ҳ�ǿ��Եģ�
    public static String treeserial(TreeNode root){
        if(root == null){
            return "#";
        }
        String left = treeserial(root.left);
        String right = treeserial(root.right);
        String res = root.val + "," + left + "," +right;
        return res;
    }
}

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode() {
	   
   }
   TreeNode(int val) { 
	   this.val = val; 
   }
   TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
       this.left = left;
       this.right = right;
    }
}
