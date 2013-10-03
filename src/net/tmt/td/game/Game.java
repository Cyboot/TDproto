package net.tmt.td.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import net.tmt.td.entity.DamageTower;
import net.tmt.td.entity.GenericMinion;
import net.tmt.td.entity.Shot;
import net.tmt.td.entity.Tower;
import net.tmt.td.util.ImageLoader;
import net.tmt.td.util.Vector2d;

public class Game {
	public final static int	WIDTH	= 1024;
	public final static int	HEIGHT	= 640;
	private static Game		instance;
	ArrayList<Tower>		towers	= new ArrayList<Tower>();
	ArrayList<Shot>			shots	= new ArrayList<Shot>();
	List<GenericMinion>		mobs	= new ArrayList<GenericMinion>();

	private Game() {
		towers.add(new DamageTower(new Vector2d(125, 185)));
	}

	public ArrayList<Shot> getShots() {
		return shots;
	}

	public void registerShot(final Tower origin, final GenericMinion target) {
		shots.add(new Shot(origin, target));
	}

	public void tick() {
		MapLvl1.getInstance().tick();
		mobs = MapLvl1.getInstance().getMinions();
		for (Tower t : towers) {
			t.shoot(mobs);
		}
		for (Shot s : shots) {
			if (s.isAlive()) // TODO: remove instead of ignore
				s.tick();
		}
	}


	public void render(final Graphics g) {
		for (Tower t : towers) {
			t.render(g);
		}
		for (Shot s : shots) {
			if (s.isAlive())
				s.render(g);
		}
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
		BufferedImage images[] = { ImageLoader.tower_cool, ImageLoader.tower_damage, ImageLoader.tower_fire,
				ImageLoader.tower_magic };
		for (int i = 0; i < 4; i++) {
			g.drawImage(images[i], (int) (menuPos.x + gap * i - (Tower.WIDTH / 2)),
					(int) (menuPos.y - (Tower.HEIGHT / 2)), null);
		}

		g.drawString("Health: " + Integer.toString(Player.getInstance().getHealth()), (int) menuPos.x + 280,
				(int) menuPos.y - 20);

		g.drawString("Coins:  " + Integer.toString(Player.getInstance().getCoins()), (int) menuPos.x + 280,
				(int) menuPos.y + 20);
	}
}
