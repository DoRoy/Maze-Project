package algorithms.mazeGenerators;
/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public abstract class AMazeGenerator implements IMazeGenerator
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public AMazeGenerator(){
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public abstract Maze generate(int rows, int cols) ;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public long measureAlgorithmTimeMillis(int rows, int cols) {
		long start = System.currentTimeMillis();
		generate(rows, cols);
		long finished = System.currentTimeMillis();
		System.out.println("Testing time: " + (finished - start) + " MilliSeconds");
		return finished - start;
	}

}

