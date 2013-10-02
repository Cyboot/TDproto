package net.tmt.td.entity;

import net.tmt.td.util.ImageLoader;
import net.tmt.td.util.Vector2d;

public class DamageTower extends Tower {

	public DamageTower(final Vector2d initPos) {
		super(initPos);
		this.image = ImageLoader.tower_damage;
	}

}
