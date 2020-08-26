package mylearning;


class LinkedList{
	int val;
	LinkedList next;
	public LinkedList(int val) {
		this.val = val;
		this.next = null;
	}
}

public class AddTwoNumbersLL {

	public static void main(String[] args) {
		
		AddTwoNumbersLL obj = new AddTwoNumbersLL();
		
		LinkedList first  = obj.createLinkedList(new int[] {1,2,3,4});	//  1234
		LinkedList second = obj.createLinkedList(new int[] {  4,5,6});	//   456
		
		int fLen = obj.findLength(first);
		int sLen = obj.findLength(second);
		
		while(fLen < sLen) {
			LinkedList tmp = new LinkedList(0);
			tmp.next = first;
			first = tmp;
			fLen++;
		}
		
		while(sLen < fLen) {
			LinkedList tmp = new LinkedList(0);
			tmp.next = second;
			second = tmp;
			sLen++;
		}
		
		LinkedList root = null;
				
		obj.addTwoNumbers(first, second, root);
		
	}
	
	public int addTwoNumbers(LinkedList first, LinkedList second, LinkedList root) {
		
		int carry = 0;
		if(first.next != null || second.next != null)
			carry = addTwoNumbers((first.next != null ? first.next : first), (second.next != null ? second.next : first), root);
		
		int tot = first.val + second.val + carry;
	
		if(root == null) {
			
			LinkedList tmp = new LinkedList(tot%10);
			root = tmp;
		}else {
			
		}
		
		System.out.println(first.val +" : "+second.val);
		
	}
	
	public LinkedList createLinkedList(int[] nums) {
		
		LinkedList root = null;
		LinkedList lastNode = null;
		for(int num : nums) {
			if(root == null) {
				root = new LinkedList(num);
				lastNode = root;
			}else {
				LinkedList tmp = new LinkedList(num);
				lastNode.next = tmp;
				lastNode = tmp;
			}
		}
		return root;
	}
	
	public int findLength(LinkedList root) {
		int len = 0;
		while(root != null) {
			len++; root = root.next;
		}
		return len;
	}
}
