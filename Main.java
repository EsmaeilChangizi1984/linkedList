package LinkedList_Data;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		LinkedList<String>Cities = new LinkedList<String>();
		
		addInOrder(Cities,"Toronto");
		addInOrder(Cities,"Vancouver");
		addInOrder(Cities,"Montreal");
		addInOrder(Cities,"Calgary");
		addInOrder(Cities,"Manitoba");
		
		printList(Cities);
		
		
		//Cities.add(0,"Quebec-city");
		
		printList(Cities);
		
		addInOrder(Cities,"Quebec-City");
		addInOrder(Cities,"Quebec-City");
		
		//Cities.remove(3);
		
		printList(Cities);
		
		visit(Cities);
		
		
	}

	public static void printList(LinkedList<String> myLinkedList) {
		
		Iterator <String> i = myLinkedList.iterator();
		while(i.hasNext()) {
			System.out.println("Visiting "+i.next());
		}
		
		System.out.println("-------------------------------");
		
	}
	
	
	public static boolean addInOrder(LinkedList<String> myLinkedList,String newCity) {
		
		ListIterator<String> stringListIterator = myLinkedList.listIterator();
		
		while(stringListIterator.hasNext()) {
			int comparison = stringListIterator.next().compareTo(newCity);
			
			if(comparison == 0) {
				System.out.println(newCity +"already exist in the list.");
				return false;
			}
			else if(comparison > 0){
				stringListIterator.previous();
				stringListIterator.add(newCity);
				return true;
			}
			else if(comparison < 0) {
				//it will automatically moves to next city
	    	}	
		}
		stringListIterator.add(newCity);
		return true;
   }
	
	private static void visit(LinkedList cities) {
		
		Scanner scanner = new Scanner(System.in);
		boolean quit = false;
		boolean goingForward = true;
		
		ListIterator<String>listIterator = cities.listIterator();
		
		if(cities.isEmpty()) {
			System.out.println("No City in the itenerary");
			return;
		}else {
			System.out.println("Visiting "+listIterator.next());
			printMenu();
		}
		
		while(!quit) {
			
			int action = scanner.nextInt();
			scanner.nextLine();
			
			switch(action) {
			
			case 0:
				System.out.println("Vaocation Over!!!");
				quit = true;
				break;
			case 1:
				if(!goingForward) {
					if(listIterator.hasNext()) {
						listIterator.next();
					}
					goingForward = true;
				}
				if(listIterator.hasNext()) {
					System.out.println("Now visiting "+listIterator.next());
				}else {
					System.out.println("This is the end of the list");
					goingForward = false;
				}
				break;
			case 2:
				if(goingForward) {
					if(listIterator.hasPrevious()) {
						listIterator.previous();
					}
					goingForward = false;
					
				}
				if(listIterator.hasPrevious()) {
					System.out.println("Now visditing "+listIterator.previous());
				}else {
					System.out.println("We are at the top of the list.");
					goingForward = true;
				}
				break;
			case 3:
				printMenu();
				break;
				
			}
			
		}
		
		
	}
	
	private static void printMenu() {
		System.out.println("Available actions:\nPress");
		System.out.println("0-To Quit\n"+
		"1- Go to next city.\n"+
		"2-Go to previous city\n"+
		"3-To print Menu.");
	}
	
	
}
