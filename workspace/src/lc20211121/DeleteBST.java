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
	
	//BST����ɾ�������ҵ�Ҫɾ����λ����ɾ��,��ʵ����������������õ���bst���ҵĿ��
    public static TreeNode deleteNode(TreeNode root, int key) {
        //����ԭ��������д�˵ݹ��Ƴ�������
        if(root == null){
            return null;
        }
        //������Ҫд���ҵĿ��
        if(root.val == key){
            //ɾ��bst���Ľ��Ļ�Ҫ�����������ɾ������������Ҷ�ӽ��ĸ��ڵ㣬ɾ��������ĩβ��㣬ɾ��������һ��Ҷ�ӽ��ĸ����
            //1.ɾ��������ĩβ��Ҷ�ӽ��
            //���1Ҳ���Ժ����2�ϲ�������Ҳ������ϲ�����Ϊ�����Ƚ�����
            if(root.left == null && root.right == null){
                return null;
            }
            //2.ɾ��������һ��Ҷ�ӵĸ����
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            //3.ɾ������������Ҷ�ӽ��ĸ��������
            //����ɾ����������Ҷ�ӽ��ĸ���㣬��ô����Ҫ�ҵ��������е�����㣬�����������е���С������������root���ڵ㡣
            //����ɾ���Ĳ����ǣ����ҵ�Ҫɾ���������㣬Ȼ�󽲸Ľ���root�����н���������ٽ����Ҷ�ӽ��ɾ��
            if(root.left != null && root.right != null){
                //���ҵ����root���ҽڵ��е���СֵΪ��
                TreeNode temp = root.right;
                //TreeNode midres = new TreeNode();
                while(true){
                    if(temp.left == null){
                        //midres = temp;
                        break;
                    }
                    temp = temp.left;
                }
                //�����������Ż�����Ϊroot��Ҫɾ���ģ�����û��Ҫ������ֱ�Ӹ��ǾͿ�����
                root.val = temp.val;
                // int a = root.val;
                // root.val = temp.val;
                // temp.val = a;
                //������root.rightΪ����㣬ת��Ϊ�ڶ���������ݹ�ɾ��temp
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

