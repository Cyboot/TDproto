package net.tmt.td.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import net.tmt.td.entity.DirectionPoint;
import net.tmt.td.entity.GenericMinion;
import net.tmt.td.entity.Minion1Ground;
import net.tmt.td.util.Vector2d;

public class MapLvl1 {

	private static MapLvl1							instance		= null;

	private static BufferedImage					img;
	public static java.util.List<DirectionPoint>	directionPoints	= null;
	public static java.util.List<GenericMinion>		minions			= null;

	private MapLvl1() {

		// img = ImageLoader.getSubImage(img, x, y, width)
		directionPoints = new ArrayList<>(4);
		directionPoints.add(new DirectionPoint(new Vector2d(50, 50),
				new Vector2d(1, 0)));
		directionPoints.add(new DirectionPoint(new Vector2d(600, 50),
				new Vector2d(0, 1)));
		directionPoints.add(new DirectionPoint(new Vector2d(600, 450),
				new Vector2d(-1, 0)));
		directionPoints.add(new DirectionPoint(new Vector2d(50, 450),
				new Vector2d(0, -1)));

		minions = new ArrayList<GenericMinion>();
		for (int i = 0; i < 7; i++)
			minions.add(new Minion1Ground(new Vector2d(50 + i * 5, 50)));

		for (int i = 0; i < 7; i++)
			minions.add(new Minion1Ground(new Vector2d(40 + i * 5, 70)));

	}

	public void render(final Graphics g) {
		// g.drawImage...
		for (DirectionPoint dp : directionPoints)
			dp.render(g);
		for (GenericMinion gm : minions)
			gm.render(g);
	}

	public void tick() {

		for (DirectionPoint dp : directionPoints)
			dp.tick();

		for (GenericMinion gm : minions)
			gm.tick();
	}

	public static MapLvl1 getInstance() {
		return instance;
	}

	public static void init() {
		instance = new MapLvl1();
	}

	public java.util.List<GenericMinion> getMinions() {
		return minions;
	}
}
