
////////////////////////////
public class Main{
	public static void main(String [] args) {
		AVLTree bst = new AVLTree();
    	bst.insert(1);
    	bst.insert(2);
    	//bst.insert(3);
    	//bst.insert(4);
    	//bst.insert(5);
    	//bst.insert(6);
    	//bst.insert(7);
    	//bst.insert(8);
    	bst.prettyPrint();
    	bst.deleteNode(1);
    	bst.searchTree(2);
	}
}
////////////////////////////////////////////////////////////////////////////////////////
