/**
 *
 */
package mmn12_2;

import java.util.Random;
import javax.swing.*;

/**
 * @author dvir0
 *
 */
public class CreatWorldTester {
	
	
	
	public static void main(String[] args) {
		
		
		String sizeStr = JOptionPane.showInputDialog("Please enter the size of the robot world (integer positive value < 100): ");
		int size = MyPanel.DEFULT_SIZE*20;
		try {
			size = Integer.parseInt(sizeStr);
			if(size <= 0 || size >= 100) {
				throw new NumberFormatException();
			}
		}catch (NumberFormatException numEx) {
			JOptionPane.showMessageDialog(null,"Error : expect for positive integer < 100 insted of "+sizeStr,"Error",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		RobotWorld worldOfRobots = new RobotWorld(size);
		
	    try {
	      /*Random rand = new Random();
		   *for(int i =0;i<5;i++) {
	    		worldOfRobots.addRobot(new Position(rand.nextInt(size), rand.nextInt(size)));
	        }*/
			/*worldOfRobots.addRobot(new Position(2,2));
			worldOfRobots.addRobot(new Position(2,1));
			worldOfRobots.addRobot(new Position(1,2));
			worldOfRobots.addRobot(new Position(2,3));
			worldOfRobots.addRobot(new Position(3,2));*/
	    	worldOfRobots.addRobot(new Position(2,2));
			worldOfRobots.addRobot(new Position(1,1));
			worldOfRobots.addRobot(new Position(1,2));
			worldOfRobots.addRobot(new Position(2,3));
			worldOfRobots.addRobot(new Position(3,3));
		} catch (IllegalPosition e) {
			e.printStackTrace();
		}
	    
	    JFrame frame = new JFrame("Robot World");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    int fixedSize = (size*MyPanel.DEFULT_SIZE);
	    frame.setSize(fixedSize*2, fixedSize*2);
	    
	    MyPanel panel = new MyPanel();
	    panel.set_matrixSize(fixedSize);
	    panel.set_robotList(worldOfRobots.get_currInRobot());
	    frame.add(panel);
	    frame.setVisible(true);
	    
	    Robot r =worldOfRobots.get_currInRobot().get(0);
	    final int STEPS = 30;
	    
	    for(int i=0;i<STEPS;i++) {
	    	int turnRightCnt=0;
	    	for(int j =i;j<i+Robot.DIRECTION_NUM;j++) {
		    	try {
		    		worldOfRobots.moveRobot(r.get_pos());
		    	}catch(IllegalPosition e) {
		    		r.turnRight();
		    		turnRightCnt++;		    		
		    	}
		    	try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    	panel.repaint();
		    	if(turnRightCnt==4) {
		    		i=STEPS;
		    		j=i+4;
		    		JOptionPane.showMessageDialog(frame, "The Robot Is Stuck");
		    	}
	    	}
	    	
	    }

		
	}


	
	

}
