
// K must extend Comparable or any super class of K must extend Comparable
public class TreeItem <K extends Comparable<? super K>, V> {

	private K key;
	private V value;
	
	
	public TreeItem(K key, V value) {
		this.key = key;
		this.value = value;
	}


	public K getKey() {
		return key;
	}


	public void setKey(K key) {
		this.key = key;
	}


	public V getValue() {
		return value;
	}


	public void setValue(V value) {
		this.value = value;
	}
}
