package com.manzano.data;

public enum Choice {
	ROCK(0, "Rock"), PAPER(1, "Paper"), SCISSORS(2, "Scissors");

	private int choiceCode;
	private String choiceDescription;

	private Choice(int choiceCode, String choiceDescription) {
		this.choiceCode = choiceCode;
		this.choiceDescription = choiceDescription;
	}

	public int getChoiceCode() {
		return choiceCode;
	}

	public String getChoiceDescription() {
		return choiceDescription;
	}
}
