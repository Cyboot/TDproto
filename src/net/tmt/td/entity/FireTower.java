package net.tmt.td.entity;

import net.tmt.td.util.ImageLoader;
import net.tmt.td.util.Vector2d;

public class FireTower extends Tower {

	public FireTower(final Vector2d initPos) {
		super(initPos);
		this.image = ImageLoader.tower_fire;
	}

}
