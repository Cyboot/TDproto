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
import net.tmt.td.util.CountdownTimer;
import net.tmt.td.util.ImageLoader;
import net.tmt.td.util.Vector2d;

public class Map {

	private static Map			instance		= null;

	private BufferedImage		img				= null;
	public List<DirectionPoint>	directionPoints	= null;
	public Endpoint				endpoint		= null;
	private Path				path;
	private Game				game			= Game.getInstance();
	private CountdownTimer		timerSpawnEnemy;
	private int					lvl;
	private List<GenericMinion>	mobsStack;


	private Map() {
		lvl = 1;
		setBackgroundImage();
		setTimerSpawnEnemy();
		setPointsAndPath();
		setMobs();
	}

	public void render(final Graphics g) {
		g.drawImage(img, 0, 0, null);
		path.render(g);
		for (DirectionPoint dp : directionPoints)
			dp.render(g);
		endpoint.render(g);
	}

	public void tick() {
		if (timerSpawnEnemy.isTimeleft() && mobsStack.size() > 0)
			game.addMob(mobsStack.remove(0));

		for (DirectionPoint dp : directionPoints)
			dp.tick();

		endpoint.tick();
	}

	public static Map getInstance() {
		return instance;
	}

	public static void init() {
		instance = new Map();
	}


	private void setBackgroundImage() {
		switch (lvl) {
		case 1:
			img = ImageLoader.lvl_1;
			break;

		case 2:
			img = ImageLoader.grass_1;
			break;
		default:
			break;
		}
	}

	private void setTimerSpawnEnemy() {
		switch (lvl) {
		case 1:
			timerSpawnEnemy = new CountdownTimer(1000, 0);
			break;
		case 2:
			timerSpawnEnemy = new CountdownTimer(1000, 0);
			break;
		default:
			break;
		}
	}

	private void setPointsAndPath() {
		switch (lvl) {
		case 1:
			directionPoints = new ArrayList<>();
			directionPoints.add(new DirectionPoint(new Vector2d(50, 50), new Vector2d(1, 0)));
			directionPoints.add(new DirectionPoint(new Vector2d(800, 50), new Vector2d(0, 1)));
			directionPoints.add(new DirectionPoint(new Vector2d(800, 350), new Vector2d(-1, 0)));
			directionPoints.add(new DirectionPoint(new Vector2d(500, 350), new Vector2d(0, -1)));
			directionPoints.add(new DirectionPoint(new Vector2d(500, 190), new Vector2d(-1, 0)));
			directionPoints.add(new DirectionPoint(new Vector2d(200, 190), new Vector2d(0, 1)));
			directionPoints.add(new DirectionPoint(new Vector2d(200, 450), new Vector2d(1, 0)));
			endpoint = new Endpoint(new Vector2d(800, 450));
			path = new Path(directionPoints, endpoint);

			break;
		case 2:
			directionPoints = new ArrayList<>();
			directionPoints.add(new DirectionPoint(new Vector2d(50, 50), new Vector2d(1, 0)));
			directionPoints.add(new DirectionPoint(new Vector2d(800, 50), new Vector2d(0, 1)));
			directionPoints.add(new DirectionPoint(new Vector2d(800, 350), new Vector2d(-1, 0)));
			directionPoints.add(new DirectionPoint(new Vector2d(500, 350), new Vector2d(0, -1)));
			directionPoints.add(new DirectionPoint(new Vector2d(500, 190), new Vector2d(-1, 0)));
			directionPoints.add(new DirectionPoint(new Vector2d(200, 190), new Vector2d(0, 1)));
			directionPoints.add(new DirectionPoint(new Vector2d(200, 450), new Vector2d(1, 0)));
			endpoint = new Endpoint(new Vector2d(800, 450));
			path = new Path(directionPoints, endpoint);

			break;
		case 3:

			break;
		default:
			break;
		}
	}

	private void setMobs() {
		switch (lvl) {
		case 1:
			mobsStack = new ArrayList<GenericMinion>();
			for (int i = 0; i < 30; i++)
				mobsStack.add(new Minion1Ground(new Vector2d(50, 50)));
			break;
		case 2:
			mobsStack = new ArrayList<GenericMinion>();
			for (int i = 0; i < 30; i++)
				mobsStack.add(new Minion1Ground(new Vector2d(50, 50)));
			break;
		default:
			break;
		}
	}

	public List<GenericMinion> getMobStack() {
		return mobsStack;
	}

	public void setUpNewLevel() {
		lvl++;
		setBackgroundImage();
		setTimerSpawnEnemy();
		setPointsAndPath();
		setMobs();
	}
}
