package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.Position;
import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class BreadthFirstSearch extends ASearchingAlgorithm {


	public BreadthFirstSearch() {
		super();
		stateQueue = new LinkedTransferQueue<AState>();
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 *
	 * @generated
	 */
	@Override
	public Solution solve(ISearchable searchable) {
		ArrayList<AState> list = new ArrayList<AState>();

		AState result = BFS(searchable);

		Solution solution = formSolution(result);;
		return solution;
	}

	private AState BFS(ISearchable searchable) {
		AState result = null;
		HashSet<Integer> visited = new HashSet<Integer>();
		AState goalState = searchable.getGoalState();
		AState startState = searchable.getStartState();

		stateQueue.add(startState);
		visited.add(startState.hashCode());

		while (!stateQueue.isEmpty()) {


			AState currentState = popOpenList();
			//visited.add((Integer)currentState.hashCode());

			if (currentState.equals(goalState))
				return currentState;

			ArrayList<AState> neighboursList = searchable.getAllPossibleStates(currentState);
			for (AState neighbour : neighboursList) {
				if (!visited.contains(neighbour.hashCode())){
					stateQueue.add(neighbour);

					visited.add(neighbour.hashCode());
				}
			}
		}
		return result;
	}



	public String getName(){

		return "Breadth First Search";
	}



	public static void main(String[] args) {
		char[][] map = {{'S','1','0','1','1'},
				        {'0','1','0','0','1'},
				        {'0','1','0','1','1'},
				        {'0','0','0','0','1'},
				        {'1','1','1','E','1'},
				        {'0','0','0','1','1'}};
		Maze maze = new Maze(map,new Position(0,0,null), new Position(4,3,null));
		MyMazeGenerator mg = new MyMazeGenerator();
		Maze maze2 = mg.generate(1000,1000);
		ISearchable searchableMaze = new SearchableMaze(maze2);

	//	DepthFirstSearch dfs = new DepthFirstSearch();
	//	Solution solution2 = dfs.solve(searchableMaze);
	//	System.out.println(solution2);
	//	System.out.println(dfs.getNumberOfNodesEvaluated() + '\n');

		BreadthFirstSearch bfs = new BreadthFirstSearch();
		//maze2.print();
		Solution solution = bfs.solve(searchableMaze);
		//maze.print();
		//System.out.println(solution);
        System.out.println(bfs.getNumberOfNodesEvaluated() + "\n");

        BestFirstSearch BestFS = new BestFirstSearch();
        Solution solution1 = BestFS.solve(searchableMaze);
        //System.out.println(solution1);
        System.out.println(BestFS.getNumberOfNodesEvaluated());
	}

}

