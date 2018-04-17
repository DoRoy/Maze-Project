package algorithms.search;


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.AbstractQueue;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm
{

	private int visitedNodes;
	protected AbstractQueue<AState> stateQueue;


	public ASearchingAlgorithm(){
		visitedNodes = 0;

	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	protected AState popOpenList() {
		visitedNodes++;
		return stateQueue.poll();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public abstract Solution solve(ISearchable searchable) ;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int getNumberOfNodesEvaluated() {
		return visitedNodes;
	}

}

