package src.hu.ak_akademia.oop.bergengocy_regex.sp;

import src.hu.ak_akademia.oop.bergengocy_regex.ServiceProvider;

abstract class AbstractServiceProvider implements ServiceProvider {

	String companyName;
	String areaCode;
	String tariffType;

	@Override
	public String getCompanyName() {
		return companyName;
	}

	@Override
	public String getAreaCode() {
		return areaCode;
	}

}
