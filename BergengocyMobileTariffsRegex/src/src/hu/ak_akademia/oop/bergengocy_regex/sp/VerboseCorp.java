package src.hu.ak_akademia.oop.bergengocy_regex.sp;

import src.hu.ak_akademia.oop.bergengocy_regex.Duration;

class VerboseCorp extends AbstractServiceProvider {

	private static final int FIX_TARIF = 300;

	{
		companyName = "Fecsegtető Telekom Zrt.";
		areaCode = "21";
		tariffType = "hívás alapú";
	}

	@Override
	public String getTariffDescription() {
		return String.format("a díjszámítás %s, a hívás díja időtartamtól függetlenűl %d peták", tariffType, FIX_TARIF);
	}

	@Override
	public int calculateCallFee(Duration duration) {
		return FIX_TARIF;
	}

}
