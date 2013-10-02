package net.tmt.td.entity;

import net.tmt.td.util.Vector2d;

public abstract class GenericMinion extends Entity {

	public final static int	TYPE_NOONE	= 0;
	public final static int	TYPE_GROUND	= 1;
	public final static int	TYPE_FLY	= 2;

	protected boolean		isAlive;
	protected int			health;
	protected int			type;
	protected float			armor;
	protected Vector2d		speedVector;
	protected Vector2d		directionVector;

	public GenericMinion(final Vector2d initPos) {
		super(initPos);
		isAlive = true;
		health = 100;
		type = TYPE_NOONE;
		armor = 0.0f;
		speedVector = new Vector2d(1d, 2d);// just for example
		// set from spawner, which knows the first directionShield from specific
		// map
		directionVector = new Vector2d(1, 0);
	}

	public void setDirection(final Vector2d other) {
		directionVector = other;
	}

	public Vector2d getDirection() {
		return directionVector;
	}

}
