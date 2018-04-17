package algorithms.mazeGenerators;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Maze
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private char[][] map;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private Position startPostion;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	private Position goalPosition;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */

	public Maze(char[][] map, Position sp, Position gp) {
	    this.map = map;
	    startPostion = sp;
	    goalPosition = gp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Position getStartPosition() {
        return new Position(startPostion);
	}


	public Position getGoalPosition(){
		return new Position(goalPosition);
	}

	/**
	 * <!-- begin-user-doc -->
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

	public char getCharAt(int row, int col){
		if ((row < map.length && col < map[0].length) && row >= 0 && col >= 0){
			return map[row][col];
		}
		return '\0';
	}

}

