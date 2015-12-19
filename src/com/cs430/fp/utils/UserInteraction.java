package com.cs430.fp.utils;

import java.util.Scanner;

import com.cs430.fp.hashing.DoubleHashing;
import com.cs430.fp.hashing.LinearHashing;
import com.cs430.fp.hashing.QuadraticHashing;

public class UserInteraction {
	public static Scanner scanner;

	public static void openScanner() {
		scanner = new Scanner(System.in);
	}

	public static void closeScanner() {
		scanner.close();
	}

	private static void displayMessage() {
		System.out.println("Please choose from the below Options");
		System.out.println("====================================");
		System.out.println("\t 1. Linear Hashing");
		System.out.println("\t 2. Quadratic Hashing");
		System.out.println("\t 3. Double Hashing");
		System.out.println("====================================");
	}

	public static void invokeHashingFunctions() {
		int size = getTableSize();
		displayMessage();
		System.out.println("Please Enter user choice :");
		int choice = (Integer) scanInput();
		switch (choice) {
		case 1:
			System.out.println("Invoking Linear Hashing. ! Please wait ..");
			LinearHashing<Object, Object> linearHashing = new LinearHashing<Object, Object>(size);
			invokeTest(linearHashing);
			break;
		case 2:
			System.out.println("Invoking Quadratic Hashing. ! Please wait .. ");
			QuadraticHashing<Object, Object> quadraticHashing = new QuadraticHashing<Object, Object>(size);
			invokeTest(quadraticHashing);
			break;
		case 3:
			System.out.println("Invoking Double Hashing . ! Please wait ..");
			DoubleHashing<Object, Object> doubleHashing = new DoubleHashing<Object, Object>(size);
			invokeTest(doubleHashing);
			break;
		default:
			System.out.println("Invalid Choice .... please choose from below.");
			invokeHashingFunctions();
		}
	}

	public static int getTableSize() {
		System.out.println("Please enter table size: ");
		int tablesize = (Integer) scanInput();
		return tablesize;
	}

	public static Object scanInput() {
		Object choice = null;
		try{
			choice = scanner.next();
			int temp = -1;
			temp = Integer.parseInt((String) choice);
			choice = temp;
		} catch (NumberFormatException ume){
			
		}
		return choice;
	}

	// *****************
	public static void invokeTest(LinearHashing<Object, Object> hashing) {
		while (true) {
			Object input = null;
			int choice = UserInteraction.displayOperation();
			switch (choice) {
			case 1:
				System.out.println("Enter a Key to insert :");
				input = UserInteraction.scanInput();
				if(Integer.class.equals(input.getClass())){
					hashing.insert(input, input);
				} else {
					System.out.println("Enter a Value to insert :");
					Object value = UserInteraction.scanInput();
					hashing.insert(input, value);
				}
				break;
			case 2:
				System.out.println("Enter a key to Delete :");
				input = UserInteraction.scanInput();
				hashing.remove(input);
				break;
			case 3:
				hashing.printHash();
				break;
			case 4:
				hashing.clear();
				break;
			case 5:
				System.out.println(hashing.getMapSize());
				break;
			}
		}
	}
	
	public static void invokeTest(QuadraticHashing<Object, Object> hashing) {
		while (true) {
			Object input = null;
			int choice = UserInteraction.displayOperation();
			switch (choice) {
			case 1:
				System.out.println("Enter a Key to insert :");
				input = UserInteraction.scanInput();
				if(Integer.class.equals(input.getClass())){
					hashing.insert(input, input);
				} else {
					System.out.println("Enter a Value to insert :");
					Object value = UserInteraction.scanInput();
					hashing.insert(input, value);
				}
				break;
			case 2:
				System.out.println("Enter a key to Delete :");
				input = UserInteraction.scanInput();
				hashing.remove(input);
				break;
			case 3:
				hashing.printHash();
				break;
			case 4:
				hashing.clear();
				break;
			case 5:
				System.out.println(hashing.getMapSize());
				break;
			}
		}
	}
	
	public static void invokeTest(DoubleHashing<Object, Object> hashing) {
		while (true) {
			Object input = null;
			int choice = UserInteraction.displayOperation();
			switch (choice) {
			case 1:
				System.out.println("Enter a Key to insert :"); 
				input = UserInteraction.scanInput();
				if(Integer.class.equals(input.getClass())){
					hashing.insert(input, input);
				} else {
					System.out.println("Enter a Value to insert :");
					Object value = UserInteraction.scanInput();
					hashing.insert(input, value);
				}
				break;
			case 2:
				System.out.println("Enter a key to Delete :");
				input = UserInteraction.scanInput();
				hashing.remove(input);
				break;
			case 3:
				hashing.printHash();
				break;
			case 4:
				hashing.clear();
				break;
			case 5:
				System.out.println(hashing.getMapSize());
				break;
			}
		}
	}
	

	public static int displayOperation() {
		System.out.println("Please Choose from Below options!");
		System.out.println("================================");
		System.out.println("\t 1.Insert");
		System.out.println("\t 2.Delete");
		System.out.println("\t 3.Display");
		System.out.println("\t 4.Clear HashTable");
		System.out.println("\t 5.Display Size");
		System.out.println("\t 6.Change Hashing Method");
		System.out.println("\t 7.END");
		System.out.println("================================");
		int choice = (Integer) scanInput();
		switch (choice) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			invokeHashingFunctions();
			break;
		case 7:
			System.out.println("Exiting Application. Thank you !");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Choice .... please choose from below.");
			choice = displayOperation();
		}
		return choice;
	}

}
