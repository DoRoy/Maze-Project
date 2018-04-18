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


	public MazeState(int weight,int row, int col, Position parent){
		super(weight);
		position = new Position(row,col,parent);
	}

	public MazeState(int row, int col, Position parent){
		super();
		position = new Position(row,col,parent);
	}

	public MazeState(int weight,Position p){
		super(weight);
		position = p;
	}

	public MazeState(Position p){
		super();
		position = p;
	}

	public MazeState(MazeState other){
		super(other.getWeight());
		position = new Position(other.position);
	}


	//Todo Write Equals and HashCode
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
		return position.hashCode();
	}

	@Override
	//Todo Write toString - Done
	public String toString() {
		return position.toString();
	}

	@Override
	public AState getPredecessor() {
		if(position.getParent() == null)
			return null;
		return new MazeState(position.getParent());
	}

	public Position getPosition() {
		return new Position(position);
	}


}

