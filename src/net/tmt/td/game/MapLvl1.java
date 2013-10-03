package net.tmt.td.game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import net.tmt.td.entity.DirectionPoint;
import net.tmt.td.entity.Endpoint;
import net.tmt.td.entity.GenericMinion;
import net.tmt.td.entity.Minion1Ground;
import net.tmt.td.entity.Path;
import net.tmt.td.entity.Shot;
import net.tmt.td.util.CountdownTimer;
import net.tmt.td.util.Vector2d;

public class MapLvl1 {

	private static MapLvl1				instance		= null;

	private static BufferedImage		img;
	public static List<DirectionPoint>	directionPoints	= null;
	public static List<GenericMinion>	minions			= null;
	public static Endpoint				endpoint		= null;
	private Path						path;

	private CountdownTimer				timerSpawnEnemy;

	private MapLvl1() {
		timerSpawnEnemy = new CountdownTimer(1000);

		// img = ImageLoader.getSubImage(img, x, y, width) MAP
		directionPoints = new ArrayList<>(4);
		directionPoints.add(new DirectionPoint(new Vector2d(50, 50), new Vector2d(1, 0)));
		directionPoints.add(new DirectionPoint(new Vector2d(800, 50), new Vector2d(0, 1)));
		directionPoints.add(new DirectionPoint(new Vector2d(800, 350), new Vector2d(-1, 0)));
		directionPoints.add(new DirectionPoint(new Vector2d(500, 350), new Vector2d(0, -1)));
		directionPoints.add(new DirectionPoint(new Vector2d(500, 190), new Vector2d(-1, 0)));
		directionPoints.add(new DirectionPoint(new Vector2d(200, 190), new Vector2d(0, 1)));
		directionPoints.add(new DirectionPoint(new Vector2d(200, 450), new Vector2d(1, 0)));

		endpoint = new Endpoint(new Vector2d(800, 450));
		// endpoint = new Endpoint(new Vector2d(500, 50));

		path = new Path(directionPoints, endpoint);

		minions = new ArrayList<GenericMinion>();
		for (int i = 0; i < 2; i++)
			minions.add(new Minion1Ground(new Vector2d(50 + i * 5, 50)));

		for (int i = 0; i < 2; i++)
			minions.add(new Minion1Ground(new Vector2d(40 + i * 5, 70)));

	}

	public void render(final Graphics g) {
		path.render(g);
		// g.drawMAP
		for (DirectionPoint dp : directionPoints)
			dp.render(g);
		for (GenericMinion gm : minions)
			gm.render(g);

		endpoint.render(g);
	}

	public void tick() {
		if (timerSpawnEnemy.isTimeleft())
			minions.add(new Minion1Ground(new Vector2d(50, 50)));


		for (DirectionPoint dp : directionPoints)
			dp.tick();

		for (int i = 0; i < minions.size(); i++) {
			GenericMinion gm = minions.get(i);
			ArrayList<Shot> shots = Game.getInstance().getShots();
			for (Shot s : shots) {
				if (gm.getPos().distance(s.getPos()) < 1) {
					s.hit();
				}
			}
			if (gm.isAlive())
				gm.tick(); // TODO: does this do anything?
			else
				minions.remove(i);
		}

		endpoint.tick();
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
