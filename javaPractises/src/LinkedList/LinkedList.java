package LinkedList;

public class LinkedList {
	
	Node head;
	
	class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
		
		
		}
	
	void addfirst(int data) {
		Node new_node = new Node(data);
		
		if(head == null) {
			head = new_node;
			return;
		}
		
		new_node.next = head;
		head = new_node;
	}
	
	void addlast(int data) {
		Node new_node = new Node(data);
		
		if(head == null) {
			head = new_node;
			return;
		}
		
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		last.next = new_node;
		
	}
	
	void printlist() {
		Node current = head;
		while(current.next != null) {
			System.out.print(current.data+" ");
			current = current.next;
		}
		System.out.println(current.data);;
		
	}
	
	void insertAfterGivenNode(int prev, int data) {
		
		Node new_node = new Node(data);
		Node currentNode = head;
	   while(currentNode.next != null) {
		   currentNode = currentNode.next;
		   if(currentNode.data == prev) {
			   new_node.next = currentNode.next;
			   currentNode.next = new_node;
			   }
	   }
	   
    }
	
	void deletedOddNode() {
		if(head==null) {
			return;
		}
		if (head.data % 2 != 0) {
	        head = head.next; 
	    }
		Node currentNode = head;
		while(currentNode.next != null) {
			if(currentNode.next.data % 2 != 0) {
				currentNode.next = currentNode.next.next;
			}else {
	            currentNode = currentNode.next; 
	        }
		}
		
	}
	
}
