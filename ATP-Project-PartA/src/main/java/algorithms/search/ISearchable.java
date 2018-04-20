package algorithms.search;

import java.util.ArrayList;
import java.util.List;


public  interface ISearchable 
{

	public ArrayList<AState> getAllPossibleStates(AState currentState) ;

	/*** Getters ***/
	public AState getGoalState() ;
	public AState getStartState() ;


}

