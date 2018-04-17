package algorithms.search;


import algorithms.mazeGenerators.Maze;

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

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	//Todo Write this function
	public ArrayList<AState> getAllPossibleStates(AState currentState) {
		if (!(currentState instanceof MazeState)){
			return null;
		}
		ArrayList<AState> list = new ArrayList<AState>();

		// if (up == '0'), if(down == '0')

		MazeState m = null;
		list.add(m);
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

}

