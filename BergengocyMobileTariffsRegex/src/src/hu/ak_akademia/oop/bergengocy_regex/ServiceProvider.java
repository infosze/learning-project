package src.hu.ak_akademia.oop.bergengocy_regex;

/**
 * <b>Exercise: Bergengocy's Mobile Tariffs (Bergengóc mobiltelefon tarifák)</b>
 * <p>
 * Common interface for mobile service providers.
 *
 * @author A&amp;K Akadémia (Lajos Czuczor)
 */
public interface ServiceProvider {

	String getAreaCode();

	String getCompanyName();

	String getTariffDescription();

	int calculateCallFee(Duration duration);

}
