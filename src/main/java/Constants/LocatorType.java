package Constants;

public class LocatorType {

	static String locatorType;

	public String cssSelector() {
		locatorType = "cssSelector";
		return locatorType;
	}

	public String id() {
		locatorType = "id";
		return locatorType;
	}
	
	public String theClass() {
		locatorType = "class";
		return locatorType;
	}
	
	public String xPath() {
		locatorType = "xpath";
		return locatorType;
	}
}
