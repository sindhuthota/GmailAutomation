package com.ebasetek.qa.core;

public enum Browser {

	CHROME("chrome"), IE("IE"), FIREFOX("FireFox");

	private final String value;

	private Browser(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String toString() {
		return getValue();
	}

}
