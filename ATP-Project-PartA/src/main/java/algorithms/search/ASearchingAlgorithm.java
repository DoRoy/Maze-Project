package algorithms.search;



import javafx.print.Collation;

import java.util.*;



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
	
	protected AState popStateQueue() {
		visitedNodes++;
		return stateQueue.poll();
	}


	
	public abstract Solution solve(ISearchable searchable) ;
	
	public int getNumberOfNodesEvaluated() {
		return visitedNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 *     This method receives a AState (the goalState)
	 *     It adds to a list all the "Predecessors" until the startState
	 *     Returns a list of all the states from start to goal as a Solution
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	protected Solution formSolution(AState result) {
		ArrayList<AState> solutionList = new ArrayList<AState>();
		solutionList.add(result);
		AState parent = result.getPredecessor();
		while(parent != null){
			solutionList.add(parent);
			parent = parent.getPredecessor();
		}
		// Reverse list
		Collections.reverse(solutionList);
		return new Solution(solutionList);
	}
}

