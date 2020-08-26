package mylearning;

class TNode {
	int data;
	TNode left;
	TNode right;
	
	public TNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class TreeProgram {

	public static void main(String[] args) {

		int a[] = { 11, 6, 19, 4, 8, 5, 43, 49, 10, 31, 17, 5 };

		TNode root = null;
		TreeProgram tree = new TreeProgram();

		for (int i = 0; i < a.length; i++) {
			root = tree.insertNode(root, a[i]);
		}
		
		System.out.println("Completed :::: ");
		tree.printTree(root);
	}
	
	
	
	public void printTree(TNode root){
		if(root != null) {
			if(root.left != null) printTree(root.left);
			System.out.println(root.data + ", ");
			if(root.right != null) printTree(root.right);
		}
	}
	
	public TNode insertNode(TNode root, int data) {
		TNode currentNode = new TNode(data);
		if (root == null) {
			root = currentNode;
		} else {
			insertData(currentNode, root);
		}
		return root;
	}

	public TNode insertData(TNode newNode, TNode root) {
		if (root.data < newNode.data) {
			if (root.right == null) {
				root.right = newNode;
			} else {
				return insertData(newNode, root.right);
			}
		} else if (root.data > newNode.data) {
			if (root.left == null) {
				root.left = newNode;
			} else {
				return insertData(newNode, root.left);
			}
		}
		return root;
	}
}
