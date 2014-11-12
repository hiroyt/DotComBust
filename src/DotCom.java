import java.util.ArrayList;

public class DotCom {
	public static final String HIT = "hit";
	public static final String MISS = "miss";
	public static final String SUNK = "you sunk Simple.com";
	public static final int SHIP_SIZE = 3;
	private ArrayList<String>  shipLocation;
	private String shipName;
	
	DotCom(){
		shipName = null;
	}
	public void setName(String name){
		shipName = name;
	}
	public String getName(){
		return shipName;
	}
	
	public boolean setLocation(ArrayList<String> location){
		shipLocation = location;
		return true;
	}
	public String fire(String targetLocation){
		int index = shipLocation.indexOf(targetLocation);
		if(index >= 0){
			shipLocation.remove(index);
			if(shipLocation.isEmpty()){
				return SUNK;
			}
			return HIT;
		}
		return MISS;
	}
	public ArrayList<String> getLocationList() {
		return shipLocation;
	}
}