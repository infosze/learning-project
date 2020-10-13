package hu.ak_akademia.cf.club_members.v2;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public enum SortKey implements Comparator<Person> {

	LASTNAME("Vezetéknév: ", compareLastName()),
	LASTNAME_FIRSTNAME("Vezetéknév - Kersztnév: ", compareLastNameFirstName()),
	LASTNAME_BIRTHDATE("Vezetéknév - Születési dátum: ", compareLastNameBirthDate()),
	GRADE_ENROLLMENTDATE("Fokozat - Belépési dátum: ", compareGradeEnrollmentDate()),
	BIRTHDATE("Születési dátum: ", compareBirthDate()),
	BIRTHDATE_LASTNAME("Születési dátum - Vezetéknév: ", compareBirthDateLastName());

	private final Comparator<Person> comparator;
	private final String localName;
	private final static Collator COLLATOR = Collator.getInstance(new Locale("hu", "HU"));

	SortKey(String localName, Comparator<Person> comparator) {
		this.comparator = comparator;
		this.localName = localName;
	}

	public String getLocalName() {
		return localName;
	}

	private static Comparator<Person> compareLastName() {
		return new Comparator<>() {

			@Override
			public int compare(Person p1, Person p2) {
				return COLLATOR.compare(p1.getLastName(), p2.getLastName());
			}

		};
	}

	private static Comparator<Person> compareLastNameFirstName() {
		return new Comparator<>() {

			@Override
			public int compare(Person p1, Person p2) {
				int c = COLLATOR.compare(p1.getLastName(), p2.getLastName());
				return c != 0 ? c : COLLATOR.compare(p1.getFirstName(), p2.getFirstName());
			}

		};
	}

	private static Comparator<Person> compareLastNameBirthDate() {
		return new Comparator<>() {

			@Override
			public int compare(Person p1, Person p2) {
				int c = COLLATOR.compare(p1.getLastName(), p2.getLastName());
				return c != 0 ? c : p1.getBirthDate().compareTo(p2.getBirthDate());
			}

		};
	}

	private static Comparator<Person> compareGradeEnrollmentDate() {
		return new Comparator<>() {

			@Override
			public int compare(Person p1, Person p2) {
				int c = p1.getGrade().compareTo(p2.getGrade());
				return c != 0 ? c : p1.getEnrollmentDate().compareTo(p2.getEnrollmentDate());
			}

		};
	}

	private static Comparator<Person> compareBirthDate() {
		return new Comparator<>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getBirthDate().compareTo(p2.getBirthDate());
			}

		};
	}

	private static Comparator<Person> compareBirthDateLastName() {
		return new Comparator<>() {

			@Override
			public int compare(Person p1, Person p2) {
				int c = p1.getBirthDate().compareTo(p2.getBirthDate());
				return c != 0 ? c : COLLATOR.compare(p1.getLastName(), p2.getLastName());
			}

		};
	}

	@Override
	public int compare(Person p1, Person p2) {
		int c = comparator.compare(p1, p2);
		return c != 0 ? c : p1.getOrdinal() - p2.getOrdinal();
	}

}
