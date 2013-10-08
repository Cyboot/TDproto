package net.tmt.td.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import net.tmt.td.game.Game;
import net.tmt.td.util.ImageLoader;
import net.tmt.td.util.Vector2d;

public class Endpoint extends Entity {
	public final static int	RADIUS	= 30;
	private BufferedImage	img;
	private int				xOffsetImg;
	private int				yOffsetImg;
	List<GenericMinion>		minions	= null;

	public Endpoint(final Vector2d initPos) {
		super(initPos);
		img = ImageLoader.getSubImage(ImageLoader.endpoint_flag, 0, 0, 50);
		xOffsetImg = img.getWidth() / 2;
		yOffsetImg = img.getHeight() / 2;
	}

	@Override
	public void render(final Graphics g) {

		g.drawImage(img, pos.x() - xOffsetImg, pos.y() - yOffsetImg, null);
	}

	@Override
	public void tick() {
		minions = Game.getInstance().getMobs();
		for (GenericMinion gm : minions) {
			if (pos.distance(gm.getPos()) < RADIUS) {
				gm.attackPlayer();
				gm.onKilled();
			}
		}
	}

}
