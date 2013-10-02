package net.tmt.td.game;

public class Player {

	private static Player	instance	= null;
	private int				health;
	private int				coins;

	private Player() {
		health = 100;
		coins = 100;
	}

	public static void init() {
		instance = new Player();
	}

	public static Player getInstance() {
		return instance;
	}

	public int getHealth() {
		return health;
	}

	public int getCoins() {
		return coins;
	}

	// TODO: better name/solution? i did not want to make 2 mehtods increasCoin
	// und
	// decreaseCoin...
	public void changeCoinValueto(final int value) {
		coins += value;
	}

	public void changeHealthValueTo(final int value) {
		health += value;
		if (health <= 0) {

		}

	}
}
