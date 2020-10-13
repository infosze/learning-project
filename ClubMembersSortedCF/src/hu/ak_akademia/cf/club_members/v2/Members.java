package hu.ak_akademia.cf.club_members.v2;

import java.util.SortedSet;
import java.util.TreeSet;

class Members {

	private SortedSet<Person> members;
	private String sortName;

	public Members() {
		this(SortKey.LASTNAME);
	}

	public Members(SortKey sk) {
		sortName = sk.getLocalName();
		members = new TreeSet<>(sk);
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

	void setSortKey(SortKey sk) {
		sortName = sk.getLocalName();
		SortedSet<Person> mem = new TreeSet<>(sk);
		mem.addAll(members);
		this.members = mem;
	}

	@Override
	public String toString() {
		return sortName + members.toString().replace("[", "").replace("]", "").replace(",", ";");
	}

}
