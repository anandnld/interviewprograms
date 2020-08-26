package com.prog;

public class ReverseLinkedList {

	class NODE {

		int data;
		NODE next = null;

		public NODE(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {

		int array[] = new int[] { 11, 12, 13, 14, 15, 16, 17, 18 };

		ReverseLinkedList obj = new ReverseLinkedList();

		NODE start = obj.createLinkedList(array);
		
		NODE rll = obj.reverseLL(start);
		 
		obj.traverseLinkedList(rll);

	}
	
	public NODE reverseLL(NODE start){
		
		if(start.next == null) return start;
		else{
			NODE node = reverseLL(start.next);
			System.out.println(start.next.next);
			start.next.next = start;
			start.next = null;
			return node;
		}
		
		/*
		
		if(start != null){
			 
			NODE tmp = reverseLL(start.next);
			if(tmp == null)  start = null;
			else reverseLL(start.next).next = start;
			}
		return start;*/
	}
	
	/*public NODE reverseLL(NODE start) {
		if (start.next == null)
			return start;
		else {
			NODE head = reverseLL(start.next);
			System.out.println("SRTARET ::::: "+start.data);
			start.next.next = start;
			System.out.println("START :::::::::::::::::::::::: "+start.next.next.data);

			start.next = null;
			return head;
		}

	}*/

	public NODE createLinkedList(int[] array) {

		NODE start = null;

		for (int i : array) {

			NODE tmp = new NODE(i);

			if (start == null) {
				start = tmp;
			} else {
				NODE mover = start;
				while (mover.next != null) {
					mover = mover.next;
				}
				mover.next = tmp;
			}
		}
		return start;
	}

	public void traverseLinkedList(NODE start) {
		while (start != null) {
			System.out.println(start.data);
			start = start.next;
		}
	}
}
