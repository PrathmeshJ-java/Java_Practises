package LinkedList;

public class linkedListOperation {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.addfirst(1);
		linkedList.addfirst(2);
		linkedList.addfirst(3);
		linkedList.addfirst(4);
		linkedList.addlast(5);
		linkedList.addfirst(7);
		linkedList.printlist();
		linkedList.insertAfterGivenNode(3, 9);
		linkedList.printlist();
		linkedList.deletedOddNode();
		linkedList.printlist();
		
		}
	
}


