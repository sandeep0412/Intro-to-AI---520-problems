package com.ai.problem1;

public class Matrix {

	private int row;

	private int column;

	public Matrix(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	@Override
	public boolean equals(Object o) {
		Matrix a = this, b = null;
		if (o instanceof Matrix) {
			b = (Matrix) o;
			if (a.getRow() == b.getRow() && a.getColumn() == b.getColumn()) {
				return true;
			}
		}
		return false;
	}

}
