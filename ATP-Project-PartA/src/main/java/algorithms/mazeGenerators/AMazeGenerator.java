package algorithms.mazeGenerators;


public abstract class AMazeGenerator implements IMazeGenerator
{

	public AMazeGenerator(){
	}


	public abstract Maze generate(int rows, int cols) ;


	/**    This method measures how long it takes to generate a random maze.
	 *     It samples the time before the "generate" command is called.
	 *     It samples the time after the maze is made.
	 *     Returns the subtraction between the two samples (long)
	 * @generated
	 * @ordered
	 */
	
	public long measureAlgorithmTimeMillis(int rows, int cols) {
		long start = System.currentTimeMillis();
		generate(rows, cols);
		long finished = System.currentTimeMillis();
		return finished - start;
	}

}

