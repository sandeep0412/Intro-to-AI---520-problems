package com.ai.problem1;

public class Grid implements Comparable<Grid> {

	private Matrix matrix;

	private int computedCost;

	private boolean isBlocked;

	public int getComputedCost() {
		return computedCost;
	}

	public void setComputedCost(int distanceFromTarget) {
		this.computedCost = distanceFromTarget;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public Matrix getMatrix() {
		return matrix;
	}

	public void setMatrix(int row, int column) {
		this.matrix = new Matrix(row, column);
	}

	public Grid(boolean isBlocked) {
		super();
		this.isBlocked = isBlocked;
	}

	@Override
	public int compareTo(Grid o) {
		return Integer.valueOf(computedCost).compareTo(o.getComputedCost());
	}

	@Override
	public boolean equals(Object o) {

		Matrix a = this.getMatrix();
		Grid grid;

		if (o instanceof Grid) {
			grid = (Grid) o;
		} else {
			return false;
		}

		Matrix b = grid.getMatrix();

		return a.equals(b);
	}

}
