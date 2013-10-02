package net.tmt.td.game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;

import net.tmt.td.entity.Tower;
import net.tmt.td.util.ImageLoader;
import net.tmt.td.util.Vector2d;

import net.tmt.td.entity.GenericMinion;
import net.tmt.td.entity.Minion1Ground;

public class Game {
	public final static int				WIDTH	= 1024;
	public final static int				HEIGHT	= 640;
	private static Game					instance;

	public static List<GenericMinion>	minions	= null;

	private Game() {

	}

	public void tick() {
		MapLvl1.getInstance().tick();

	}

	public void render(final Graphics g) {
		// GenericTower gt = new GenericTower(new Vector2d(30, 30));
		// gt.render(g);

		MapLvl1.getInstance().render(g);
		drawMenu(g);
	}

	public static Game getInstance() {
		return instance;
	}

	public static void init() {
		instance = new Game();
	}

	// will end up in a menu class in the end, for now — quick and dirty
	// drawing
	private void drawMenu(final Graphics g) {
		Vector2d menuPos = new Vector2d(50, 560);
		int gap = 70;
		BufferedImage images[] = { ImageLoader.tower_cool,
				ImageLoader.tower_damage, ImageLoader.tower_fire,
				ImageLoader.tower_magic };
		for (int i = 0; i < 4; i++) {
			g.drawImage(images[i],
					(int) (menuPos.x + gap * i - (Tower.WIDTH / 2)),
					(int) (menuPos.y - (Tower.HEIGHT / 2)), null);
		}
	}
}
