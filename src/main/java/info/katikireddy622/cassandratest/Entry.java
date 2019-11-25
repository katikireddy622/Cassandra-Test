package info.katikireddy622.cassandratest;

class Entry<String, Double> {
	final String key;
	Double value;
	Entry<String, Double> next;

	public Entry(String key, Double value, Entry<String, Double> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}

	@Override
	public java.lang.String toString() {
		return "Entry [key=" + key + ", value=" + value + ", next=" + next + "]";
	}

}