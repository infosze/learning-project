package hu.ak_akademia.cf.club_members.v1;

import java.util.SortedSet;
import java.util.TreeSet;

class Members {

	private SortedSet<Person> members = new TreeSet<>();

	public Members() {
	}

	boolean add(Person p) {
		return members.add(p);
	}

	boolean remove(Person p) {
		return members.remove(p);
	}

	boolean contains(Person p) {
		return members.contains(p);
	}

	int size() {
		return members.size();
	}

	boolean isEmpty() {
		return members.isEmpty();
	}

	void clear() {
		members.clear();
	}

	@Override
	public String toString() {
		return members.toString().replace("[", "").replace("]", "").replace(",", ";");
	}

}
