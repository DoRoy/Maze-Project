package algorithms.search;


import algorithms.mazeGenerators.Position;

/**
 * Represents a state in a 2D maze.
 */
public class MazeState extends AState {

	/**
	 * The position of the state.
	 */
	private Position position;

	/*** Constructors ***/
	// Weight is used to allow Priority Queue


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
		position = new Position(p);
	}

	public MazeState(Position p){
		super();
		position = p;
	}

	/**
	 * Copy Constructor.
	 * @param other The MazeState we wish to copy.
	 */
	public MazeState(MazeState other){
		super(other.getWeight());
		position = new Position(other.position);
	}


	@Override
	public boolean equals(Object aState) {
		if (aState instanceof MazeState && aState != null){
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

