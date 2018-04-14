package algorithms.mazeGenerators;
import java.util.*;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class MyMazeGenerator extends AMazeGenerator
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public MyMazeGenerator(){
	}

	@Override
	public Maze generate(int row, int col) {
		// build maze and initialize with only walls
		StringBuilder s = new StringBuilder(col);
		for (int x = 0; x < col; x++)
			s.append('1');
		char[][] maz = new char[row][col];
		for (int x = 0; x < row; x++) maz[x] = s.toString().toCharArray();

		// select random point and open as start node
		Position goalPosition = null;
		Position startPosition = new Position((int) (Math.random() * row), 0, null);
		maz[startPosition.getRowIndex()][startPosition.getColumnIndex()] = 'S';

		// iterate through direct neighbors of node
		ArrayList<Position> frontier = new ArrayList<Position>();
		for (int x = -1; x <= 1; x++)
			for (int y = -1; y <= 1; y++) {
				if (x == 0 && y == 0 || x != 0 && y != 0)
					continue;
				try {
					if (maz[startPosition.getRowIndex() + x][startPosition.getColumnIndex() + y] == '0') continue;
				} catch (Exception e) { // ignore ArrayIndexOutOfBounds
					continue;
				}
				// add eligible points to frontier
				frontier.add(new Position(startPosition.getRowIndex() + x, startPosition.getColumnIndex() + y, startPosition));
			}

		Position last = null;
		while (!frontier.isEmpty()) {

			// pick current node at random
			Position cu = frontier.remove((int) (Math.random() * frontier.size()));
			Position op = cu.opposite();
			try {
				// if both node and its opposite are walls
				if (maz[cu.getRowIndex()][cu.getColumnIndex()] == '1') {
					if (maz[op.getRowIndex()][op.getColumnIndex()] == '1') {

						// open path between the nodes
						maz[cu.getRowIndex()][cu.getColumnIndex()] = '0';
						maz[op.getRowIndex()][op.getColumnIndex()] = '0';

						// store last node in order to mark it later
						last = op;

						// iterate through direct neighbors of node, same as earlier
						for (int x = -1; x <= 1; x++)
							for (int y = -1; y <= 1; y++) {
								if (x == 0 && y == 0 || x != 0 && y != 0)
									continue;
								try {
									if (maz[op.getRowIndex() + x][op.getColumnIndex() + y] == '0') continue;
								} catch (Exception e) {
									continue;
								}
								frontier.add(new Position(op.getRowIndex() + x, op.getColumnIndex() + y, op));
							}
					}
				}
			} catch (Exception e) { // ignore NullPointer and ArrayIndexOutOfBounds
			}

			// if algorithm has resolved, mark end node
			if (frontier.isEmpty()) {
				maz[last.getRowIndex()][last.getColumnIndex()] = 'E';
				goalPosition = new Position(last.getRowIndex(), last.getColumnIndex(), last.parent);
			}
		}


		return new Maze(maz,startPosition,goalPosition);
	}


	public static void main(String[] args){
		MyMazeGenerator mg = new MyMazeGenerator();
		mg.measureAlgorithmTimeMillis(1000,1000);
		//Maze m = mg.generate(50,60);
		//m.print();

	}
}




