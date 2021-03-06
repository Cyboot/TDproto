package net.tmt.td.util;

public class Vector2d {
	public double	x;
	public double	y;

	public Vector2d() {
	}

	public Vector2d(final double x, final double y) {
		this.x = x;
		this.y = y;
	}

	public Vector2d copy() {
		return new Vector2d(x, y);
	}

	public Vector2d difference(final Vector2d other) {
		return new Vector2d(x - other.x, y - other.y);
	}

	public Vector2d sum(final Vector2d other) {
		return new Vector2d(x + other.x, y + other.y);
	}

	public Vector2d multiply(final Vector2d other) {
		return new Vector2d(x * other.x, y * other.y);
	}

	public double distance(final Vector2d other) {
		double dx = other.x - x;
		double dy = other.y - y;

		return Math.sqrt(dx * dx + dy * dy);
	}

	public int x() {
		return (int) x;
	}

	public int y() {
		return (int) y;
	}

	public void setLength(final double newLen) {
		int xFac = (x >= 0 ? 1 : -1);
		int yFac = (y >= 0 ? 1 : -1);
		double len = Math.sqrt(x * x + y * y);
		double alpha = Math.asin(Math.abs(x) / len);
		x = Math.sin(alpha) * newLen * xFac;
		y = Math.cos(alpha) * newLen * yFac;
	}

	@Override
	public String toString() {
		return "(" + StringFormatter.format(x, 4, 2) + " : " + StringFormatter.format(y, 4, 2) + ")";
	}
}
