package com.maveric.addressbook;


import java.util.ArrayList;
import java.util.List;

public class Contact {
	private String name;
	private String organisation;
	private List<PhoneNumber> phoneNumList = new ArrayList<PhoneNumber>();
	private List<Address> addressList = new ArrayList<Address>();

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public void setName(String name) throws LengthException {
		if (name.length() != 0 && name.length() <= 255) {
			this.name = name;
		} else {
			throw new LengthException("Invalid name, length should be in the range of (1..255)");
		}
	}

	// added setters
	public String getName() {
		return name;
	}

	public String getOrganisation() {
		return organisation;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumList;
	}

	public List<Address> getAddresses() {
		return addressList;
	}

	public void addPhoneNumber(PhoneNumber number) {
		phoneNumList.add(number);
	}

	public void addAddress(Address addres) {
		addressList.add(addres);
	}

}
