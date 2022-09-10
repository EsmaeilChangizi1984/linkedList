package LinkedList_Data;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.*;

public class Main_Album {
	

	public static void main(String[] args) {
		
		ArrayList<Album> albums = new ArrayList<Album>();
		
		Album album = new Album("Hello from world","Alvez");
		album.addSong("Rier",3.45);
		album.addSong("Rock", 7.45);
		album.addSong("Lovely", 2.12);
		album.addSong("TakeCare", 5.45);
		
		albums.add(album);
		
		Album secondAlbum = new Album("Hello fro Java","Justin");
		secondAlbum.addSong("Spring", 3.45);
		secondAlbum.addSong("Hibernate", 6.6);
		secondAlbum.addSong("JDBC",4.56);
		
		albums.add(secondAlbum);
		
		LinkedList<Song>myList = new LinkedList<Song>();
		albums.get(0).addToPlayList("Rier", myList);
		albums.get(0).addToPlayList("Rock", myList);
		albums.get(0).addToPlayList("Lovely", myList);
		
		albums.get(1).addToPlayList(1, myList);
		albums.get(1).addToPlayList(3, myList);
		albums.get(1).addToPlayList(2, myList);
		
		Show(myList);
		
		

	}
	
	
	private static void  Show(LinkedList<Song> myList) {
		
		Scanner scanner = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		
		ListIterator <Song>listIterator = myList.listIterator();
		
		if(myList.size() == 0) {
			System.out.println("There is not song in the album");
		}else {
			System.out.println("Now playng "+listIterator.next().toString());
			printMenu();
		}
		
		while(!quit) {
			int action = scanner.nextInt();
			scanner.nextLine();
			
			switch(action) {
			case 0:
				System.out.println("Playlist complete.");
				quit  =true;
				break;
			case 1:
				if(!forward) {
					if(listIterator.hasNext()) {
						listIterator.next();
					}
					forward = true;
				}
				if(listIterator.hasNext()) {
					System.out.println("Now playing "+listIterator.next().toString());
				}else {
					System.out.println("We have reached the end of list");
					forward = false;
				}
				break;
				
			case 2:
				if(forward) {
					if(listIterator.hasPrevious()) {
						listIterator.previous();
					}
					forward = false;
				}
				if(listIterator.hasPrevious()) {
					System.out.println("Now playing "+listIterator.previous().toString());
				}else {
					System.out.println("We are at the start of the play list.");
					forward = true;
				}
				break;
				
			case 3:
				if(forward) {
					if(listIterator.hasPrevious()) {
						System.out.println("Now playing "+listIterator.previousIndex());
						forward =false;
					}else {
						System.out.println("We are at the start of the list.");
					}
						
					}else {
						if(listIterator.hasNext()) {
							System.out.println("Now playin "+listIterator.next());
							forward = true;
						}else {
							System.out.println("We reached at the end of the list.");
						}
				}
				break;
				
			case 4:
				printList (myList);
			case 5:
				printMenu();
				
			case 6:
				if(myList.size() > 0) {
					listIterator.remove();
					if(listIterator.hasNext()) {
						System.out.println("Now playing "+listIterator.next());
					}else if(listIterator.hasPrevious()) {
						System.out.println("Now playyin "+listIterator.previous());
					}
				}
				
			}
			
		}
		
	}	
	
	public static void printMenu() {
		System.out.println("Available options :\n press");
		System.out.println("0-To quot\n"+
		"1-To play next song\n"+
		"2-To play previous song\n"+
		"3-To replay the current song\n"+
		"4-To list songs in the play list\n"+
		"5-To print available options.\n"+
		"6-To delete current song from play list");
	}
	
	private static void printList(LinkedList<Song> myList) {
		Iterator<Song> iterate = myList.iterator();
		
		System.out.println("--------------------------------------------------------");
		while(iterate.hasNext()) {
			System.out.println(iterate.next());
		}
		System.out.println("----------------------------------------------------------");
	}
	

}
