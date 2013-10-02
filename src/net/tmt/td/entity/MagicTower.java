package net.tmt.td.entity;

import net.tmt.td.util.ImageLoader;
import net.tmt.td.util.Vector2d;

public class MagicTower extends Tower {

	public MagicTower(final Vector2d initPos) {
		super(initPos);
		this.image = ImageLoader.tower_magic;
	}

}
