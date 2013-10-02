package net.tmt.td.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import net.tmt.td.entity.GenericMinion;
import net.tmt.td.entity.Minion1Ground;
import net.tmt.td.util.DirectionPoint;
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
		directionPoints.add(new DirectionPoint(new Vector2d(400, 50),
				new Vector2d(0, 1)));
		directionPoints.add(new DirectionPoint(new Vector2d(400, 400),
				new Vector2d(-1, 0)));
		directionPoints.add(new DirectionPoint(new Vector2d(50, 400),
				new Vector2d(0, -1)));

		minions = new ArrayList<GenericMinion>();
		for (int i = 0; i < 4; i++)
			minions.add(new Minion1Ground(new Vector2d(50 + i * 60, 50)));

	}

	public void render(final Graphics g) {
		// g.drawImage...
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
