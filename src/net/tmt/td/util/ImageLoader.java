package net.tmt.td.util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.tmt.td.engine.GameEngine;

public class ImageLoader {
	public static BufferedImage grass_1;
	public static BufferedImage grass_2;
	public static BufferedImage minion_1_ground;

	public static void init() {
		grass_1 = loadImage("grass_1.png");
		grass_2 = loadImage("grass_2.png");
		minion_1_ground = loadImage("minion_1_ground.jpg");

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
