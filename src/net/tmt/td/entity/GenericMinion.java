package net.tmt.td.entity;

import java.awt.Color;
import java.awt.Graphics;

import net.tmt.td.util.Vector2d;

public abstract class GenericMinion extends Entity {

	public final static int TYPE_NOONE = 0;
	public final static int TYPE_GROUND = 1;
	public final static int TYPE_FLY = 2;

	protected boolean isAlive;
	protected int health;
	protected int type;
	protected float armor;
	protected float speed;
	protected Vector2d direction;

	public GenericMinion(Vector2d initPos) {
		super(initPos);
		isAlive = true;
		health = 100;
		type = TYPE_NOONE;
		armor = 0.0f;
		speed = 1.0f;
		// set from spawner, which knows the first directionShield from specific
		// map
		direction = new Vector2d(1, 0);
	}

	public void setDirection(Vector2d other) {
		direction = other;
	}

	public Vector2d getDirection() {
		return direction;
	}

}
