package algorithms.search;


import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class SearchableMaze implements ISearchable
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
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
		for(int x = -1; x <= 1; x++){
			for(int y = -1; y <= 1; y++){
				if (x == 0 && y == 0) //same location
					continue;
				if (x != 0 && y != 0) { // slant
					if (maze.getCharAt(curRow + x,curCol + y) == '0') // checks if its a wall if so wont take it
						if (maze.getCharAt(curRow,curCol + y) == '0'){ // checks if at the same row we have 0
							list.add(new MazeState(curRow + x, curCol + y, curPos));
							continue;
						}
						else if (maze.getCharAt(curRow + x,curCol) == '0'){ // checks if at the same col we have 0
							list.add(new MazeState(curRow + x, curCol + y, curPos));
							continue;
						}
					else{
						continue;
					}
				}
				else if(maze.getCharAt(curRow + x,curCol + y) == '0') // if its not slant, same location and it have '0'
					list.add(new MazeState(curRow + x, curCol + y, curPos));
			}
		}
		return list;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public AState getGoalState() {
		return new MazeState(goalState);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public AState getStartState() {
		return new MazeState(startState);
	}


	public static void main(String[] args) {
		char[][] map = {{'0','0','0','1','1'},
						{'0','0','0','0','1'},
						{'0','0','0','1','1'}};
		Maze maze = new Maze(map,new Position(1,1,null), new Position(0,0,null));
		ISearchable searchableMaze = new SearchableMaze(maze);
		ArrayList<AState> list = searchableMaze.getAllPossibleStates(new MazeState(1,1,new Position(0,0,null)));
		for (AState state:list ) {
			System.out.println(((MazeState)state).getPosition());
		}

	}
}



