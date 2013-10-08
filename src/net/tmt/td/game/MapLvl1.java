package net.tmt.td.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import net.tmt.td.entity.DirectionPoint;
import net.tmt.td.entity.Endpoint;
import net.tmt.td.entity.Minion1Ground;
import net.tmt.td.entity.Path;
import net.tmt.td.util.CountdownTimer;
import net.tmt.td.util.ImageLoader;
import net.tmt.td.util.Vector2d;

public class MapLvl1 {

	private static MapLvl1			instance		= null;

	private static BufferedImage	img;
	public List<DirectionPoint>		directionPoints	= null;
	public Endpoint					endpoint		= null;
	private Path					path;
	private Game					game			= Game.getInstance();
	private CountdownTimer			timerSpawnEnemy;

	// TODO:
	/*
	 * Eine Klasse Map erstellen, von der aus zu den gegebenen Levels die
	 * directionPoints[] initialiesert werden.
	 */
	private MapLvl1() {
		timerSpawnEnemy = new CountdownTimer(1000, 0);

		directionPoints = new ArrayList<>(4);
		directionPoints.add(new DirectionPoint(new Vector2d(50, 50), new Vector2d(1, 0)));
		directionPoints.add(new DirectionPoint(new Vector2d(800, 50), new Vector2d(0, 1)));
		directionPoints.add(new DirectionPoint(new Vector2d(800, 350), new Vector2d(-1, 0)));
		directionPoints.add(new DirectionPoint(new Vector2d(500, 350), new Vector2d(0, -1)));
		directionPoints.add(new DirectionPoint(new Vector2d(500, 190), new Vector2d(-1, 0)));
		directionPoints.add(new DirectionPoint(new Vector2d(200, 190), new Vector2d(0, 1)));
		directionPoints.add(new DirectionPoint(new Vector2d(200, 450), new Vector2d(1, 0)));

		endpoint = new Endpoint(new Vector2d(800, 450));

		path = new Path(directionPoints, endpoint);

	}

	public void render(final Graphics g) {
		g.drawImage(ImageLoader.lvl_1, 0, 0, null);
		path.render(g);
		for (DirectionPoint dp : directionPoints)
			dp.render(g);
		endpoint.render(g);
	}

	public void tick() {
		if (timerSpawnEnemy.isTimeleft())
			game.addMob(new Minion1Ground(new Vector2d(50, 50)));

		for (DirectionPoint dp : directionPoints)
			dp.tick();

		endpoint.tick();
	}

	public static MapLvl1 getInstance() {
		return instance;
	}

	public static void init() {
		instance = new MapLvl1();
	}

}
