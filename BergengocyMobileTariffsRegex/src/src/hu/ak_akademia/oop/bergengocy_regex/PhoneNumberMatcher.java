package src.hu.ak_akademia.oop.bergengocy_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import src.hu.ak_akademia.oop.bergengocy_regex.sp.ServiceProviders;

class PhoneNumberMatcher {

	private static final String PREFIXES = "(?:(?:00|\\+)355|06)?";
	private static final String PHONE_NUMBER = "\\d{5,7}";
	private Pattern phoneNumberRegex = Pattern.compile(createRegex());

	int getProviderIndex(String rawPhoneNumber) {
		String cleanedPhoneNumber = rawPhoneNumber.replaceAll("[ \\(\\)\\-]", "");
		Matcher goodPhoneNumber = phoneNumberRegex.matcher(cleanedPhoneNumber);
		if (goodPhoneNumber.matches()) {
			for (int i = 1; i < goodPhoneNumber.groupCount() + 1; i++) {
				if (goodPhoneNumber.group(i) != null) {
					return i - 1;
				}
			}
		}
		throw new RuntimeException("A megadott telefonszám Bergengóciában nem mobilszám!");
	}

	private String createRegex() {
		StringBuilder buildedRegex = new StringBuilder();
		for (ServiceProvider p : ServiceProviders.getProviders()) {
			buildedRegex.append("|(").append(p.getAreaCode()).append(")");
		}
		buildedRegex.deleteCharAt(0);
		buildedRegex.insert(0, "(?:").append(")");
		buildedRegex.insert(0, PREFIXES).append(PHONE_NUMBER);
		return buildedRegex.toString();
	}

}
