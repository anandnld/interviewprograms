package mylearning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
	Map<String, Node> tree = null;
	boolean isStringEnd = false;
	
	Node(Map<String, Node> tree, boolean isStringEnd){
		this.tree = tree;
		this.isStringEnd = isStringEnd;
	}
}

public class Dictonary {

	public static void main(String[] args) {
		String[] words = new String[] {"build","arms","time","cisco","land","happy","god","home","asdf","bird","ratle","java","qwerty","java","anand", "anan","mark", "kumud", "result","area", "advik"};
		Dictonary obj = new Dictonary();
		
		
		obj.usingList();
		
		System.out.println("------------------------------");
		obj.usingTree();
		
	}
	
	public void usingTree() {
		
		long time = System.currentTimeMillis();
		//Node root = obj.createDictonary(words);
		Node root = createDictonary();
		
		System.out.println("Dictonary create time : "+(System.currentTimeMillis() - time));
		
		System.out.println("\n\nSearh word in Dictonary :::: ");
		String word = "introductions";
		boolean wordFlag = findWordInDictonary(root, word);
		System.out.println("Search word time : "+(System.currentTimeMillis() - time));
		
		if(wordFlag) System.out.println("Word '"+word+"' present in Dictonary");
		else System.out.println("Word "+word+" NOT present in Dictonary");
	}
	
	public void usingList() {
		long time = System.currentTimeMillis();
		List<String> list = createDictonaryUsingList();
		System.out.println("Dictonary create time : "+(System.currentTimeMillis() - time));
		System.out.println("List size : "+list.size());
		
		String word = "introductions";
		if(list.contains(word)) {
			System.out.println("word found in list ");
		}else {
			System.out.println("word not found in list ");
		}
		System.out.println("Search word time : "+(System.currentTimeMillis() - time));
	}
	
	
	public List<String> createDictonaryUsingList() {
		
		BufferedReader bufRead;
		List<String> list = new ArrayList<String>();
		try {
			bufRead = new BufferedReader(new FileReader("/Users/ananata2/eclipse-workspace/mylearning/src/mylearning/words.txt"));
			String line = bufRead.readLine();
			while(line != null) {
				list.add(line);
				
				line = bufRead.readLine();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public Node createDictonary() {
		
		Map<String, Node> tree = new HashMap<String, Node>();
		Node root = new Node(tree, false);
		
		BufferedReader bufRead;
		try {
			bufRead = new BufferedReader(new FileReader("/Users/ananata2/eclipse-workspace/mylearning/src/mylearning/words.txt"));
			String line = bufRead.readLine();
			while(line != null) {
				
				Node chNode = root;
				for(int i=0;i<line.length();i++) {
					if(!chNode.tree.containsKey(String.valueOf(line.charAt(i)))) {
						Map<String, Node> tmpTree = new HashMap<String, Node>();
						Node node = new Node(tmpTree, false);
						chNode.tree.put(String.valueOf(line.charAt(i)) , node);
					}
					chNode = chNode.tree.get(String.valueOf(line.charAt(i)));
				}
				chNode.isStringEnd = true;
				
				line = bufRead.readLine();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return root;
	}
	
	
	public boolean findWordInDictonary(Node root, String word) {
		
		for(int i=0;i<word.length();i++) {
			if(!root.tree.containsKey(String.valueOf(word.charAt(i)))) {
				return false;
			}
			root = root.tree.get(String.valueOf(word.charAt(i)));
		}
		if(root.isStringEnd) return true;
		return false;
	}
	
	public void printAllWordsInDictonary(Node root) {
		printAllWordsInDictonary(root, "");
	}
	
	public void printAllWordsInDictonary(Node root, String str) {
		Map<String, Node> tree = root.tree;
		for (Map.Entry<String,Node> entry : tree.entrySet()) {
			printAllWordsInDictonary(entry.getValue(), str+entry.getKey());
			if(tree.get(entry.getKey()).isStringEnd) 
				System.out.println(str+entry.getKey());
		}
	}
	
	public Node createDictonary(String[] str) {
		
		Map<String, Node> tree = new HashMap<String, Node>();
		Node root = new Node(tree, false);
		
		for (String string : str) {
			Node chNode = root;
			for(int i=0;i<string.length();i++) {
				if(!chNode.tree.containsKey(String.valueOf(string.charAt(i)))) {
					Map<String, Node> tmpTree = new HashMap<String, Node>();
					Node node = new Node(tmpTree, false);
					chNode.tree.put(String.valueOf(string.charAt(i)) , node);
				}
				chNode = chNode.tree.get(String.valueOf(string.charAt(i)));
			}
			chNode.isStringEnd = true;
		}
		return root;
	}
}
