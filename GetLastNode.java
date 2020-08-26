package mylearning;

public class GetLastNode {

	int count = 0;
	static int data = -1;
	
	class LinkedList {
		int val;
		LinkedList next;
		
		public LinkedList(int val){
			this.val = val;
			this.next = null;
		}
	}
	
	public static void main(String[] args) {
		int[] val = new int[] {11,22,33,44,55,66,77,88,99,100};
		GetLastNode obj = new GetLastNode();
		LinkedList root = obj.createLinkedList(val);
		obj.getLastXNode(8, root);
		System.out.println("VALUE ::: "+data);
	}
	
	
	public void getLastXNode(int x, LinkedList root) {
		if(root == null) return;
		getLastXNode(x, root.next);
		count++;
		if(count == x) data = root.val;
	}
	
	public LinkedList createLinkedList(int[] val) {
		LinkedList root = null;
		LinkedList tmp = null;
		for(int v : val) {
			if(null == root) {
				tmp = root = new LinkedList(v);
			}else {
				tmp.next = new LinkedList(v);
			}
			if(null != tmp.next)
				tmp = tmp.next;
		}
		return root;
	}
	
}
