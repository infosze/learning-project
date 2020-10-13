package src.hu.ak_akademia.oop.bergengocy_regex;

import java.util.Scanner;

import src.hu.ak_akademia.oop.bergengocy_regex.sp.ServiceProviders;

/**
 * <b>Exercise: Bergengocy's Mobile Tariffs (Bergengóc mobiltelefon tarifák)</b>
 * <p>
 * The main program.
 *
 * @author A&amp;K Akadémia (Lajos Czuczor)
 */
public class Main {

	public static void main(String[] args) {
		try {
			new Main().run();
		} catch (RuntimeException e) {
			System.err.println(e.getMessage());
		}
	}

	private final Scanner scanner = new Scanner(System.in);

	private void run() {
		PhoneNumberMatcher phoneNumberMatcher = new PhoneNumberMatcher();
		Duration duration = inputCallDuration("Add meg a hívás időtartamát (<perc>:<másodperc>): ");
		String phoneNumber = inputPhoneNumber("Add meg a telefonszámot (a körzetszámtól kezdve, vagy távhívás előhívókkal): ");
		scanner.close();
		int providerIndex = phoneNumberMatcher.getProviderIndex(phoneNumber);
		ServiceProvider provider = ServiceProviders.getProviders()[providerIndex];
		ServiceProvider optimumProvider = identifyOptimumProvider(duration);
		printResult(duration, provider, optimumProvider);
	}

	private Duration inputCallDuration(String prompt) {
		int minutes = 0;
		int seconds = 0;
		System.out.print(prompt);
		String[] duration = scanner.nextLine().split(":");
		if (duration.length != 2)
			throw new RuntimeException("A megadott időformátum nem értelmezhető!");
		try {
			minutes = Integer.parseInt(duration[0].strip());
			seconds = Integer.parseInt(duration[1].strip());
		} catch (NumberFormatException e) {
			throw new RuntimeException("A megadott időtartam nem értelmezhető!");
		}
		return new Duration(minutes, seconds);
	}

	private String inputPhoneNumber(String prompt) {
		System.out.print(prompt);
		String phoneNumber = scanner.nextLine();
		return phoneNumber;
	}

	private ServiceProvider identifyOptimumProvider(Duration duration) {
		ServiceProvider optimumProvider = null;
		int lowestCallFee = Integer.MAX_VALUE;
		for (ServiceProvider p : ServiceProviders.getProviders()) {
			if (p.calculateCallFee(duration) < lowestCallFee) {
				lowestCallFee = p.calculateCallFee(duration);
				optimumProvider = p;
			}
		}
		return optimumProvider;
	}

	private void printResult(Duration duration, ServiceProvider provider, ServiceProvider optimumProvider) {
		System.out.printf("A hívást a %s bonyolította le, díja %d peták (%s)%n", provider.getCompanyName(), provider.calculateCallFee(duration),
				provider.getTariffDescription());
		System.out.printf(
				provider.getCompanyName().equals(optimumProvider.getCompanyName()) ? "A megadott idejű hívásra a %s az optimális szolgáltató."
						: "A megadott idejű hívásra az optimális szolgáltató a %s lenne, az ő díjuk csak %d peták.",
				optimumProvider.getCompanyName(), optimumProvider.calculateCallFee(duration));
	}

}
