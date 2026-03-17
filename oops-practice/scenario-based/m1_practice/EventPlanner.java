package m1_practice;
import java.util.*;

abstract class Festival{
	String name, location;
	int date;
	
	Festival(String name, String location, int date){
		this.name = name;
		this.location = location;
		this.date = date;
	}
	
	abstract void displayDetails();
}

class MusicFestival extends Festival{
	String headliner, genre;
	int ticketPrice;
	
	MusicFestival(String name, String location, int date, String headliner, String genre, int ticketPrice){
		super(name,location,date);
		this.headliner = headliner;
		this.genre = genre;
		this.ticketPrice = ticketPrice;
	}
	
	void displayDetails() {
		System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Headliner: " + headliner);
        System.out.println("Music Genre: " + genre);
        System.out.println("Ticket Price: " + ticketPrice);
	}
}

class FoodFestival extends Festival{
	String cuisine;
	int numStalls, entryFee;
	
	FoodFestival(String name, String location, int date, String cuisine, int numStalls, int entryFee){
		super(name,location,date);
		this.cuisine = cuisine;
		this.numStalls = numStalls;
		this.entryFee = entryFee;
	}
	
	void displayDetails() {
		System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Cuisine: " + cuisine);
        System.out.println("Number of Stalls: " + numStalls);
        System.out.println("Entry Fee: " + entryFee);
	}
}

class ArtFestival extends Festival{
	String artType;
	int numArtist, exhibitionFee;
	
	ArtFestival(String name, String location, int date, String artType, int numArtist, int exibitionFee){
		super(name,location,date);
		this.artType = artType;
		this.numArtist = numArtist;
		this.exhibitionFee = exibitionFee;
	}
	
	void displayDetails() {
		System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Art Type: " + artType);
        System.out.println("Number of Artists: " + numArtist);
        System.out.println("Exhibition Fee: " + exhibitionFee);
	}
}

public class EventPlanner {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Festival> map = new HashMap<>();
		while(true) {
			String line = sc.nextLine();
			if(line.equals("EXIT")) {
				break;
			}
			String[] parts = line.split(" ");
			if(line.equals("ADD_FESTIVAL")) {
				String type = parts[1];
				if(type.equals("MUSIC")) {
					map.put(parts[2], new MusicFestival(parts[2],parts[3],Integer.parseInt(parts[4]),parts[5],parts[6],Integer.parseInt(parts[7])));
				}else if(type.equals("FOOD")) {
					map.put(parts[2], new FoodFestival(parts[2], parts[3],Integer.parseInt(parts[4]), parts[5],Integer.parseInt(parts[6]),Integer.parseInt(parts[7])));
				}else if(type.equals("ARTS")) {
					map.put(parts[2], new ArtFestival(parts[2],parts[3], Integer.parseInt(parts[4]), parts[5], Integer.parseInt(parts[6]), Integer.parseInt(parts[7])));
				}else if (parts[0].equals("DISPLAY_DETAILS")) {
	                String name = parts[1];
	                if(map.containsKey(name)) {
	                    map.get(name).displayDetails();
	                }
				}
			}
		}
	}
}
