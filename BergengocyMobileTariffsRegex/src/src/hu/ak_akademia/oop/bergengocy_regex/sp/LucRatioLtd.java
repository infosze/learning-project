package src.hu.ak_akademia.oop.bergengocy_regex.sp;

import src.hu.ak_akademia.oop.bergengocy_regex.Duration;

class LucRatioLtd extends AbstractServiceProvider {

	private static final int PERMINUTE_FEE = 50;

	{
		companyName = "LukRáció Kft.";
		areaCode = "7";
		tariffType = "perc alapú";
	}

	@Override
	public String getTariffDescription() {
		return String.format("a díjszámítás %s, minden megkezdett perc díja %d peták", tariffType, PERMINUTE_FEE);
	}

	@Override
	public int calculateCallFee(Duration duration) {
		return duration.getStartedMinutes() * PERMINUTE_FEE;
	}

}
