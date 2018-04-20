package algorithms.mazeGenerators;



public class Maze
{

	/**
	 * <!-- begin-user-doc -->
	 *     The maze is represented as a 2D char array.
	 *     Zero ('0') = Pass
	 *     One ('1') = Wall
	 *     Start ('S') = The starting position
	 *     End ('E') = The "Goal" position
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private char[][] map;
	private Position startPostion;
	private Position goalPosition;


	public Maze(char[][] map, Position sp, Position gp) {
	    this.map = map;
	    startPostion = sp;
	    goalPosition = gp;
	}

	/*** Getters ***/
	
	public Position getStartPosition() {
        return new Position(startPostion);
	}
	public Position getGoalPosition(){
		return new Position(goalPosition);
	}


	/**
	 * <!-- begin-user-doc -->
	 *     Print method: simply prints the char 2D array values
	 *     Example: A random maze (6 by 6)
	 *
	 *     			011101
	 *     			S00101
	 *     			010001
	 *     			001111
	 *     			100E00
	 *     			110110
	 *
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void print() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++)
                System.out.print(map[i][j]);
            System.out.println();
        }
	}



	/**
	 * <!-- begin-user-doc -->
	 *     If row and column are inside the maze's boarders,
	 *     returns the char in that position.
	 *     else '\0'
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */


	public char getCharAt(int row, int col){
		if ((row < map.length && col < map[0].length) && row >= 0 && col >= 0){
			return map[row][col];
		}
		return '\0';
	}

}

