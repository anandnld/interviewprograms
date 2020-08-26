package com.prog;

public class AddNumbersLinkedList 
{
    private class ListNode
    {
        int value;
        ListNode next;

        ListNode(int value)
        {
            this.value = value;
        }
    }
    
    ListNode head;
    
    // appends newNode at the end the currentNode and returns newNode
    private ListNode appendNode(ListNode currentNode, ListNode newNode)
    {
        if (currentNode == null)
        {
            return newNode;
        }
        
        currentNode.next = newNode;
        return newNode;
    }
    
    // adds node at the beginning of the list
    private void addNode(int value)
    {
        if (head == null)
        {
            head = new ListNode(value);
            return;
        }
        
        ListNode n = new ListNode(value);
        n.next = head;
        head   = n;
    }
    
    // creates and returns a new list with node values taken from number[] array
    public ListNode createLinkedList(int[] number)
    {
        // if the head is pointing to some existing list, make it null
        // let the clients handle and store the reference to head
        if (head != null)
        {
            head = null;
        }
        
        if (number != null)
        {
            for (int i = 0; i < number.length; i++)
            {
                addNode(number[i]);
            }
        }
        
        return head;
    }
    
    public void printList(ListNode head)
    {
        ListNode temp = head;
        
        while (temp != null)
        {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }
    
    /*
     * node1 and node2 are corresponding nodes and carry is taken from addition of previous pair of
     * corresponding nodes. 
     */
    private ListNode addListsRecursive(ListNode node1, ListNode node2, int carry)
    {
        // base case: If we are done with adding both lists
        if (node1 == null && node2 == null)
        {
            if (carry > 0)
            {
                return new ListNode(carry);
            }
            return null;
        }
        
        // if a node is null, we consider its value as 0
        int value1 = (node1 != null) ? node1.value : 0;
        int value2 = (node2 != null) ? node2.value : 0;
        
        // calculate sum and carry by using values of corresponding nodes 
        int sum = (value1 + value2 + carry) % 10;
        carry   = (value1 + value2 + carry) / 10;
        
        // create a new node with value as sum.
        ListNode currentHead = new ListNode(sum);
        
        // get the next nodes for respective linked lists
        ListNode node1Next = (node1 != null) ? node1.next : null;
        ListNode node2Next = (node2 != null) ? node2.next : null;

        // now add list segments after node1 and node2. 
        // append the result to currentHead(obtained by adding node1 and node2)  
        currentHead.next = addListsRecursive(node1Next, node2Next, carry);
        
        return currentHead;
    }
    
    private ListNode addListsIterative(ListNode node1, ListNode node2)
    {
        // create an empty linked list with head as result node
        ListNode result = createLinkedList(null);
        
        // used for keeping track of the last node of the resultant linked list
        ListNode tempTail = result; 

        int sum = 0, carry = 0;
        while ((node1 != null) || (node2 != null))
        {
            // if a node is null, we consider its value as 0
            int value1 = (node1 != null) ? node1.value : 0;
            int value2 = (node2 != null) ? node2.value : 0;

            // calculate sum and carry by using values of corresponding nodes 
            sum = (value1 + value2 + carry) % 10;
            carry   = (value1 + value2 + carry) / 10;

            // append the newly created node to existing list
            tempTail = appendNode(tempTail, new ListNode(sum));
            
            // if this iteration adds the first node to result,
            // then make result point to this first node
            if (result == null)  
            {
                result = tempTail;
            }
            
            // advance both lists if possible
            if (node1 != null)
            {
                node1 = node1.next;
            }
            
            if (node2 != null)
            {
                node2 = node2.next;
            }
        }
        
        if (carry > 0)
        {
            tempTail = appendNode(tempTail, new ListNode(carry));
        }
        
        return result;
    }
    
    public ListNode addLists(ListNode node1, ListNode node2)
    {
        return addListsRecursive(node1, node2, 0);
    }
    
    
    public static void main(String[] args) 
    {
        AddNumbersLinkedList solution = new AddNumbersLinkedList();

        int[] firstNumber  = {9,9,9,7,1}; // number: 99971
        int[] secondNumber = {9,9,8}; // number: 998
        
        // 1->7->9->9->9->null
        ListNode head1 = solution.createLinkedList(firstNumber);
        
        // 8->9->9->null
        ListNode head2 = solution.createLinkedList(secondNumber);
        
        ListNode result = solution.addLists(head1, head2);
        
        System.out.print("Resultant sum represented as a linked list is: \n");
        solution.printList(result);
    }
}