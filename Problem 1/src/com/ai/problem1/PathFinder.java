package com.ai.problem1;

public class PathFinder {

	private static PriorityQueue<Grid> open;

	private static PriorityQueue<Grid> closed;

	private static int cost, grid_row_limit, grid_col_limit;

	static {
		open = new PriorityQueue<>();
		closed = new PriorityQueue<>();
	}

	public void preComputeHeuristic(Grid[][] array, int row, int col) {

		grid_row_limit = array.length;
		grid_col_limit = array[0].length;

		for (int i = 0; i < grid_row_limit; i++) {
			for (int j = 0; j < grid_col_limit; j++) {
				if (row != i && col != j) {
					array[i][j].setComputedCost(Math.abs(i - row) + Math.abs(j - col));
				}
			}
		}
	}

	public void computePath(Grid[][] array, Grid current, Grid target, int movementCost) {

		Grid left, right, up, down;
		
		if(current.equals(target)){
			return;
		}

		if (open.isEmpty() && closed.isEmpty()) {
			open.insert(current);
		}

		if (open.isEmpty() && !closed.isEmpty()) {
			throw new RuntimeException("Cannot reach the target");
		}

		while (!open.isEmpty()) {

			int current_row = current.getMatrix().getRow();
			int current_col = current.getMatrix().getColumn();

			closed.insert(array[current_row][current_col]);

			if (current_row + 1 < grid_row_limit) {
				right = array[current_row + 1][current_col];
				if (right.isBlocked()) {
					right = null;
				} else {
					right.setComputedCost(right.getComputedCost() + movementCost);
					open.insert(right);
				}
			}

			if (current_row - 1 > 0) {
				left = array[current_row - 1][current_col];
				if (left.isBlocked()) {
					left = null;
				} else {
					left.setComputedCost(left.getComputedCost() + movementCost);
					open.insert(left);
				}
			}

			if (current_col - 1 > 0) {
				down = array[current_row][current_col - 1];
				if (down.isBlocked()) {
					down = null;
				} else {
					down.setComputedCost(down.getComputedCost() + movementCost);
					open.insert(down);
				}
			}
			if (current_col + 1 < grid_col_limit) {
				up = array[current_row - 1][current_col + 1];
				if (up.isBlocked()) {
					up = null;
				} else {
					up.setComputedCost(up.getComputedCost() + movementCost);
					open.insert(up);
				}

				Grid next = open.remove();

				cost += movementCost;

				computePath(array, next, target, movementCost);
			}

		}

	}

}
