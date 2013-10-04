package net.tmt.td.entity;

import java.awt.Color;
import java.awt.Graphics;

import net.tmt.td.game.Player;
import net.tmt.td.util.Vector2d;

public abstract class GenericMinion extends Entity {

	public final static int	TYPE_NOONE	= 0;
	public final static int	TYPE_GROUND	= 1;
	public final static int	TYPE_FLY	= 2;

	protected boolean		isAlive;
	protected int			health;
	protected int			type;
	protected int			damage;
	protected float			armor;
	protected Vector2d		speedVector;
	protected Vector2d		directionVector;

	public GenericMinion(final Vector2d initPos) {
		super(initPos);
		isAlive = true;
		health = 100;
		type = TYPE_NOONE;
		damage = 1;
		armor = 0.0f;
		speedVector = new Vector2d(3d, 3d);// just for example
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

	public void looseHealth(final int damage) {
		health -= damage;
	}

	public void attackPlayer() {
		Player.getInstance().changeHealthValueTo(damage * -1);
	}

	public void onKilled() {
		isAlive = false;
	}

	public boolean isAlive() {
		return isAlive;
	}

	@Override
	public void render(Graphics g) {
		//draw health bar
		int maxwidth = 35;
		int offsetX = pos.x()-maxwidth/2;
		int offsetY = pos.y()-25;
		int height = 4;
		
		g.setColor(Color.red);
		g.fillRect(offsetX, offsetY, maxwidth, height);

		g.setColor(Color.green);
		g.fillRect(offsetX, offsetY, (int) (health/100f*maxwidth), height);
	}
	
	@Override
	public void tick() {
		if (health < 0)
			isAlive = false;
	}
}
