package algorithms.search;



/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
public  interface ISearchingAlgorithm 
{


	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Solution solve(ISearchable searchable) ;

	public String getName();

	public int getNumberOfNodesEvaluated();


}

