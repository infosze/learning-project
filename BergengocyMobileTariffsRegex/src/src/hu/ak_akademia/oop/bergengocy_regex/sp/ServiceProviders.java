package src.hu.ak_akademia.oop.bergengocy_regex.sp;

import src.hu.ak_akademia.oop.bergengocy_regex.ServiceProvider;

public class ServiceProviders {

	private static final ServiceProvider[] providers = { new VerboseCorp(), new LucRatioLtd(), new DecentTelecomCorp(), new RifrangerLtd() };

	public static ServiceProvider[] getProviders() {
		return providers;
	}

}
