package algorithms.search;


import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.List;


public class SearchableMaze implements ISearchable
{

	private Maze maze;
	private MazeState startState;
	private MazeState goalState;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public SearchableMaze(Maze maze){
		this.maze = maze;
		startState = new MazeState(maze.getStartPosition());
		goalState = new MazeState(maze.getGoalPosition());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	//Todo Write this function - Test
	public ArrayList<AState> getAllPossibleStates(AState currentState) {
		if (!(currentState instanceof MazeState)){
			return null;
		}
		ArrayList<AState> list = new ArrayList<AState>();
		MazeState curMazeState = (MazeState)currentState;
		Position curPos = curMazeState.getPosition();
		int curRow = curPos.getRowIndex();
		int curCol = curPos.getColumnIndex();
		char[] validChars = {'0','E','S'};
		for(int x = -1; x <= 1; x++){
			for(int y = -1; y <= 1; y++){
				if (x == 0 && y == 0) //same location
					continue;
				if (x != 0 && y != 0) { // slant
					if (mazeCharCheck(curRow + x,curCol + y)) // checks if its a wall if so wont take it
						if (mazeCharCheck(curRow ,curCol + y)){ // checks if at the same row we have 0
							list.add(new MazeState(15,curRow + x, curCol + y, curPos));
							continue;
						}
						else if (mazeCharCheck(curRow + x,curCol)){ // checks if at the same col we have 0
							list.add(new MazeState(15,curRow + x, curCol + y, curPos));
							continue;
						}
						else{
							continue;
						}
				}
				else if(mazeCharCheck(curRow + x,curCol + y)) // if its not slant, same location and it have '0'
					list.add(new MazeState(10,curRow + x, curCol + y, curPos));
			}
		}
		return list;
	}

	private boolean mazeCharCheck(int row, int col){
		return "E0S".contains(String.valueOf(maze.getCharAt(row, col)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	/*** Getters ***/
	public AState getGoalState() {
		return new MazeState(goalState);
	}

	public AState getStartState() {
		return new MazeState(startState);
	}

}



