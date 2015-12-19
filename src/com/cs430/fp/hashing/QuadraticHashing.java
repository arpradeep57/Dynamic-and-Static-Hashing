package com.cs430.fp.hashing;

public class QuadraticHashing<K, V> extends HashBase<K, V> {

	public QuadraticHashing(int hashSize) {
		super(hashSize);
	}

	@Override
	protected int hash(int keyInt, int round) {
		int hashValue = (keyInt + (round * round)) % hashSize;
		return hashValue;
	}
	
	public static void main(String args[]) {
		QuadraticHashing<Integer, String> hashTable = new QuadraticHashing<Integer, String>(10000000);

		long startTime = System.currentTimeMillis();
		hashTable.insert(3, "3");
		hashTable.printHash();

		hashTable.insert(5, "5");
		hashTable.printHash();

		hashTable.insert(13, "13");
		hashTable.printHash();

		hashTable.insert(24, "24");
		hashTable.printHash();

		hashTable.insert(33, "33");
		hashTable.printHash();

		hashTable.insert(45, "45");
		hashTable.printHash();

		hashTable.insert(54, "54");
		hashTable.printHash();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

}
