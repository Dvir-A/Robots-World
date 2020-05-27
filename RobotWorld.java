package mmn12_2;

import java.util.*;

public class RobotWorld {

	final static int MAX_LEN =100;
	
	private Robot [][] _world;
	private int _size;
	private int _currIn;
	private ArrayList<Robot> _currInRobot;
	
	/**
	 * get the ArrayList<Robot> of the current robots in this world
	 * @return ArrayList<Robot> that contains the current robots in this world
	 */
	public ArrayList<Robot> get_currInRobot() {
		return _currInRobot;
	}

	/**
	 * build a robot world with the given size
	 * @param size - the size of the robots world
	 */
	public RobotWorld(int size) {
		if(size<=0) {
			throw new IllegalArgumentException("\nThe size supposed to be bigger then 0\n");
		}
		this._world = new Robot[size][size];
		this._size=size;
		this._currIn=0;
		this._currInRobot = new ArrayList<Robot>();
	}
	
	/**
	 * check if the position is bound to the limit size
	 * @param pos - position to check
	 * @param lim - the limit size
	 * @return true if the position pos is bound to the limit lim else return false
	 */
	public Boolean isBound(Position pos,int lim) {
		if(pos.get_x() >= 0 && pos.get_x() >= 0 && pos.get_x() < this.get_size() && pos.get_y() < this.get_size()) {
			return true;
		}
		return false;
	}
	
	/**
	 * add a new robot to this robots world
	 * @param p - position to add the robot 
	 * @throws IllegalPosition - if the position is taken or not in the world
	 */
	public void addRobot(Position p) throws IllegalPosition {
		if(!isBound(p,this.get_size())) {
			throw new IllegalPosition("\nThe position ("+p.get_x()+","+p.get_y()+") is out of bound\n");
		}
		if(this.isFreePos(p)) {
			Random randInt=new Random();
			Robot newRobot =new Robot(this._currIn++, p,randInt.nextInt(Robot.DIRECTION_NUM));
			this.set_world(p,newRobot);
			this._currInRobot.add(newRobot);
		}else {
			throw new IllegalPosition("\nThere is anther robot in this position\n");
		}
	}

	/** 
	 * check if the given position pos is free from robot
	 * @param pos - position to check
	 * @return true if this position is free from robots else return false
	 */
	public Boolean isFreePos(Position pos) {
		if(this.get_world(pos.get_x(), pos.get_y())==null) {
			return true;
		}
		return false;
	}
	
	/**
	 * remove robot from the given position
	 * @param pos - position to delete a robot from
	 * @return if there is a robot in pos returns the robot that removed else return null
	 */
	public Robot removeRobot(Position pos) {
		if(!isBound(pos,this.get_size()) || !isFreePos(pos)) {
			return null;
		}
		Robot robot = this.get_world(pos.get_x(), pos.get_y());
		this.set_world(pos, null);
		this._currInRobot.remove(robot);
		return robot;
	}
	
	/**
	 * move robot from the position pos, one step in his direction
	 * @param pos - position of robot in this world
	 * @throws IllegalPosition - if the position is free or not in the world or 
	 * 							 trying to move to a taken place or out of the world
	 */
	public void moveRobot(Position pos) throws IllegalPosition {
		if(!isBound(pos,this.get_size())) {
			throw new IllegalPosition("\nThis position is out of bound\n");
		}
		if(this.isFreePos(pos)) {
			throw new IllegalPosition("\nThis position is free from Robot\n");
		}else {
			Robot toMove =this.get_world(pos.get_x(), pos.get_y());
			Position tmpPos = toMove.asimulatMove().copy();
			if(!isBound(tmpPos,this.get_size())) {
				throw new IllegalPosition("\nThe robot is trying to move out of boundary\n");
			}else if(!isFreePos(tmpPos)) {
				throw new IllegalPosition("\nThe robot is trying to move to a taken place(two robots can't be in the same place)\n");
			}else {
				tmpPos = pos.copy();
				this.set_world(tmpPos, null);
				toMove.move();
				this.set_world(toMove.get_pos(), toMove);
			}
		}
	}
	
	
	/**
	 * get robot from world in the position (row, column)
	 * @param row -the x position in this world
	 * @param column - the y position in this world
	 * @return null if row or column are bigger then the world's size 
	 * 		   else returns the robot in the position (row, column)
	 */
	public Robot get_world(int row,int column) {
		if(row > this.get_size() || column > this.get_size()) {
			return null;
		}
		return _world[row][column];
	}


	/**
	 * get this world size
	 * @return the size of this world
	 */
	public int get_size() {
		return _size;
	}

	/**
	 * set the given robot r in the position p (if p is out of bound or not free the set does not occurre)
	 * @param p - position to set in
	 * @param r - the robot to set
	 */
	private void set_world(Position p,Robot r) {
		if(!this.isBound(p, _size)) {
			return;
		}
		this._world[p.get_x()][p.get_y()] = r;
	}



}


