package net.tmt.td.entity;

import java.awt.Graphics;

import net.tmt.td.util.Vector2d;

public abstract class Entity {
	protected Vector2d	pos;

	public Entity(final Vector2d initPos) {
		pos = initPos;
	}

	public void tick() {
	}

	public abstract void render(final Graphics g);

	public Vector2d getPos() {
		return pos;
	}
}
