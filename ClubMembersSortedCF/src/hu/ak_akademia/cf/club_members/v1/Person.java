package hu.ak_akademia.cf.club_members.v1;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Locale;

class Person implements Comparable<Person> {

	private static final Collator COLLATOR = Collator.getInstance(new Locale("hu", "HU"));

	private static int ordinalSource = 0;
	private int ordinal;
	private String lastName;
	private String firstName;
	private LocalDate birthDate;
	private Residence residence;
	private LocalDate enrollmentDate;
	private Grade grade;

	public Person() {
		this.ordinal = ordinalSource++;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setResidence(Residence residence) {
		this.residence = residence;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public int getOrdinal() {
		return ordinal;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Residence getResidence() {
		return residence;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public Grade getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return lastName + " " + firstName + " - " + grade.getGradeName();
	}

	@Override
	public int compareTo(Person p) {
		int c = COLLATOR.compare(this.lastName, p.lastName);
		return c != 0 ? c : this.ordinal - p.ordinal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((enrollmentDate == null) ? 0 : enrollmentDate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ordinal;
		result = prime * result + ((residence == null) ? 0 : residence.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (enrollmentDate == null) {
			if (other.enrollmentDate != null)
				return false;
		} else if (!enrollmentDate.equals(other.enrollmentDate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (grade != other.grade)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (ordinal != other.ordinal)
			return false;
		if (residence == null) {
			if (other.residence != null)
				return false;
		} else if (!residence.equals(other.residence))
			return false;
		return true;
	}

}
