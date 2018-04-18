package algorithms.search;


import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;
import java.util.HashMap;
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
	private HashMap<Integer,Boolean> visited;

	public DepthFirstSearch(){
		super();
		stateQueue = new PriorityQueue<AState>();
	}

	@Override
	public Solution solve(ISearchable searchable) {
		AState curLoc = searchable.getStartState();
		//stateQueue.add(curLoc);
		ArrayList<AState> neighbors = searchable.getAllPossibleStates(curLoc);
		visited = new HashMap<Integer, Boolean>();
		visited.put(curLoc.hashCode(),true);
		for (AState neighborState: neighbors) {
			visited.put(neighborState.hashCode(),false);
		}
		AState result = null;
		for (AState neighborState:neighbors) {
			if(!visited.get(neighborState.hashCode())){
				result = DFSVisit(searchable,neighborState);
				if (result != null)
					return formSolution(result);
			}
		}
		return null;
	}



	private AState DFSVisit(ISearchable searchable, AState neighborState) {
		visited.put(neighborState.hashCode(), true);
		for (AState neighbor: searchable.getAllPossibleStates(neighborState)) {
			if(!visited.containsKey(neighbor.hashCode()))
				visited.put(neighbor.hashCode(),false);
			if(!visited.get(neighbor.hashCode())){
				if(neighbor.equals(searchable.getGoalState()))
					return neighbor;
				AState ans =  DFSVisit(searchable,neighbor);
				if (ans != null)
					return ans;
			}

		}
		return null;
	}



	public String getName(){
		return "Depth First Search";
	}


	public static void main(String[] args) {
		char[][] map = {{'S','1','0','1','1'},
						{'0','1','0','0','1'},
						{'0','1','0','1','1'},
						{'0','0','0','0','1'},
						{'1','1','1','E','1'},
						{'0','0','0','1','1'}};
		String[] check = {"{0,0}" ,"{1,0}", "{2,0}"};
		Maze maze = new Maze(map,new Position(0,0,null), new Position(4,3,null));
		ISearchable searchableMaze = new SearchableMaze(maze);
		DepthFirstSearch dfs = new DepthFirstSearch();
		Solution solution = dfs.solve(searchableMaze);
		System.out.println(solution);
	}
}

