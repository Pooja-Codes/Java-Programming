
public class Pair<T, V> {
	
	private T key;
	private V value;
	
	Pair(T key, V value) {
		this.key = key;
		this.value = value;
	}

	public T getKey() {
		return this.key;
	}
	
	public void setKey(T key) {
		this.key = key;
	}
	
	public V getValue() {
		return this.value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	public String toString() {
		return "[Pair: key = " + this.key + ", value = " + this.value + "]";
	}
}
