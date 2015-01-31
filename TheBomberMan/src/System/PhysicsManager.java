package System;

public abstract class  PhysicsManager implements Runnable{
	static int increment;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			}
		
		public static boolean CollisionDetector(Units unit1, Units unit2) {
			if (unit1.getX() == unit2.getX() && unit1.getY() == unit2.getY() + increment)
				return true;
			else if (unit1.getY() == unit2.getY() && unit1.getX() == unit2.getX() + increment)
				return true;
			else if (unit1.getX() == unit2.getX() && unit1.getY() == unit2.getY() - increment)
				return true;
			else if (unit1.getY() == unit2.getY() && unit1.getX() == unit2.getX() - increment)
				return true;
			else
				return false;
		}
		
		public static boolean canMove(Units unit1) {
			for(int i=0; i < Units.getUnitsArray().size(); i++) {
				if (CollisionDetector(unit1, Units.getUnitsArray().get(i)))
						return false;
				}
		}
}