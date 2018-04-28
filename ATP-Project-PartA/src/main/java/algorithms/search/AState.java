package algorithms.search;

/**
 * An abstract class representing a state in a searchable problem.
 */
public abstract class AState
{
	// Weight is used to allow Priority Queue
	private int weight;

	/**
	 * Constructor with no use of weight, sets the weight as 0.
	 */
	public AState(){
		weight=0;
	}

	/**
	 * 	/**
	 * Constructor with the use of weight, sets the weight as w.
	 * @param w The cost of moving from a neighbor state to this state.
	 */
	public AState(int w){
		weight=w;
	}

	/**
	 * Compare an object to 'this' AState.
	 * @param aState The object we want to compare with.
	 * @return true if they represents the same state, false otherwise.
	 */
	public abstract boolean equals(Object aState) ;

	/**
	 * Returns a unique int representing this AState in the given problem.
	 * @return
	 */
	public abstract int hashCode() ;

	/**
	 * Makes a String representing this state.
	 * @return A String representing this state.
	 */
	public abstract String toString();

	/**
	 * Gets the state which we got to this state from.
	 * @return The 'AState' we got to this state from.
	 */
	public abstract AState getPredecessor();

	/**
	 * Gets the cost of the moving to this state.
	 * @return weight.
	 */
	public int getWeight() {
		return weight;
	}
}

