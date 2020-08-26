package com.prog;

import java.util.Stack;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class CreateBinaryTree {

	Node root = null;
	Stack<Node> stack = new Stack<Node>();

	public static void main(String[] args) {

		CreateBinaryTree obj = new CreateBinaryTree();

		obj.insertData(80);
		obj.insertData(100);
		obj.insertData(50);
		obj.insertData(40);
		obj.insertData(60);
		obj.insertData(30);
		obj.insertData(44);
		obj.insertData(55);
		obj.insertData(70);
		obj.insertData(48);
		
		//obj.preOrderTraversal();

		//obj.preOrderTraversalUsingStack();

		obj.postOrderTraversal();
		System.out.println("Pre-order ::::: ");
		obj.preOrderTraversal();
	}

	public void postOrderTraversal(){
		Stack<Node> stack = new Stack<Node>(); 
        Node node = root;
        
        if (node == null) 
            return; 
        
        stack.push(node); 
        Node prev = null; 
        
        while (!stack.isEmpty())  { 
        	Node current = stack.peek(); 
        	   
            if (prev == null || prev.left == current ||   prev.right == current) { 
                if (current.left != null) 
                    stack.push(current.left); 
                else if (current.right != null) 
                    stack.push(current.right); 
                else { 
                    stack.pop(); 
                    System.out.println(current.data); 
                }
            }
            
            else if (current.left == prev)  { 
                if (current.right != null) 
                    stack.push(current.right); 
                else { 
                    stack.pop(); 
                    System.out.println(current.data); 
                } 
            }  
            else if (current.right == prev)  { 
                stack.pop(); 
                System.out.println(current.data); 
            } 
            prev = current; 
        } 
	}

	public void insertData(int data) {
		Node node = new Node(data);
		if (root == null) {
			root = node;
		} else {
			createTree(node, root);
		}
	}

	private void createTree(Node node, Node root) {
		if (root.data < node.data) {
			if (root.right != null) {
				createTree(node, root.right);
			} else {
				root.right = node;
			}
		} else if (root.data > node.data) {
			if (root.left != null) {
				createTree(node, root.left);
			} else {
				root.left = node;
			}
		}
	}

	public void preOrderTraversal() {
		preOrderTraversal(root);
	}

	public void preOrderTraversalUsingStack() {
		preOrderTraversalUsingStack(root);
	}

	private void preOrderTraversal(Node root) {
		Node temp = root;
		if (temp != null) {
			System.out.println(temp.data);
			preOrderTraversal(temp.left);
			preOrderTraversal(temp.right);

		}
	}

	private void preOrderTraversalUsingStack(Node root) {
		if (root != null) {
			stack.push(root);
			preOrderTraversalUsingStack(root.left);
		}

	}
}
