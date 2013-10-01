package net.tmt.td.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import net.tmt.td.util.ImageLoader;
import net.tmt.td.util.Vector2d;

public class Minion1Ground extends GenericMinion {
	private BufferedImage img;

	public Minion1Ground(Vector2d initPos) {
		super(initPos);
		type = GenericMinion.TYPE_GROUND;
		img = ImageLoader.getSubImage(ImageLoader.minion_1_ground, 0, 0, 40);
	}

	@Override
	public void tick() {
		super.tick();
		pos = pos.sum(direction);
		

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(img, (int) (pos.x() * speed), (int) (pos.y() * speed), null);
	}

}
