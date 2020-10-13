package src.hu.ak_akademia.oop.bergengocy_regex.sp;

import src.hu.ak_akademia.oop.bergengocy_regex.Duration;
import src.hu.ak_akademia.oop.bergengocy_regex.ServiceProvider;

class RifrangerLtd extends AbstractServiceProvider {

	private static final double PLUS_PERCENT = 8d;

	private static ServiceProvider[] otherProviders;

	{
		companyName = "Rifranger Kft.";
		areaCode = "99";
		tariffType = "a többi szolgáltatóétól függ";
	}

	private static ServiceProvider[] getOtherProviders() {
		if (otherProviders == null) {
			otherProviders = new ServiceProvider[ServiceProviders.getProviders().length - 1];
			int i = 0;
			for (ServiceProvider sp : ServiceProviders.getProviders()) {
				if (!(sp instanceof RifrangerLtd)) {
					otherProviders[i++] = sp;
				}
			}
		}
		return otherProviders;
	}

	@Override
	public String getTariffDescription() {
		return String.format("a díjszámítás %s, a hívás díja a mindenkori legalacsonyabb díj + %.1f%% felár", tariffType, PLUS_PERCENT);
	}

	@Override
	public int calculateCallFee(Duration duration) {
		int lowestCallFee = Integer.MAX_VALUE;
		for (ServiceProvider p : getOtherProviders()) {
			lowestCallFee = Math.min(p.calculateCallFee(duration), lowestCallFee);
		}
		return (int) Math.round(lowestCallFee * (PLUS_PERCENT + 100) / 100);
	}

}
