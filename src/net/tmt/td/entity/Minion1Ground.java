package net.tmt.td.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import net.tmt.td.util.ImageLoader;
import net.tmt.td.util.Vector2d;

public class Minion1Ground extends GenericMinion {
	private BufferedImage	img;
	private int				xOffsetImg;
	private int				yOffsetImg;

	public Minion1Ground(final Vector2d initPos) {
		super(initPos);
		type = GenericMinion.TYPE_GROUND;
		img = ImageLoader.getSubImage(ImageLoader.minion_1_ground, 0, 0, 40);
		xOffsetImg = img.getWidth() / 2;
		yOffsetImg = img.getHeight() / 2;
	}

	@Override
	public void tick() {
		super.tick();
		pos = pos.sum(directionVector.multiply(speedVector));

	}

	@Override
	public void render(final Graphics g) {
		super.render(g);
		g.setColor(Color.orange);
		// g.drawRect(pos.x(), pos.y(), 1, 1);
		// g.drawRect(pos.x() - xOffsetImg, pos.y() - yOffsetImg, 40, 40);
		g.drawImage(img, pos.x() - xOffsetImg, pos.y() - yOffsetImg, null);

	}

}
