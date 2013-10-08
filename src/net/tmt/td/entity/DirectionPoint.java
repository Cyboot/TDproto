package net.tmt.td.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import net.tmt.td.game.Game;
import net.tmt.td.util.Vector2d;

public class DirectionPoint extends Entity {

	public final static int	RADIUS	= 30;
	private int				xOffsetRadius;
	private int				yOffsetRadius;
	private Vector2d		direction;
	List<GenericMinion>		minions	= null;

	public DirectionPoint(final Vector2d pos, final Vector2d direction) {
		super(pos);
		this.direction = direction;
		xOffsetRadius = RADIUS / 2;
		yOffsetRadius = RADIUS / 2;

	}

	@Override
	public void tick() {
		minions = Game.getInstance().getMobs();
		for (GenericMinion gm : minions) {
			if (pos.distance(gm.getPos()) < RADIUS) {
				gm.setDirection(direction);
			}
		}

	}

	@Override
	public void render(final Graphics g) {
		g.setColor(Color.orange);
		g.drawOval(pos.x() - 1, pos.y() - 1, 2, 2);
		g.drawOval(pos.x() - xOffsetRadius, pos.y() - yOffsetRadius, RADIUS, RADIUS);

		// just fo debugging to see the line between the boundaries
		// minions = MapLvl1.getInstance().getMinions();
		// for (GenericMinion gm : minions) {
		// if (pos.distance(gm.getPos()) < RADIUS) {
		// g.drawLine(pos.x(), pos.y(), gm.getPos().x(), gm.getPos().y());
		// ;
		// }
		// }
	}

}
