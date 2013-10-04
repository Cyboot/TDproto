package net.tmt.td.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import net.tmt.td.util.Vector2d;

public class Path extends Entity {
	private List<Vector2d>	vertices	= new ArrayList<>();

	public Path(List<DirectionPoint> dirPoints, Endpoint endpoint) {
		super(new Vector2d());

		for (DirectionPoint d : dirPoints)
			vertices.add(d.getPos());
		vertices.add(endpoint.getPos());
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.gray);
		for (int i = 0; i < vertices.size() - 1; i++) {
			g.drawLine(vertices.get(i).x(), vertices.get(i).y(), vertices.get(i + 1).x(), vertices.get(i + 1).y());
		}
	}
}
