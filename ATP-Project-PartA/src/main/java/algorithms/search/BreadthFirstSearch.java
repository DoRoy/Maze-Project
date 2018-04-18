package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.*;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class BreadthFirstSearch extends ASearchingAlgorithm {
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 *
	 * @generated
	 */
	public BreadthFirstSearch() {
		super();
		Comparator<AState> comparator = new Comparator<AState>() {
			@Override
			public int compare(AState o1, AState o2) {
				if (o1.getWeight() < o2.getWeight())
					return -1;
				if (o1.getWeight() > o2.getWeight())
					return 1;

				return 0;
			}
		};
		stateQueue = new PriorityQueue<AState>(comparator);
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
		Map<Integer, Integer> distanceDictionary = new HashMap<Integer, Integer>();
		ArrayList<AState> path = new ArrayList<AState>();
		AState goalState = searchable.getGoalState();
		AState startState = searchable.getStartState();

		distanceDictionary.put(startState.hashCode(),0);
		stateQueue.add(startState);

		while (!stateQueue.isEmpty()) {


			AState currentState = popOpenList();
			//visited.add(currentState);

			if (currentState.hashCode() == goalState.hashCode())
				return currentState;


			ArrayList<AState> neighboursList = searchable.getAllPossibleStates(currentState);
			int index = 0;
			for (AState neighbour : neighboursList) {
				int parentDistPlusOne = distanceDictionary.get(currentState.hashCode()) +1;
				if (!distanceDictionary.containsKey(neighbour.hashCode())){
					stateQueue.add(neighbour);

					distanceDictionary.put(neighbour.hashCode(),parentDistPlusOne);
				}
				else{
					if (distanceDictionary.get(neighbour.hashCode())>parentDistPlusOne)
						distanceDictionary.put(neighbour.hashCode(),parentDistPlusOne);
				}
			}
		}
		int goalHashCode = goalState.hashCode();
		Integer dist = distanceDictionary.get(goalHashCode);
		Integer distStart = distanceDictionary.get(startState.hashCode());
		return result;
	}

	private ArrayList<AState> getPathFromMap(Map<Integer,Integer> map, ISearchable searchable){
		ArrayList<AState> list = new ArrayList<AState>();
		Integer goalStateCode = searchable.getGoalState().hashCode();
		Integer startStateCode = searchable.getStartState().hashCode();
		Integer currentDist = map.get(goalStateCode);




		return list;
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
		String[] check = {"{0,0}" ,"{1,0}","{2,0}"};
		Maze maze = new Maze(map,new Position(0,0,null), new Position(4,3,null));
		ISearchable searchableMaze = new SearchableMaze(maze);
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		Solution solution = bfs.solve(searchableMaze);
		maze.print();
		ArrayList<AState> solutionPath = solution.getSolutionPath();
		for (int i = 0; i < solutionPath.size(); i++) {
			System.out.println(String.format("%s. %s",i,solutionPath.get(i)));
		}

	}

}

