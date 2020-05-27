package mmn12_2;

import java.awt.Color;
import java.util.Random;

public class Robot {

	private int _id;
	private Position _pos;
	private int _direction;
	private Color _color;
	
	final int STARTING_COLOR=50;
	
	final static int DIRECTION_NUM=4;
	final static int  UP=0;
	final static int  RIGHT=1;
	final static int DOWN =2;
	final static int LEFT =3;


	/**
	 * make a new robot with id,position and direction
	 * @param id - id to initialize the robot
	 * @param pos - position to initialize the robot with 
	 * @param direction - direction to initialize the robot with
	 */
	public Robot(int id,Position pos, int direction) {
		this._id=id;
		this._pos= new Position(pos.get_x(),pos.get_y());
		this._direction=(direction%DIRECTION_NUM);
		Random rand = new Random();
		this._color = new Color(rand.nextInt(206)+STARTING_COLOR,rand.nextInt(206)+STARTING_COLOR,rand.nextInt(206)+STARTING_COLOR);
	}
	
	/**
	 * move the robot one step in the direction of this robot
	 */
	public void move() {
		if(this.get_direction()==UP) {
			this.set_pos(this.get_pos().get_x(),this.get_pos().get_y()-1);
		}else if(this.get_direction()==DOWN) {
			this.set_pos(this.get_pos().get_x(),this.get_pos().get_y()+1);
		}else if(this.get_direction()==RIGHT) {
			this.set_pos(this.get_pos().get_x()+1,this.get_pos().get_y());
		}else {
			this.set_pos(this.get_pos().get_x()-1,this.get_pos().get_y());
		}
	}

	/**
	 * asimulate the movement of this robot in one step of this robot direction
	 * 
	 * @return - the position of the simulated movement
	 */
	public Position asimulatMove() {
		if(this.get_direction()==UP) {
			return new Position(this.get_pos().get_x(),this.get_pos().get_y()-1);
		}else if(this.get_direction()==DOWN) {
			return new Position(this.get_pos().get_x(),this.get_pos().get_y()+1);
		}else if(this.get_direction()==RIGHT) {
			return new Position(this.get_pos().get_x()+1,this.get_pos().get_y());
		}else {
			return new Position(this.get_pos().get_x()-1,this.get_pos().get_y());
		}
	}
	
	/**
	 * get this robot id
	 * @return this robot id
	 */
	public int get_id() {
		return _id;
	}

	/**
	 * set this robot ID to id
	 * @param id - ID to set
	 */
	public void set_id(int id) {
		this._id = id;
	}

	/**
	 * get this robot position
	 * @return this robot position
	 */
	public Position get_pos() {
		return _pos;
	}

	/**
	 * set this robot position
	 * @param x -the x coordinate to set this robot position
	 * @param y - the y coordinate to set this robot position 
	 */
	private void set_pos(int x,int y) {
		this._pos.set_x(x);
		this._pos.set_y(y);
	}

	/**
	 * get this robot direction
	 * @return this robot direction
	 */
	public int get_direction() {
		return _direction;
	}

	/**
	 * set this robot direction
	 * @param direction - the direction to set
	 */
	private void set_direction(int direction) {
		this._direction = direction%DIRECTION_NUM;
	}
	
	/**
	 * turn this robot left
	 */
	public void turnLeft() {
		if(this.get_direction()==UP) {
			this.set_direction(LEFT);
			return;
		}
		this.set_direction((this.get_direction()-1));
	}
	
	/**
	 * turn this robot right
	 */
	public void turnRight() {
		this.set_direction(this.get_direction()+1);
	}

	/**
	 * get this robot color
	 * @return this robot color
	 */
	public Color get_color() {
		return _color;
	}

	/**
	 * set this robot color
	 * @param color -  the color to set
	 */
	public void set_color(Color color) {
		this._color = color;
	}

}
