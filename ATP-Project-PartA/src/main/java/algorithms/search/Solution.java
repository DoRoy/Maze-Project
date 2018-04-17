package algorithms.search;

import java.util.ArrayList;
import java.util.List;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Solution
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generatedrr
	 */

	private ArrayList<AState> aStateList;

	public Solution(ArrayList<AState> list){
		aStateList = new ArrayList<AState>(list);

	}

	public ArrayList<AState> getSolutionPath(){
		return new ArrayList<AState>(aStateList);
	}

}

