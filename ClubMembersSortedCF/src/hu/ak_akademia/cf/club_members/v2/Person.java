package hu.ak_akademia.cf.club_members.v2;

import java.time.LocalDate;
import java.util.Objects;

class Person {

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
	public int hashCode() {
		return Objects.hash(birthDate, enrollmentDate, firstName, grade, lastName, ordinal, residence);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(enrollmentDate, other.enrollmentDate)
				&& Objects.equals(firstName, other.firstName) && grade == other.grade && Objects.equals(lastName, other.lastName)
				&& ordinal == other.ordinal && Objects.equals(residence, other.residence);
	}

}
