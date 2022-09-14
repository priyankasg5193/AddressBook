package com.maveric.addressbook;


import java.util.List;

public class AddressBookDemo {
	static void printList(List<Contact> list) {
		for (Contact i : list) {
			System.out.println("Name: " + i.getName() + " Organisation: " + i.getOrganisation());
			System.out.println(i.getAddresses().toString());
			System.out.println(i.getPhoneNumbers().toString());

			System.out.println();

		}

	}

	public static void main(String[] args) throws LengthException {

		try {
			PhoneNumber p1 = new PhoneNumber();
			p1.setLabel("Work");
			p1.setPhoneNumber("9647865809");

			PhoneNumber p2 = new PhoneNumber();
			p2.setLabel("Home");
			p2.setPhoneNumber("9988776688");

			Address a1 = new Address();
			a1.setLabel("Home Address");
			a1.setAddress("Nashik");

			Address a2 = new Address();
			a2.setLabel("Office Address");
			a2.setAddress("Pune");

			Contact c1 = new Contact();
			c1.setName("Priyanka Gaikwad");
			c1.setOrganisation("Maveric");
			c1.addAddress(a1);
			c1.addAddress(a2);
			c1.addPhoneNumber(p2);
			c1.addPhoneNumber(p1);

			PhoneNumber p3 = new PhoneNumber();
			p3.setLabel("Work");
			p3.setPhoneNumber("8948494948");
			PhoneNumber p4 = new PhoneNumber();
			p4.setLabel("Home");
			p4.setPhoneNumber("7823749839");

			Address a3 = new Address();
			a3.setLabel("HOME");
			a3.setAddress("Pune");

			Address a4 = new Address();
			a4.setLabel("OFC");
			a4.setAddress("Pune");

			Contact c2 = new Contact();
			c2.setName("Manoj Raut");
			c2.setOrganisation("A&T");
			c2.addAddress(a3);
			c2.addAddress(a4);
			c2.addPhoneNumber(p3);
			c2.addPhoneNumber(p4);

			// adding to addressbook
			AddressBook addressBook = new AddressBook();
			addressBook.addContact(c1);
			addressBook.addContact(c2);

			// Printing if Contacts are present in contactList
			// List<Contact> contactList = addressBook.contactList;

//			printList(contactList);
			System.out.println(
					"====================================================================================================================");
			/*
			 * Testing Methods searchByName() searchByOrganisation() updateContact()
			 * deleteContact()
			 *
			 * //
			 */

			List<Contact> filteredList = addressBook.searchByName("Priya");
			System.out.println(
					"=====================================searchByName==================================================");
			printList(filteredList);

			List<Contact> filteredList1 = addressBook.searchByOrganisation("A&");
			System.out.println(
					"=====================================searchByOrganisation==================================================");
			printList(filteredList1);

			System.out.println(" ");
			System.out.println(" ");
			try {
				addressBook.updateContact("Manoj Raut", c2); // should throw exception

			} catch (Exception e) {
				System.out.println("Error while updating");
			}

			addressBook.updateContact("Manoj Anil Raut", c2); // works
			System.out.println(
					"======================================After Updating  Virat Kohli to KING======================================");
			printList(addressBook.contactList);

			addressBook.deleteContact("Priyanka Gaikwad");
			System.out.println(
					"======================================After Deleting Chandra sekhar======================================");
			printList(addressBook.contactList);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
