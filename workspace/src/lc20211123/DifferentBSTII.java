package lc20211123;

import java.util.*;

public class DifferentBSTII {
	public static void main(String[] args){
		//����һ������ n ����ǡ�� n ���ڵ�����ҽڵ�ֵ�� 1 �� n ������ͬ�� ����������,������ͬ��ϵĸ�������res
		List<TreeNode> res = new ArrayList<>();
		res = generateTrees(3);
		for(TreeNode tree : res){
			System.out.println(tree.val);
		}
	}
	
	public static List<TreeNode> generateTrees(int n) {    
        //n = 0��������Ǹ���һ������0����ô��û��������������򷵻ص��ǿյ�List
        //List�зŵ��Ǹ����ͺ���
        if(n == 0){
            return new ArrayList<TreeNode>();
        }
        return help(1, n);
    }

    public static List<TreeNode> help(int left, int right){
        //�����res������Ϊȫ�ֱ���
        List<TreeNode> res = new ArrayList<>();
        //left > right��һ�������䣬���ǿ������Ӧ�ſս��null���ս��Ҳ��һ�����
        if(left > right){
            res.add(null);
            return res;
        }
        //�����ڱ�������㣺1.���root�����п���
        for(int i = left; i <= right; i++){
         //2.�ݹ鹹����������������кϷ�BST,��ö�ٳ��˽�������������,��ŵ�������
            List<TreeNode> lefttree = help(left , i - 1);
            List<TreeNode> righttree = help(i + 1, right);
            //3.Ϊroot���������е��������������
            for(TreeNode l : lefttree){
                for(TreeNode r : righttree){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
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


