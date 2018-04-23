package algorithms.search;

import java.util.ArrayList;
import java.util.List;


public class Solution
{

	private ArrayList<AState> aStateList;

	public Solution(ArrayList<AState> list){
		aStateList = new ArrayList<AState>(list);
	}

	public ArrayList<AState> getSolutionPath(){
		return new ArrayList<AState>(aStateList);
	}


	/**
	 *     Print Format:
	 *
	 *     "Solution path:
	 		0. {3,0}
	 		1. {3,1}
	 		2. {3,2}
	 		3. {3,3}
	 		4. {3,4}
	 		5. {2,4}
	 		6. {1,4}"
	 */
	public String toString(){
		int stateCount = 1;
		String s = "Solution path:\n";
		for (AState state:aStateList) {
			s += stateCount + ". ";
			stateCount++;
			s += state.toString() + "\n";
		}
		return s;
	}

}

