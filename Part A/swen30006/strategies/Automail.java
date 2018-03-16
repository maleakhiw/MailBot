package strategies;

import automail.IMailDelivery;
import automail.Robot;

public class Automail {
	      
    public Robot robot1, robot2;
    public IMailPool mailPool;
    
    public Automail(IMailDelivery delivery) {
    	/** Initialize the MailPool */
    	
    	//mailPool = new SimpleMailPool(); 
    	mailPool = new MyMailPool();
    	
        /** Initialize the RobotAction */
    	boolean weak = false;  // Can't handle more than 2000 grams
    	boolean strong = true; // Can handle any weight that arrives at the building
    	
    	// Simple behaviour
//    	IRobotBehaviour robotBehaviourW = new SimpleRobotBehaviour(weak);
//    	IRobotBehaviour robotBehaviourS = new SimpleRobotBehaviour(strong);
    	
    	// My implementation
    	IRobotBehaviour robotBehaviourW = new MyRobotBehaviour(weak);
    	IRobotBehaviour robotBehaviourS = new MyRobotBehaviour(strong);
    	    	
    	/** Initialize robot */
    	robot1 = new Robot(robotBehaviourW, delivery, mailPool, weak); /* shared behaviour because identical and stateless */
    	robot2 = new Robot(robotBehaviourS, delivery, mailPool, strong);
    }
    
}
