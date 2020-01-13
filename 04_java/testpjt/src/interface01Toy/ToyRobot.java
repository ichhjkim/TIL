package interface01Toy;

public class ToyRobot implements Toy {

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("can walk");
	}

	@Override
	public void run() {
		System.out.println("can run");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alarm() {
		// TODO Auto-generated method stub
		System.out.println("can not alarm");
	}

	@Override
	public void light() {
		// TODO Auto-generated method stub
		System.out.println("can light");
		
	}

}
