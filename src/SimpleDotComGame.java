import java.util.ArrayList;


public class SimpleDotComGame {
	public static final int LOCATION_MAX = 7;
	private String allLocation;
	
	public void play(){
		ArrayList<String> shipLocation = new ArrayList<String>();
		int fireCount;
		SimpleDotCom ship = new SimpleDotCom();
		int startLocation; // todo: ArrayListに変更
		String fireLocation;
		String result;
		GameHelper helper = new GameHelper();
		
		startLocation = (int)(Math.random()
				* (LOCATION_MAX - SimpleDotCom.SHIP_SIZE));
		for(int i=0; i<SimpleDotCom.SHIP_SIZE; i++){
			shipLocation.add(Integer.toString(startLocation + i));
		}
		ship.setLocation(shipLocation);
		getAllLocation(shipLocation);

		for(fireCount = 1; ; fireCount++){
			fireLocation = helper.getUserInput("enter ship location");
			result = ship.fire(fireLocation);
			System.out.println(result);
			if(result.equals(SimpleDotCom.SUNK)){
				break;
			}
		}
		System.out.println("triy count = " + fireCount);
		printAllLocation();
	}
	private void getAllLocation(ArrayList<String> location){
		allLocation = "ship location is [ ";
		for(int i=0; i<location.size(); i++){
			allLocation += location.get(i);
			if(i == (location.size() - 1)){
				allLocation += " ]";
			}
			else{
				allLocation += ", ";
			}
		}
	}
	private void printAllLocation(){
		System.out.println(allLocation);
	}
}
