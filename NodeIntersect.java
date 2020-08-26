package mylearning;

public class NodeIntersect {

	public static void main(String[] args) {
		
	}
	
public int lengthOfLongestSubstring(String s) {
        
        String subStr = "";
        int startPtr = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(startPtr == i) {
                subStr = subStr + s.charAt(i);
            }else {
                
                if(subStr.contains(String.valueOf(s.charAt(i)))){
                    
                    subStr = subStr.substring(1, subStr.length()) + s.charAt(i);
                    startPtr++;
                    
                }else {
                    subStr = subStr + s.charAt(i);
                    max = Math.max(max, subStr.length());
                }
            }
        }
        return max;
        
    }


	public void levelOrderTraversal(Node root) {

	  if (root == null)
	   return;

	  Queue<Node> queue = new LinkedList<Node>();
	  queue.add(root);
	  System.out.println(root.data);

	  while (queue.size() > 0) {
	   Node current = queue.poll();
	   if (current.left != null) {
	    System.out.println(current.left.data);
	    queue.add(current.left);
	   }
	   if (current.right != null) {
	    System.out.println(current.right.data);
	    queue.add(current.right);
	   }
	  }
	 }
}

