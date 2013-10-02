package net.tmt.td.util;

import java.util.List;

import net.tmt.td.entity.GenericMinion;
import net.tmt.td.game.MapLvl1;

public class DirectionPoint {

	public final static float	RADIUS	= 30.f;

	private Vector2d			pos;
	private Vector2d			direction;

	public DirectionPoint(final Vector2d pos, final Vector2d direction) {
		this.pos = pos;
		this.direction = direction;
	}

	public void tick() {

		List<GenericMinion> minions = MapLvl1.getInstance().getMinions();

		for (GenericMinion gm : minions) {
			if (pos.distance(gm.getPos()) < RADIUS)
				gm.setDirection(direction);
		}

	}
}
