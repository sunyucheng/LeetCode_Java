package lc20211118;

import java.util.*;

public class FindRepeatTree {
	//定义类的成员属性：res：存放结果的集合，hashmap用于统计序列化后的子树出现的次数
	static List<TreeNode> res = new ArrayList<>();
    static HashMap<String, Integer> hashmap = new HashMap<>(); 
	//测试方法
	public static void main(String[] args){
		//构造一棵树，root为根节点，其中重复的子树是[4]和[2,4]
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
		//打印结果集中的结点值
		for(TreeNode x : res){
			System.out.println(x.val);
		}
	}
	
	//采用的是后序遍历的框架
	public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if(root == null){
            return null;
        }
        findDuplicateSubtrees(root.left);
        findDuplicateSubtrees(root.right);
        String s = treeserial(root);
        //使用hashmap统计每个节点的序列化后子树出现的次数
        hashmap.put(s, hashmap.getOrDefault(s, 0) + 1);
        //将重复的节点添加到结果集中
        if(hashmap.get(s) == 2){
            res.add(root);
        }
        return res;
    }
	
	//将子树进行序列化为字符串的函数，采用的是后序遍历的框架（这里采用先序遍历也是可以的）
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
