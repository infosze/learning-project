package hu.ak_akademia.cf.club_members.v1;

import java.util.Objects;

class Residence {

	private int zipCode;
	private String city;
	private String address;

	public Residence(int zipCode, String city, String adress) {
		this.zipCode = validateZipCode(zipCode);
		this.city = city;
		this.address = adress;
	}

	public int getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String getAdress() {
		return address;
	}

	private int validateZipCode(int zipCode) {
		if (zipCode < 1000 || zipCode > 9999) {
			throw new IllegalArgumentException("Kérem, megfelelő irányítószámot adjon meg!");
		} else {
			return zipCode;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, city, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Residence))
			return false;
		Residence other = (Residence) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city) && zipCode == other.zipCode;
	}

}
