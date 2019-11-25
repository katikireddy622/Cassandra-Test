package info.katikireddy622.cassandratest;

public class HashMapImp<String, Double> {
	private LinkedListImp<String, Double>[] buckets;
	private int size = 0;
	private int capacity = 0;

	public HashMapImp() {
		this.capacity = 888;
		this.buckets = new LinkedListImp[capacity];
	}

	public HashMapImp(int capacity) {
		this.capacity = capacity;
		this.buckets = new LinkedListImp[capacity];
	}

	private int getBucketSize() {
		return capacity;
	}

	private int getHash(String key) {
		int hash = 0;
		for (int i = 0; i < key.toString().length(); i++) {
			hash = hash + (int) key.toString().charAt(i);
		}

		System.out.println("hashCode for key: " + key + " = " + hash);
		return hash;

	}

	public void put(String key, Double value) {
		LinkedListImp<String, Double> entry = new LinkedListImp<>(key, value, null);
		int bucket = getHash(key) % getBucketSize();
		LinkedListImp<String, Double> existing = buckets[bucket];
		if (existing == null) {
			buckets[bucket] = entry;
			size++;
		} else {
			// compare the keys see if key already exists
			while (existing.next != null) {
				if (existing.key.equals(key)) {
					existing.value = value;
					return;
				}
				existing = existing.next;
			}
			if (existing.key.equals(key)) {
				existing.value = value;
			} else {
				existing.next = entry;
				size++;
			}
		}
	}

	public Double get(String key) {
		LinkedListImp<String, Double> bucket = buckets[getHash(key) % getBucketSize()];
		while (bucket != null) { // traverse the linked list till you found appropriate key
			if (bucket.key.equals(key)) {
				return bucket.value;
			}
			bucket = bucket.next;
		}
		return null;
	}

	// just toString method for debugging purpose
	@Override
	public java.lang.String toString() {

		StringBuilder mapAsString = new StringBuilder("{");
		for (int i = 0; i < buckets.length; i++) {
			LinkedListImp<String, Double> entry = buckets[i];
			if (entry != null)
				mapAsString.append(entry.toString());
		}
		mapAsString.append("}");
		return mapAsString.toString();
	}

}