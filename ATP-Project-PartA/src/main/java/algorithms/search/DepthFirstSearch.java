package algorithms.search;


import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class DepthFirstSearch extends ASearchingAlgorithm
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public DepthFirstSearch(){
		super();
		stateQueue = new PriorityQueue<AState>();
	}

	@Override
	public Solution solve(ISearchable searchable) {
		ArrayList<AState> list = new ArrayList<AState>();


		Solution solution = new Solution(list);
		return solution;
	}

	public String getName(){
		return "Depth First Search";
	}



}

