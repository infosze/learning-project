package hu.ak_akademia.cf.club_members.v1;

import static hu.ak_akademia.cf.club_members.v1.Grade.*;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Locale;

public class Main {

	Comparator<Person> comparelastName = new Comparator<>() {

		private final Collator collator = Collator.getInstance(new Locale("hu", "HU"));

		@Override
		public int compare(Person p1, Person p2) {
			int c = collator.compare(p1.getLastName(), p2.getLastName());
			return c != 0 ? c : p1.getOrdinal() - p2.getOrdinal();
		}

	};

	public static void main(String[] args) {
		Main main = new Main();
		main.test();
	}

	void test() {
		Members members = new Members();

		Person person1 = new Person();
		person1.setLastName("Kovács");
		person1.setFirstName("János");
		person1.setBirthDate(LocalDate.of(1972, 6, 25));
		person1.setResidence(new Residence(1043, "Budapest", "Béke út 14."));
		person1.setEnrollmentDate(LocalDate.of(2020, 9, 4));
		person1.setGrade(INTERMEDIATE);

		Person person2 = new Person();
		person2.setLastName("Kovács");
		person2.setFirstName("Béla");
		person2.setBirthDate(LocalDate.of(1972, 6, 25));
		person2.setResidence(new Residence(1043, "Budapest", "Béke út 14."));
		person2.setEnrollmentDate(LocalDate.of(2020, 9, 4));
		person2.setGrade(NOVICE);

		Person person3 = new Person();
		person3.setLastName("Tóth");
		person3.setFirstName("Krisztina");
		person3.setBirthDate(LocalDate.of(1976, 11, 3));
		person3.setResidence(new Residence(1132, "Budapest", "Váci út 132."));
		person3.setEnrollmentDate(LocalDate.of(2020, 6, 15));
		person3.setGrade(PROFICIENT);

		Person person4 = new Person();
		person4.setLastName("Farkas");
		person4.setFirstName("Dávid");
		person4.setBirthDate(LocalDate.of(1980, 3, 9));
		person4.setResidence(new Residence(1032, "Budapest", "Kis utca 3"));
		person4.setEnrollmentDate(LocalDate.of(2019, 2, 28));
		person4.setGrade(NOVICE);

		Person person5 = new Person();
		person5.setLastName("Nagy");
		person5.setFirstName("Andrea");
		person5.setBirthDate(LocalDate.of(1968, 4, 17));
		person5.setResidence(new Residence(2151, "Fót", "Balassa utca 24"));
		person5.setEnrollmentDate(LocalDate.of(2020, 6, 15));
		person5.setGrade(MASTER);

		Person person6 = new Person();
		person6.setLastName("Lovas");
		person6.setFirstName("János");
		person6.setBirthDate(LocalDate.of(1972, 5, 25));
		person6.setResidence(new Residence(1043, "Budapest", "Béke út 14."));
		person6.setEnrollmentDate(LocalDate.of(2020, 9, 4));
		person6.setGrade(INTERMEDIATE);

		Person person7 = new Person();
		person7.setLastName("Nagy");
		person7.setFirstName("Géza");
		person7.setBirthDate(LocalDate.of(1965, 5, 16));
		person7.setResidence(new Residence(1221, "Budapest", "Káva utca 7."));
		person7.setEnrollmentDate(LocalDate.of(2019, 3, 24));
		person7.setGrade(MASTER);

		Person person8 = new Person();
		person8.setLastName("Szép");
		person8.setFirstName("Irén");
		person8.setBirthDate(LocalDate.of(1986, 2, 12));
		person8.setResidence(new Residence(2152, "Dunakeszi", "Kanyargós utca 72"));
		person8.setEnrollmentDate(LocalDate.of(2019, 11, 6));
		person8.setGrade(PROFICIENT);

		Person person9 = new Person();
		person9.setLastName("Éles");
		person9.setFirstName("Lajos");
		person9.setBirthDate(LocalDate.of(1978, 12, 30));
		person9.setResidence(new Residence(1215, "Budapest", "Külső utca 31."));
		person9.setEnrollmentDate(LocalDate.of(2019, 3, 24));
		person9.setGrade(INTERMEDIATE);

		Person person10 = new Person();
		person10.setLastName("Erdős");
		person10.setFirstName("Marianna");
		person10.setBirthDate(LocalDate.of(1991, 8, 30));
		person10.setResidence(new Residence(4523, "Nagykér", "Fő utca 44"));
		person10.setEnrollmentDate(LocalDate.of(2019, 10, 21));
		person10.setGrade(NOVICE);

		members.add(person1);
		members.add(person2);
		members.add(person3);
		members.add(person4);
		members.add(person5);
		members.add(person6);
		members.add(person7);
		members.add(person8);
		members.add(person9);
		members.add(person10);

		System.out.println(members.toString());
	}

}
