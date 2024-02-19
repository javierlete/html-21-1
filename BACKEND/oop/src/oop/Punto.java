package oop;

import java.util.Objects;

public class Punto {
	private double r;
	private double a;

	public Punto(int x, int y) {
		super();

		r = Math.sqrt(x * x + y * y);
		a = Math.atan2(y, x);
	}

	public int getX() {
		return (int) (r * Math.cos(a));
	}

	public void setX(int x) {
//		this.x = x;
	}

	public int getY() {
		return (int) (r * Math.sin(a));
	}

	public void setY(int y) {
//		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(a, r);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		return Double.doubleToLongBits(a) == Double.doubleToLongBits(other.a)
				&& Double.doubleToLongBits(r) == Double.doubleToLongBits(other.r);
	}

	@Override
	public String toString() {
		return "Punto [r=" + r + ", a=" + a + "]";
	}

	public double distancia() {
		return r;
	}

	public double distancia(Punto p) {
		return distancia(this, p);
	}

	public static double distancia(Punto p1, Punto p2) {
		return restar(p1, p2).distancia();
	}

	public Punto restar(Punto p) {
		return new Punto(this.getX() - p.getX(), this.getY() - p.getY());
	}

	public static Punto restar(Punto p1, Punto p2) {
		return p1.restar(p2);
	}
}
