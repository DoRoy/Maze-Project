package algorithms.search;


import algorithms.mazeGenerators.Position;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class MazeState extends AState {
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	private Position position;


	public MazeState(int row, int col, Position parent){
		position = new Position(row,col,parent);
	}

	public MazeState(Position p){
		position = p;
	}

	public MazeState(MazeState other){
		position = new Position(other.position);
	}

	@Override
	public boolean equals(AState aState) {
		if (aState instanceof MazeState){
			MazeState mState = (MazeState)aState;
			if (mState.position.equals(position))
				return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	//Todo Write toString!
	public String toString() {
		return null;
	}

	public Position getPosition() {
		return new Position(position);
	}
}

