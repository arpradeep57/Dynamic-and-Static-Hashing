package com.cs430.fp.hashing;

public class DoubleHashing<K, V> extends HashBase<K, V> {

	public DoubleHashing(int hashSize) {
		super(hashSize);
	}

	@Override
	protected int hash(int keyInt, int round) {
		int R = 7;
		int hashValue = (keyInt + (round * secondaryHash(keyInt, R))) % hashSize;
		return hashValue;
	}
	
	private int secondaryHash(int keyInt, int R) {
		return R - (keyInt % R);
	}

	public static void main(String args[]) {
		DoubleHashing<Integer, String> hashTable = new DoubleHashing<Integer, String>(10000000);

		long startTime = System.currentTimeMillis();
		hashTable.insert(89, "89");
		hashTable.printHash();

		hashTable.insert(18, "18");
		hashTable.printHash();

		hashTable.insert(49, "49");
		hashTable.printHash();

		hashTable.insert(58, "58");
		hashTable.printHash();

		hashTable.insert(69, "69");
		hashTable.printHash();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
//		hashTable.insert(45, "45");
//		hashTable.printHash();
//
//		hashTable.insert(54, "54");
//		hashTable.printHash();
	}

}
