package src.hu.ak_akademia.oop.bergengocy_regex.sp;

import src.hu.ak_akademia.oop.bergengocy_regex.Duration;

class DecentTelecomCorp extends AbstractServiceProvider {

	private static final int BREAKPOINT_TIME = 120; // limit break in second
	private static final double TARIFF_BIFORE = 1.5d; // before break point
	private static final double TARIFF_AFTER = 0.5d; // after break point

	{
		companyName = "Decens Távközlési Zrt.";
		areaCode = "876";
		tariffType = "másodperc alapú";
	}

	@Override
	public String getTariffDescription() {
		return String.format("a díjszámítás %s, %d másodpercig %.2f peták, majd %.2f peták", tariffType, BREAKPOINT_TIME, TARIFF_BIFORE,
				TARIFF_AFTER);
	}

	@Override
	public int calculateCallFee(Duration duration) {
		int totalSecond = duration.getTotalSecond();
		double fee;
		if (totalSecond <= BREAKPOINT_TIME) {
			fee = totalSecond * TARIFF_BIFORE;
		} else {
			fee = BREAKPOINT_TIME * TARIFF_BIFORE + (totalSecond - BREAKPOINT_TIME) * TARIFF_AFTER;
		}
		return (int) Math.round(fee);
	}

}
