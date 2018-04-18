package algorithms.mazeGenerators;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class Position
{
	private Integer row;
	private Integer col;
	private Position parent;

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
		if(copiedPosition != null) {
			row = copiedPosition.row;
			col = copiedPosition.col;
			parent = copiedPosition.parent;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 *     [1][a][1]
	 *     [1][b][1]
	 *     [1][c][1]
	 *     In this example:
	 *     'c' is the Parent of 'b'
	 *     => 'a' is the Opposite of 'b'
	 *     "Opposite from the Parent's side"
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

	public int getColumnIndex() {
		return col;
	}

	public String toString(){
		return "{" + row +"," + col + "}";
	}

	public Position getParent() {
		if (parent == null)
			return null;
		return new Position(parent);
	}

	//ToDo Equals and HashCode
	public boolean equals(Position other){
		if (other.getRowIndex() == row && other.getColumnIndex()==col)
			return true;
		return false;
	}

	public int hashCode(){
		int hash = 7;
		hash = 71 * hash + row;
		hash = 71 * hash + col;
		return hash;
	}
}

