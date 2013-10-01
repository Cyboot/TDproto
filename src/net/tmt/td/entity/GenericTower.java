package net.tmt.td.entity;

import java.awt.Color;
import java.awt.Graphics;

import net.tmt.td.util.Vector2d;

public class GenericTower extends Entity {


	public GenericTower(final Vector2d initPos) {
		super(initPos);
	}

	@Override
	public void render(final Graphics g) {
		g.setColor(Color.red);
		g.drawRect((int) pos.x, (int) pos.y, 5, 15);
	}
}
