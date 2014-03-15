package ca.uwo.csd.cs2212.team5;
public class DictEntry {
	
	private Object key;
	private Object value;
	
	public DictEntry(Object key, Object value) {
		this.key = key;
		this.value = value;
	}
	
	public Object key() {
		return key;
	}
	
	public Object value() {
		return value;
	}

}
