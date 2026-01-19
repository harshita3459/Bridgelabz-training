package adress_book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookContact {
	
	// UC : 1 (Model Layer)
	
	static class Contacts{
		private String firstName;
		private String lastName;
		private String city;
		private String address;
		private String state;
		private String email;
		private String phoneNumber;
		private String zip;
		
		Contacts(String firstName, String lastName, String address, String city, String state, String email, String phoneNumber, String zip){
			this.setFirstName(firstName);
			this.lastName= lastName;
			this.address = address;
			this.city= city;
			this.state = state;
			this.email= email;
			this.phoneNumber = phoneNumber;
			this.zip = zip;
		}
		
		@Override
	    public String toString() {
	        return "\nContact Details" +
	                "\nFirst Name   : " + getFirstName() +
	                "\nLast Name    : " + lastName +
	                "\nAddress      : " + address +
	                "\nCity         : " + city +
	                "\nState        : " + state +
	                "\nEmail          : " + email +
	                "\nPhone Number : " + phoneNumber +
	                "\nZip        : " + zip;
	    }
		
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		static class AddressBook {
	        private final List<Contacts> contacts = new ArrayList<>();
	        private final Scanner scanner = new Scanner(System.in);

	        public void addContact() {
	            System.out.print("Enter First Name: ");
	            String firstName = scanner.nextLine();

	            System.out.print("Enter Last Name: ");
	            String lastName = scanner.nextLine();

	            System.out.print("Enter City: ");
	            String city = scanner.nextLine();

	            System.out.print("Enter Address: ");
	            String address = scanner.nextLine();

	            System.out.print("Enter State: ");
	            String state = scanner.nextLine();

	            System.out.print("Enter Email: ");
	            String zip = scanner.nextLine();

	            System.out.print("Enter Phone Number: ");
	            String phoneNumber = scanner.nextLine();

	            System.out.print("Enter Zip: ");
	            String email = scanner.nextLine();

	            Contacts contact = new Contacts(firstName, lastName, address,city, state, zip, phoneNumber, email);
	            contacts.add(contact);
	            System.out.println("\nContact added successfully!");
	        }

	        public void displayContacts() {
	            System.out.println("\nAddress Book");
	            for(Contacts contact : contacts) {
	                System.out.println(contact);
	            }
	        }
	    }
	}
}
