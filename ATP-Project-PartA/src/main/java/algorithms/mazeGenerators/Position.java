package algorithms.mazeGenerators;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Position
{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	protected Integer row;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	protected Integer col;



	protected Position parent;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public Position(int x, int y, Position parent){
		row = x;
		col = y;
		this.parent = parent;
	}

	public Position(Position copiedPosition){
		row = copiedPosition.row;
		col = copiedPosition.col;
		parent = copiedPosition.parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public Position opposite() {
		if (this.row.compareTo(parent.row) != 0)
			return new Position(this.row + this.row.compareTo(parent.row), this.col, this);
		if (this.col.compareTo(parent.col) != 0)
			return new Position(this.row, this.col + this.col.compareTo(parent.col), this);
		return null;
	}
	public int getRowIndex() {
		return row;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public int getColumnIndex() {
		return col;
	}

}

