package net.tmt.td.game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import net.tmt.td.entity.GenericMinion;
import net.tmt.td.entity.GenericTower;
import net.tmt.td.entity.Minion1Ground;
import net.tmt.td.util.Vector2d;

public class Game {
	public final static int WIDTH = 1024;
	public final static int HEIGHT = 640;
	private static Game instance;

	public static List<GenericMinion> minions = null;

//	 Minion1Ground mg = new Minion1Ground(new Vector2d(50, 50));

	private Game() {

	}

	public void tick() {
		MapLvl1.getInstance().tick();

//		 mg.tick();
	}

	public void render(final Graphics g) {
		// GenericTower gt = new GenericTower(new Vector2d(30, 30));
		// gt.render(g);
		MapLvl1.getInstance().render(g);

//		 mg.render(g);
	}

	public static Game getInstance() {
		return instance;
	}

	public static void init() {
		instance = new Game();
	}
}
