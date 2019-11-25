package info.katikireddy622.cassandratest;

public class HashMapImp<String, Double> {
	private Entry<String, Double>[] buckets;
	// private static final int INITIAL_CAPACITY = 1 << 4; // 16
	private int size = 0;

	private int capacity = 0;

	public HashMapImp() {
		// this(INITIAL_CAPACITY);
	}

	public HashMapImp(int capacity) {
		this.capacity = capacity;
		this.buckets = new Entry[capacity];
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
		Entry<String, Double> entry = new Entry<>(key, value, null);
		int bucket = getHash(key) % getBucketSize();
		Entry<String, Double> existing = buckets[bucket];
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
		Entry<String, Double> bucket = buckets[getHash(key) % getBucketSize()];
		while (bucket != null) {
			if (bucket.key.equals(key)) {
				return bucket.value;
			}
			bucket = bucket.next;
		}
		return null;
	}

	@Override
	public java.lang.String toString() {

		StringBuilder mapAsString = new StringBuilder("{");
		for (int i = 0; i < buckets.length; i++) {
			Entry<String, Double> entry = buckets[i];
			if (entry != null)
				mapAsString.append(entry.toString());
		}
		mapAsString.append("}");
		return mapAsString.toString();
	}

}