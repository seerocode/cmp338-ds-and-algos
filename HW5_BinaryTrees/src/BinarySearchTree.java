import java.util.Iterator;

public class BinarySearchTree<K extends Comparable<? super K>, V> implements Iterable {

	private TreeNode<K, V> root;

	public BinarySearchTree() {
		this.root = null;
	}

	public BinarySearchTree(TreeNode<K, V> root) {
		this.root = root;
	}

	public TreeNode<K, V> getRoot() {
		return root;
	}

	public void setRoot(TreeNode<K, V> root) {
		this.root = root;
	}

	public boolean isEmpty() {
		boolean answer = true;

		if (this.root != null) {
			answer = false;
		}

		return answer;
	}

	public void makeEmpty() {
		this.root = null;
	}

	public TreeItem<K, V> getRootItem() throws TreeException {
		if (this.root != null) {
			return this.root.getTreeItem();
		} else {
			throw new TreeException("TreeException: Tree is empty, no TreeItem to return");
		}
	}

	public TreeItem<K, V> find(K key) {
		return (findItem(this.root, key));
	}

	public void insert(TreeItem<K, V> treeItem) {
		this.root = insertItem(this.root, null, treeItem);
	}

	@Override
	public TreeIterator<K, V> iterator() {
		return new TreeIterator<K, V>(this);
	}

	public void delete(K key) {
		this.root = deleteItem(this.root, key);
	}

	public int height() {
		return treeHeight(this.root);
	}

	public boolean isBalanced() {
		return treeIsBalanced(this.root);
	}

	/******************************************************************************/
	/* Private Methods */
	/******************************************************************************/

	private int compareKeys(K k1, K k2) {
		return k1.compareTo(k2);
	}

	private TreeItem<K, V> findItem(TreeNode<K, V> node, K key) {
		if (node == null) {
			return null;
		} else if (compareKeys(node.getTreeItem().getKey(), key) == 0) {
			return node.getTreeItem();
		} else if (compareKeys(node.getTreeItem().getKey(), key) > 0) {
			return (findItem(node.getLeftChild(), key));
		} else {
			return (findItem(node.getRightChild(), key));
		}
	}

	private TreeNode<K, V> insertItem(TreeNode<K, V> node, TreeNode<K, V> parent, TreeItem<K, V> treeItem) {
		if (node == null) {
			node = new TreeNode<K, V>(treeItem);
			node.setParent(parent);
		} else if (compareKeys(node.getTreeItem().getKey(), treeItem.getKey()) > 0) {
			node.setLeftChild(insertItem(node.getLeftChild(), node, treeItem));
		} else {
			node.setRightChild(insertItem(node.getRightChild(), node, treeItem));
		}

		return node;
	}

	private TreeNode<K, V> deleteItem(TreeNode<K, V> node, K key) {
		if (node == null) {
			throw new TreeException("TreeException - Item to delete is not found");
		} else {
			TreeItem<K, V> item = node.getTreeItem();
			if (compareKeys(item.getKey(), key) == 0) {
				node = deleteNode(node);
			} else if (compareKeys(item.getKey(), key) > 0) {
				node.setLeftChild(deleteItem(node.getLeftChild(), key));
			} else {
				node.setRightChild(deleteItem(node.getRightChild(), key));
			}
		}
		return node;
	}

	private TreeNode<K, V> deleteNode(TreeNode<K, V> node) {
		if (isLeafNode(node)) {
			return null;
		} else if (noLeftChild(node)) {
			return node.getRightChild();
		} else if (noRightChild(node)) {
			return node.getLeftChild();
		} else {
			TreeNode<K, V> successor = findSuccessorNode(node.getRightChild());
			node.setTreeItem(successor.getTreeItem());
			node.setRightChild(deleteSuccessorNode(node.getRightChild()));
			return node;
		}
	}

	private boolean isLeafNode(TreeNode<K, V> node) {
		return ((node.getLeftChild() == null) && (node.getRightChild() == null));
	}

	private boolean noLeftChild(TreeNode<K, V> node) {
		return (node.getLeftChild() == null);
	}

	private boolean noRightChild(TreeNode<K, V> node) {
		return (node.getRightChild() == null);
	}

	private TreeNode<K, V> findSuccessorNode(TreeNode<K, V> node) {
		if (node.getLeftChild() == null) {
			return node;
		} else {
			return findSuccessorNode(node.getLeftChild());
		}
	}

	private TreeNode<K, V> deleteSuccessorNode(TreeNode<K, V> node) {
		if (node.getLeftChild() == null) {
			return node.getRightChild();
		} else {
			node.setLeftChild(deleteSuccessorNode(node.getLeftChild()));
			return node;
		}
	}

	private int treeHeight(TreeNode<K, V> node) {
		int treeHeight = 0;

		if (node == null) {
			return -1;
		}
		// recursively get height of left subtree until
		// we reach an empty node
		int leftHeight = treeHeight(node.getLeftChild());
		// recursively get height of right subtree until
		// we reach an empty node
		int rightHeight = treeHeight(node.getRightChild());
		// tree height is the maximum between left and right
		// heights, plus 1
		if (leftHeight > rightHeight) {
			treeHeight = leftHeight + 1;
		} else {
			treeHeight = rightHeight + 1;
		}

		return treeHeight;
	}

	private boolean treeIsBalanced(TreeNode<K, V> node) {
		boolean isTreeBalanced = true;

		int leftHeight;
		int rightHeight;

		// if the node is empty then the tree is already balanced
		if (node == null) {
			return isTreeBalanced;
		}
		
		// recursively get left height of tree
		leftHeight = treeHeight(node.getLeftChild());
		// recursively get right height of tree
		rightHeight = treeHeight(node.getRightChild());
		// if the abs value of left - right is less than or equal to 1
		// and if the left tree is balanced
		// and if the right tree is balanced
		isTreeBalanced = (Math.abs(leftHeight - rightHeight) <= 1) && treeIsBalanced(node.getLeftChild())
				&& treeIsBalanced(node.getRightChild());
		// return that its balanced
		return isTreeBalanced;
	}
	
	public void balance() {
		
	}

}
