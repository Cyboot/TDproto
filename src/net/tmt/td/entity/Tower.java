package net.tmt.td.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import net.tmt.td.util.Vector2d;

public abstract class Tower extends Entity {

	public static final int	WIDTH	= 40;
	public static final int	HEIGHT	= 85;
	protected int			width	= Tower.WIDTH;
	protected int			height	= Tower.HEIGHT;
	protected BufferedImage	image	= null;

	public Tower(final Vector2d initPos) {
		super(initPos);
	}

	@Override
	public void render(final Graphics g) {
		g.drawImage(image, (int) (pos.x - (width / 2)), (int) (pos.y - (height / 2)), null);
	}
}
