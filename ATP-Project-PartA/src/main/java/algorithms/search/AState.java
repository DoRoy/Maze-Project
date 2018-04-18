package algorithms.search;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public abstract class AState
{
	private int weight;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public AState(){
		weight=0;
	}

	public AState(int w){
		weight=w;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public abstract boolean equals(AState aState) ;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public abstract int hashCode() ;

	public abstract String toString();

	public abstract AState getPredecessor();

	public int getWeight() {
		return weight;
	}
}

