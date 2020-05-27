package mmn12_2;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class MyPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int _matrixSize;
	private ArrayList<Robot> _robotList; 
	static final int DEFULT_SIZE = 20;

	
	
	
	/**
	 * draw the matrix and the robots in the robots world
	 * @param g - graphics to draw the matrix and robot with
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.white);
				
		for(int i=0;i<= this._matrixSize;i+= DEFULT_SIZE ){
			g.drawLine(i, 0,i, this._matrixSize);
			g.drawLine(0,i,this._matrixSize, i);
		}
		
		if(this._robotList==null) {
			return;
		}
		final int quarter = DEFULT_SIZE/4;
		int x,y;
		Robot r;
		for(int i = 0;i < this._robotList.size();i++) {
			r = this._robotList.get(i);
			x = (r.get_pos().get_x()*DEFULT_SIZE) + quarter;
			y = (r.get_pos().get_y()*DEFULT_SIZE) + quarter;
			g.setColor(r.get_color());
			if(r.get_direction() == Robot.DOWN) {
			    g.fillOval(x, y-quarter, DEFULT_SIZE/2, DEFULT_SIZE/2);
			    g.drawString("V", x, y+DEFULT_SIZE-quarter);
			}else if(r.get_direction() == Robot.LEFT){
				g.fillOval(x,y, DEFULT_SIZE/2, DEFULT_SIZE/2);
				g.drawString("<", x-quarter, y+quarter);
			}else if(r.get_direction() == Robot.RIGHT){
				g.fillOval(x-quarter, y, DEFULT_SIZE/2, DEFULT_SIZE/2);
				g.drawString(">", x+quarter, y+quarter);
			}else if(r.get_direction() == Robot.UP){
				g.fillOval(x,y+quarter, DEFULT_SIZE/2, DEFULT_SIZE/2);
				g.drawString("^", x+quarter,y+quarter);
			}
		}
	}

	
	
	/**
	 * set the robot list for the drawing
	 * @param robotList the robotList to set
	 */
	protected void set_robotList(ArrayList<Robot> robotList) {
		this._robotList = robotList;
	}
	
	
	/**
	 * set the matrix size for the drawing
	 * @param matrixSize - the size of the matrix to set
	 */
	protected void set_matrixSize(int matrixSize) {
		this._matrixSize = matrixSize;
	}
}
