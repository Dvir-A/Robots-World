package mmn12_2;

public class Position {
    private int _x;
    private int _y;
    
    
	/**
	 * make a new position at the origin (0,0) 
	 */
	public Position() {
		this._x=0;
		this._y=0;
	}
	/**
	 * make a new position at the origin (x,y) 
	 */
	public Position(int x,int y) {
		this.set_x(x);
		this.set_y(y);
	}
	
/* to string*/
	
	
	/**
	 * get the value of x coordinate of this position
	 * 
	 * @return -x coordinate of this position
	 */
	public int get_x() {
		return _x;
	}

	/**
	 * make a copy of this position and return it.
	 *  
	 * @return - new copy of this position
	 */
	public Position copy() {
		return new Position(this.get_x(),this.get_y());
	}
	
	
	/**
	 * set the x coordinate in this position
	 * 
	 * @param x - x coordinate to set
	 */
	public void set_x(int x) {
		if(x<0) {
			this._x=0;
			return;
		}
		this._x = x;
	}

	
	/**
	 * get the value of y coordinate of this position
	 * 
	 * @return -y coordinate of this position
	 */
	public int get_y() {
		return _y;
	}

	/**
	 * set the y coordinate in this position
	 * 
	 * @param y - y coordinate to set
	 */
	public void set_y(int y) {
		if(y<0) {
			this._y=0;
			return;
		}
		this._y = y;
	}

	
}
