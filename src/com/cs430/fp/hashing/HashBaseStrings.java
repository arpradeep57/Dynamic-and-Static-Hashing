package com.cs430.fp.hashing;

public abstract class HashBaseStrings {

	protected String keys[];
	protected String values[];

	protected int count;
	protected int hashSize;

	public HashBaseStrings(int hashSize) {
		this.hashSize = hashSize;
		this.count = -1;
		keys = new String[hashSize];
		values = new String[hashSize];
	}

	// Basic functions
	public boolean insert(String key, String value) {
		int index = search(key);
		if(index == -1) {
			index = getNextEmptyIndexFor(key);
		}
		if (key.equals(keys[index])) {
			values[index] = value;
			count++;
		} else if (keys[index] == null) {
			keys[index] = key;
			values[index] = value;
			count++;
		} else if (index == -1) {
			return false;
		}
		return true;
	}

	public int search(String key) {
		int round = 0;
		boolean found = false;
		int keyHashCode = key.hashCode();
		int presentIndex = -1;
		while (!found) {
			presentIndex = hash(keyHashCode, round);
			if (keys[presentIndex] == key) {
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

	public String remove(String key) {
		int index = search(key);
		if (index != -1) {
			keys[index] = null;
			String temp = values[index];
			values[index] = null;
			count--;
			return temp;
		} else {
			return null;
		}
	}

	public String get(String key) {
		int keyIndex = search(key);
		if (keyIndex != -1) {
			return values[keyIndex];
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

//	public Collection<String> getKeys() {
//		Collection<String> keyCollection = Collections.emptyList();
//		if (count > 0) {
//			keyCollection = Arrays.asList(keys).removeAll(c);
//		}
//		return keyCollection;
//	}

	public void printHash(){
		System.out.println("Keys\tValues");
		System.out.println("=============");
		for (int i = 0; i < hashSize; i++) {
			System.out.println(keys[i] + "\t" + values[i]);
		}
		System.out.println("=============\n");
	}
	
	private int getNextEmptyIndexFor(String key) {
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

	protected abstract int hash(int keyInt, int round);
}
