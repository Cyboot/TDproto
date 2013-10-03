package net.tmt.td.entity;

import java.awt.Color;
import java.awt.Graphics;

import net.tmt.td.util.Vector2d;

public class Shot extends Entity {

	protected final GenericMinion	target;
	protected final int				speed	= 10;
	protected boolean				isAlive	= true;
	protected Tower					owner;

	public Shot(final Tower ownr, final GenericMinion tar) {
		super(ownr.getPos());
		owner = ownr;
		target = tar;
	}

	public void hit() {
		target.looseHealth(owner.getDamage());
		isAlive = false;
	}

	public boolean isAlive() {
		return isAlive;
	}

	@Override
	public void tick() {
		if (target.isAlive()) {
			if (target.getPos().distance(pos) < 10 && isAlive) {
				this.hit();
				// pos = target.getPos();
			} else {
				Vector2d diff = target.getPos().difference(pos);
				diff.setLength(speed);
				pos = pos.sum(diff);
			}
		} else {
			isAlive = false;
		}
	}

	@Override
	public void render(final Graphics g) {
		g.setColor(Color.cyan);
		g.drawOval((int) pos.x, (int) pos.y, 3, 3);
	}

}
