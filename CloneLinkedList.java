package mylearning;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CloneLinkedList {

	class LinkedList {
		int val;
		LinkedList next;
		LinkedList ran;
		String name;
		
		LinkedList(int val, String name){
			this.val = val;
			this.name = name;
			this.next = null;
			this.ran = null;
		}
	}
	
	public static void main(String[] args) {
		
		CloneLinkedList obj = new CloneLinkedList();
		int[] val = new int[] {1,2,3,4,5,6,7,8,9,10};

		LinkedList root = obj.createLinkedList(val);
		
		LinkedList clone = obj.cloneLinedList(root);
		
		obj.printLinkedList(root);

		obj.printLinkedList(clone);
	}
	
	public LinkedList cloneLinedList(LinkedList root) {
		
		// New cloned LinkedList pointer
		LinkedList clone = null;
		
		// Temporary pointer for the original LinkedList
		LinkedList tmpRoot = root;
		
		// Creating new clone nodes without Random pointer
		while(null !=  tmpRoot) {
			LinkedList tmp = null;
			if(null == clone) {
				clone = tmp = new LinkedList(tmpRoot.val, "C");
			}else {
				tmp = new LinkedList(tmpRoot.val, "C");
			} 
			
			tmp.next = tmpRoot.next;
			tmpRoot.next = tmp;
			tmpRoot = tmp.next;
		}
		
		
		// Rearrange next and set random pointers of each clone node
		tmpRoot = root;
		while(null != tmpRoot && null != tmpRoot.next) {
			tmpRoot.next.ran = tmpRoot.ran != null ? tmpRoot.ran.next : null;
			tmpRoot = tmpRoot.next != null ? tmpRoot.next.next : null;
		}
		
		tmpRoot = root;
		// Change Original and Clone LinedList next nodes back to correct list. 
		while(null != tmpRoot && null != tmpRoot.next) {
			
			LinkedList tt = tmpRoot.next != null ? tmpRoot.next.next : null;
			
			if(tmpRoot.next.next != null) {
				tmpRoot.next.next = tt.next;
			}
			tmpRoot.next = tt;
			tmpRoot = tt;
		}
		return clone;
	}
	
	public void printLinkedList(LinkedList root) {
		System.out.println("Linked List Value ::::: ");
		System.out.println("VAL \t RANDOM VAL \t NAME");
		while(null != root) {
			System.out.println(root.val +"\t"+root.ran.val+"\t\t"+root.name);
			root = root.next;
		}
	}
	
	public LinkedList createLinkedList(int[] val) {
		LinkedList root = null;
		LinkedList tmp = null;
		List<LinkedList> list = new ArrayList<>();
		Random rand = new Random();
		for(int v : val) {
			if(null == root) {
				tmp = root = new LinkedList(v, "O");
			}else {
				tmp.next = new LinkedList(v, "O");
			}
			list.add(tmp); 
			if(null != tmp.next)
				tmp = tmp.next;
		}
		tmp = root;
		while(null != tmp) {
			int ran = rand.nextInt(list.size());
			tmp.ran = list.get(ran);
			list.remove(ran);
			tmp = tmp.next;
		}
		return root;
	}
}
