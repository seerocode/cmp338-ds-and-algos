
public class TreeNode <K extends Comparable<? super K>, V> {

	private TreeItem<K,V> treeItem;
	private TreeNode<K,V> leftChild;
	private TreeNode<K,V> rightChild;
	private TreeNode<K,V> parent;

	
	public TreeNode(TreeItem<K,V> treeItem) {
		this.treeItem   = treeItem;
		this.leftChild  = null;
		this.rightChild = null;
		this.parent     = null;
	}


	public TreeItem<K, V> getTreeItem() {
		return treeItem;
	}


	public void setTreeItem(TreeItem<K, V> treeItem) {
		this.treeItem = treeItem;
	}


	public TreeNode<K, V> getLeftChild() {
		return leftChild;
	}


	public void setLeftChild(TreeNode<K, V> leftChild) {
		this.leftChild = leftChild;
	}


	public TreeNode<K, V> getRightChild() {
		return rightChild;
	}


	public void setRightChild(TreeNode<K, V> rightChild) {
		this.rightChild = rightChild;
	}


	public TreeNode<K, V> getParent() {
		return parent;
	}


	public void setParent(TreeNode<K, V> parent) {
		this.parent = parent;
	}
}
