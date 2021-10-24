package lc20211024;

import java.util.HashMap;

public class CopyList {
	public Node copyRandomList(Node head) {
        HashMap<Node,Node> hashmap = new HashMap<Node,Node>();
        Node temp = head;
        //构造hashmap中原链表与现链表的的映射关系
        while(true){
            if(temp == null){
                break;
            }
            Node node = new Node(temp.val);
            hashmap.put(temp,node);
            temp = temp.next;
        }
        temp = head;
        //得出现链表的结构
        while(true){
            if(temp == null){
                break;
            }
            Node node = hashmap.get(temp);
            node.next = hashmap.get(temp.next);
            node.random = hashmap.get(temp.random);
            temp = temp.next;
        }
        return hashmap.getOrDefault(head,null);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}