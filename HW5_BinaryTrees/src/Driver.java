import java.util.Vector;

public class Driver implements DriverInterface {

	/*
	 * Create 131,071 TreeItem<Integer,String> objects randomly generated. Save all
	 * your randomly generated TreeItem<Integer,String> objects in a
	 * Vector<TreeItem<Integer,String>>
	 * 
	 */
	@Override
	public Vector<TreeItem<Integer, String>> getVectorOfTreeItems() {

		// create a vector to hold items and return
		Vector<TreeItem<Integer, String>> vec = new Vector<TreeItem<Integer, String>>();

		// items to add to the vector
		int countOfItems = 131071;

		for (int i = 0; i < countOfItems; i++) {

			// generate random integers
			Integer itemKeyInt = (int) (Math.round(Math.random() * 150000));

			// create string utem
			String itemString = "String " + itemKeyInt;

			// add integer and string to item
			TreeItem<Integer, String> item = new TreeItem<Integer, String>(itemKeyInt, itemString);

			// add item to the vector
			vec.add(item);

		}

		return vec;
	}

	@Override
	public BinarySearchTree<Integer, String> createAndPopulateBST(Vector<TreeItem<Integer, String>> treeItems) {

		BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<Integer, String>();

		for (TreeItem<Integer, String> item : treeItems) {
			binarySearchTree.insert(item);
		}

		return binarySearchTree;
	}

}
