package com.manzano.data;

public class Player {
	private String playerName;
	private Choice choice;
	private boolean wins;

	public Player(String name) {
		this(name, Choice.ROCK);
	}

	public Player(String name, Choice choice) {
		this.playerName = name;
		this.choice = choice;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Choice getChoice() {
		return choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	}

	public boolean hasWon() {
		return wins;
	}

	public void setWins(boolean wins) {
		this.wins = wins;
	}
}
