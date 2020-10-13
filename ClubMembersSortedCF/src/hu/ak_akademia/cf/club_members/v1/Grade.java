package hu.ak_akademia.cf.club_members.v1;

enum Grade {

	NOVICE("kezdő"),
	INTERMEDIATE("középhaladó"),
	PROFICIENT("haladó"),
	MASTER("profi");

	private final String localName;

	Grade(String name) {
		this.localName = name;
	}

	public String getGradeName() {
		return localName;
	}

}
