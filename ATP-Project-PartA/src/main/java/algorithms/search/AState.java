package algorithms.search;


public abstract class AState
{
	// Weight is used to allow Priority Queue
	private int weight;

	public AState(){
		weight=0;
	}

	public AState(int w){
		weight=w;
	}

	/*** Equals and HashCode ***/
	public abstract boolean equals(AState aState) ;
	public abstract int hashCode() ;

	public abstract String toString();

	/*** Getters ***/
	public abstract AState getPredecessor();

	public int getWeight() {
		return weight;
	}
}

