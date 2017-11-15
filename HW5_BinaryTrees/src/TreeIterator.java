import java.util.Iterator;
import java.util.Vector;

public class TreeIterator <K extends Comparable<? super K>, V> implements Iterator<TreeItem<K,V>> {

	private BinarySearchTree<K,V> bst;
	private Vector<TreeNode<K,V>> treeNodes;
	
	
	public TreeIterator(BinarySearchTree<K,V> bst) {
		this.bst = bst;
		this.treeNodes = null;
	}
	
	public int size() {
		if (this.treeNodes == null) {
			return 0;
		} else {
			return this.treeNodes.size();
		}
	}
	
	public boolean isEmpty() {
		if (this.treeNodes == null) {
			return true;
		} else {
			return this.treeNodes.isEmpty();
		}
	}
	
	
	public void setPreorder() {
		treeNodes = new Vector<TreeNode<K,V>>();
		preOrder(this.bst.getRoot());
	}
	
	public void setInorder() {
		treeNodes = new Vector<TreeNode<K,V>>();
		inOrder(this.bst.getRoot());
	}
	
	public void setPostorder() {
		treeNodes = new Vector<TreeNode<K,V>>();
		postOrder(this.bst.getRoot());
	}
	
	
	@Override
	public boolean hasNext() {
		if (this.treeNodes == null) {
			return false;
		} else {
			return (!this.treeNodes.isEmpty());
		}
	}

	@Override
	public TreeItem<K, V> next() {
		TreeNode<K,V> node = this.treeNodes.firstElement();
		this.treeNodes.remove(0);
		return node.getTreeItem();
	}
	
/******************************************************************************/	
/*                           Private Methods                                  */
/******************************************************************************/	
	
	private void preOrder(TreeNode<K,V> node) {
		if (node != null) {
			this.treeNodes.add(node);
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());
		}
	}
	
	private void inOrder(TreeNode<K,V> node) {
		if (node != null) {
			inOrder(node.getLeftChild());
			this.treeNodes.add(node);
			inOrder(node.getRightChild());
		}
	}
	
	private void postOrder(TreeNode<K,V> node) {
		if (node != null) {
			postOrder(node.getLeftChild());
			postOrder(node.getRightChild());
			this.treeNodes.add(node);
		}
	}
}
