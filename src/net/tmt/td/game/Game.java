package net.tmt.td.game;

import java.awt.Graphics;


public class Game {
	public final static int	WIDTH	= 1024;
	public final static int	HEIGHT	= 640;
	private static Game		instance;

	private Game() {
	}


	public void tick() {
	}

	public void render(final Graphics g) {
	}


	public static Game getInstance() {
		return instance;
	}

	public static void init() {
		instance = new Game();
	}
}
