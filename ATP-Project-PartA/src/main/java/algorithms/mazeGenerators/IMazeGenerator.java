package algorithms.mazeGenerators;


public  interface IMazeGenerator 
{

	public Maze generate(int rows, int cols) ;



	/**    This method measures how long it takes to generate a random maze.
	 *     It samples the time before the "generate" command is called.
	 *     It samples the time after the maze is made.
	 *     Returns the subtraction between the two samples (long)
	 * @generated
	 * @ordered
	 */
	
	public long measureAlgorithmTimeMillis(int rows, int cols) ;


}

