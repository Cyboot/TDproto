package net.tmt.td.util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.tmt.td.engine.GameEngine;

public class ImageLoader {
	public static BufferedImage	minion_1_ground;
	public static BufferedImage	grass_1;
	public static BufferedImage	grass_2;
	public static BufferedImage	tower_cool;
	public static BufferedImage	tower_damage;
	public static BufferedImage	tower_fire;
	public static BufferedImage	tower_magic;

	public static void init() {
		grass_1 = loadImage("grass_1.png");
		grass_2 = loadImage("grass_2.png");
		minion_1_ground = loadImage("minion_1_ground.png");
		tower_cool = loadImage("tower_cool.png");
		tower_damage = loadImage("tower_damage.png");
		tower_fire = loadImage("tower_fire.png");
		tower_magic = loadImage("tower_magic.png");
	}

	private static BufferedImage loadImage(final String img) {
		try {
			return ImageIO.read(GameEngine.class.getResource("/" + img));
		} catch (IOException e) {
			throw new IllegalArgumentException(
					"The Image you tried to load was not found!", e);
		}
	}

	public static BufferedImage getSubImage(final BufferedImage img,
			final int x, final int y, final int width) {
		return img.getSubimage(x * width, y * width, width, width);
	}

	public static BufferedImage getCutImage(final BufferedImage img,
			final int width) {
		return img.getSubimage(0, 0, width, img.getHeight());
	}
}
