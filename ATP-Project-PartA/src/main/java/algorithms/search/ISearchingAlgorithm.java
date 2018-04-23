package algorithms.search;



public  interface ISearchingAlgorithm 
{

	public Solution solve(ISearchable searchable) ;

	/*** Getters ***/
	public String getName();

	public int getNumberOfNodesEvaluated();


}

