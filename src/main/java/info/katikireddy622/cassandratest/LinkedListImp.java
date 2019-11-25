package info.katikireddy622.cassandratest;

class LinkedListImp<String, Double> {
	final String key;
	Double value;
	LinkedListImp<String, Double> next;

	public LinkedListImp(String key, Double value, LinkedListImp<String, Double> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}

	@Override
	public java.lang.String toString() {
		return "Entry [key=" + key + ", value=" + value + ", next=" + next + "]";
	}

}