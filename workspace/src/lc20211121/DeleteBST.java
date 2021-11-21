package lc20211121;

public class DeleteBST {
	public static void main(String[] args){
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(6);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(7);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.right = node5;
		TreeNode res = deleteNode(root, 3);
		InsertBST.print(res);
	}
	
	//BST树的删除，先找到要删除的位置再删除,其实这个整个儿还是套用的是bst查找的框架
    public static TreeNode deleteNode(TreeNode root, int key) {
        //错误原因在于少写了递归推出的条件
        if(root == null){
            return null;
        }
        //就是先要写查找的框架
        if(root.val == key){
            //删除bst树的结点的话要分三种情况，删除的是有两个叶子结点的根节点，删除的是最末尾结点，删除的是有一个叶子结点的根结点
            //1.删除的是最末尾的叶子结点
            //情况1也可以和情况2合并，但是也不建议合并，因为这样比较清晰
            if(root.left == null && root.right == null){
                return null;
            }
            //2.删除的是有一个叶子的根结点
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            //3.删除的是有两个叶子结点的根结点的情况
            //假设删除的是两个叶子结点的根结点，那么必须要找到左子树中的最大结点，或者右子树中的最小结点来接替这个root根节点。
            //所以删除的步骤是，先找到要删除的这个结点，然后讲改结点和root结点进行交换，最后再将这个叶子结点删除
            if(root.left != null && root.right != null){
                //以找到这个root的右节点中的最小值为例
                TreeNode temp = root.right;
                //TreeNode midres = new TreeNode();
                while(true){
                    if(temp.left == null){
                        //midres = temp;
                        break;
                    }
                    temp = temp.left;
                }
                //这里代码可以优化，因为root是要删除的，所以没必要交换，直接覆盖就可以了
                root.val = temp.val;
                // int a = root.val;
                // root.val = temp.val;
                // temp.val = a;
                //就是以root.right为根结点，转换为第二种情况，递归删除temp
                root.right = deleteNode(root.right, temp.val);
            }            
        }else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else{
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}

