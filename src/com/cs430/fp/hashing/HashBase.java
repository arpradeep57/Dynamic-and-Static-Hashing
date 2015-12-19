package com.cs430.fp.hashing;

public abstract class HashBase<K, V> {

	protected Object keys[];
	protected Object values[];

	protected int count;
	protected int hashSize;

	public HashBase(int hashSize) {
		this.hashSize = hashSize;
		this.count = 0;
		keys = new Object[hashSize];
		values = new Object[hashSize];
	}

	// Basic functions
	public boolean insert(K key, V value) {
		int index = search(key);
		if (index == -1) {
			index = getNextEmptyIndexFor(key);
		}
		if (key.equals(keys[index])) {
			values[index] = value;
			//count++;
		} else if (keys[index] == null) {
			keys[index] = key;
			values[index] = value;
			count++;
		} else if (index == -1) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public int search(K key) {
		int round = 0;
		boolean found = false;
		int keyHashCode = key.hashCode();
		int presentIndex = -1;
		while (!found) {
			presentIndex = hash(keyHashCode, round);
			if (key.equals(((K) keys[presentIndex]))) {
				found = true;
				break;
			} else if (round == this.hashSize) {
				presentIndex = -1;
				break;
			}
			round++;
		}
		return presentIndex;
	}

	@SuppressWarnings("unchecked")
	public V remove(K key) {
		int index = search(key);
		if (index != -1) {
			keys[index] = null;
			V temp = (V) values[index];
			values[index] = null;
			count--;
			return temp;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public V get(K key) {
		int keyIndex = search(key);
		if (keyIndex != -1) {
			return (V) values[keyIndex];
		} else {
			return null;
		}
	}

	public boolean clear() {
		this.count = 0;
		keys = new String[hashSize];
		values = new String[hashSize];
		return true;
	}

	// public Collection<String> getKeys() {
	// Collection<String> keyCollection = Collections.emptyList();
	// if (count > 0) {
	// keyCollection = Arrays.asList(keys).removeAll(c);
	// }
	// return keyCollection;
	// }

	public void printHash() {
		System.out.println("Keys\tValues");
		System.out.println("=============");
		for (int i = 0; i < hashSize; i++) {
			System.out.println(keys[i] + "\t" + values[i]);
		}
		System.out.println("=============\n");
	}

	public void printHashValues() {
		System.out.println("Index\tValues");
		System.out.println("=============");
		for (int i = 0; i < hashSize; i++) {
			System.out.println(i + "\t" + values[i]);
		}
		System.out.println("=============\n");
	}

	private int getNextEmptyIndexFor(K key) {
		if (this.count == this.hashSize) {
			return -1;
		}
		int round = 0;
		boolean found = false;
		int keyHashCode = key.hashCode();
		int presentIndex = -1;
		while (!found) {
			presentIndex = hash(keyHashCode, round);
			if (keys[presentIndex] == null) {
				found = true;
				break;
			}
			round++;
		}
		return presentIndex;
	}

	public int getMapSize() {
		return this.count;
	}

	protected abstract int hash(int keyInt, int round);
}
