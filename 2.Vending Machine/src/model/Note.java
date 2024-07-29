package model;

public enum Note {
	ONE(1.00), FIVE(5.00), TEN(10.00), TWENTY(20.00), HUNDRED(100.00);

	private double value;

	Note(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}
}
