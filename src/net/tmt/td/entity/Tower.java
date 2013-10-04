package net.tmt.td.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import net.tmt.td.game.Game;
import net.tmt.td.util.CountdownTimer;
import net.tmt.td.util.Vector2d;

//TODO: tower kosten coins ?
// klingt vernünftig, ja. Wer ich so implementieren

public abstract class Tower extends Entity {
	private static final int	ATTACK_RADIUS	= 200;
	public static final int		WIDTH			= 40;
	public static final int		HEIGHT			= 85;
	public static final int		DAMAGE			= 5;
	protected int				width			= Tower.WIDTH;
	protected int				height			= Tower.HEIGHT;
	protected int				damage			= Tower.DAMAGE;
	protected BufferedImage		image			= null;
	protected CountdownTimer	cooldown		= new CountdownTimer(100);

	public Tower(final Vector2d initPos) {
		super(initPos);
	}

	public int getDamage() {
		return this.damage;
	}

	@Override
	public void render(final Graphics g) {
		g.drawImage(image, (int) (pos.x - (width / 2)), (int) (pos.y - (height / 2)), null);
	}

	public void shoot(final List<GenericMinion> enemyList) {
		if (cooldown.isTimeleft()) {
			GenericMinion target = null;
			double min_dist = ATTACK_RADIUS;
			for (GenericMinion gm : enemyList) {
				double dist = gm.getPos().distance(pos);
				if (dist < min_dist) {
					min_dist = dist;
					target = gm;
				}
			}
			// only shoot if there is a minion as target
			if (target != null)
				Game.getInstance().registerShot(this, target);
		}
	}
}
