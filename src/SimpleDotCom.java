
public class SimpleDotCom {
	public static final String HIT = "hit";
	public static final String MISS = "miss";
	public static final String SUNK = "you sunk Simple.com";
	public static final int SHIP_SIZE = 3;
	private int [] shipLocation;
	private int hitCount;
	
	SimpleDotCom(){
		hitCount = 0;
	}
	public boolean setLocation(int [] location){
		shipLocation = location;
		return true;
	}
	public String fire(String fireLocation){
		int fireLocationInt;
		fireLocationInt = Integer.parseInt(fireLocation);
		for(int location: shipLocation){
			if(fireLocationInt == location){
				hitCount++;
				if(hitCount >= SHIP_SIZE){
					return SUNK;
				}
				return HIT;
			}
		}
		return MISS;
	}
}
