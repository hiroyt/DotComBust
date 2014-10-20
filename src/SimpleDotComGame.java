
public class SimpleDotComGame {
	public static final int LOCATION_MAX = 7;
	
	public void play(){
		int[] shipLocation = new int[SimpleDotCom.SHIP_SIZE];
		int fireCount;
		SimpleDotCom ship = new SimpleDotCom();
		int startLocation;
		String fireLocation;
		String result;
		GameHelper helper = new GameHelper();
		
		startLocation = (int)(Math.random()
				* (LOCATION_MAX - SimpleDotCom.SHIP_SIZE));
		for(int i=0; i<SimpleDotCom.SHIP_SIZE; i++){
			shipLocation[i] = startLocation + i;
		}
		ship.setLocation(shipLocation);

		for(fireCount = 1; ; fireCount++){
			fireLocation = helper.getUserInput("enter ship location");
			result = ship.fire(fireLocation);
			System.out.println(result);
			if(result.equals(SimpleDotCom.SUNK)){
				break;
			}
		}
		System.out.println("triy count = " + fireCount);
		printLocation(shipLocation);
	}
	private void printLocation(int [] location){
		System.out.print("ship location is [ ");
		for(int i=0; i<location.length; i++){
			System.out.print(location[i]);
			if(i == (location.length - 1)){
				System.out.println(" ]");
			}
			else{
				System.out.print(", ");
			}
		}
	}
}
