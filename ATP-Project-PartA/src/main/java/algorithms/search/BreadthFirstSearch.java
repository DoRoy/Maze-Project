package algorithms.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class BreadthFirstSearch extends ASearchingAlgorithm
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public BreadthFirstSearch(){
		super();
		stateQueue = new PriorityQueue<AState>();
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	@Override
	public Solution solve(ISearchable searchable) {
		ArrayList<AState> list = new ArrayList<AState>();


		Solution solution = new Solution(list);
		return solution;
	}

	public String getName(){

		return "Breadth First Search";
	}



}

