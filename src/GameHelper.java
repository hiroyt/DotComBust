import java.io.*;
import java.util.ArrayList;

public class GameHelper {
	private enum ShipDirection{x, y};
	private int testCount = 0;

	public String getUserInput(String prompt){
		String inputLine = null;
		System.out.print(prompt + " ");
		try{
			BufferedReader is = new BufferedReader(
					new InputStreamReader(System.in));
			inputLine = is.readLine();
			if(inputLine.length() == 0){
				return null;
			}
		} catch(IOException e){
			System.out.println("IOCxception: " + e);
			return null;
		}
		return inputLine;
	}

	public String testInput(){
		return new String("A" + Integer.toString(testCount++));
	}
	
	public ArrayList<String> getRandomLocation(){
		ArrayList<String> locationList = new ArrayList<String>();
		ShipDirection shipDirection = getRandomDirection();
		char xCell = 'a';
		char yCell = '0';		
		if(shipDirection == ShipDirection.x){
			xCell += getRandomStartCellValue(DotCom.SHIP_SIZE, DotComBust.LOCATION_MAX);
			yCell += getRandomStartCellValue(1, DotComBust.LOCATION_MAX);
		}
		else{
			xCell += getRandomStartCellValue(1, DotComBust.LOCATION_MAX);
			yCell += getRandomStartCellValue(DotCom.SHIP_SIZE, DotComBust.LOCATION_MAX);
		}
		for(int i = 0; i < DotCom.SHIP_SIZE; i++){
			//  要素7x7の配列上
			locationList.add(String.valueOf(xCell) + String.valueOf(yCell));
			if(shipDirection == ShipDirection.x){
				xCell++;
			}
			else{
				yCell++;
			}
		}
		return locationList;
	}
	
	public String getLocationMessage(String name, ArrayList<String> location){
		String allLocation = name + " location is [ ";
		for(int i=0; i<location.size(); i++){
			allLocation += location.get(i);
			if(i == (location.size() - 1)){
				allLocation += " ]";
			}
			else{
				allLocation += ", ";
			}
		}
		return allLocation;
	}

	public void initStatusMap(DotCom.LocationStatus[][] map){
		for(int i = 0; i < DotComBust.LOCATION_MAX; i++){
			for(int j = 0; j < DotComBust.LOCATION_MAX; j++){
				map[i][j] = DotCom.LocationStatus.none;
			}
		}
	}

	private int[] getLocationCellIndex(String location){
		if(location.length() != 2) return null;
		if((location.charAt(0) < 'a')
				|| (location.charAt(0) >= ('a' + DotComBust.LOCATION_MAX))
				|| (location.charAt(1) < '0')
				|| (location.charAt(1) >= ('0' + DotComBust.LOCATION_MAX))){
			return null;
		}
		int[] locationIndex = new int[2];
		locationIndex[0] = location.charAt(0) - 'a'; // x
		locationIndex[1] = location.charAt(1) - '0'; // y
		return locationIndex;
	}
	
	public void setStatusMap(String result
			, DotCom.LocationStatus[][] map
			, String location) {
		int[] locationIndex = getLocationCellIndex(location);
		if(locationIndex == null){
			return;
		}
		DotCom.LocationStatus setStatus;
		if(result.equals(DotCom.MISS)){
			setStatus = DotCom.LocationStatus.miss;
		}
		else if(result.equals(DotCom.HIT)){
			setStatus = DotCom.LocationStatus.hit;
		}
		else{
			setStatus = DotCom.LocationStatus.sunk;
		}
		// todo: update if status is none 
		map[locationIndex[0]][locationIndex[1]] = setStatus;
	}

	private ShipDirection getRandomDirection(){
		if((int)(Math.random() * 2) == 0){
			return ShipDirection.x;
		}
		return ShipDirection.y;
	}
	
	private int getRandomStartCellValue(int useLocationSize, int locationMax){
		return (int)(Math.random() * (locationMax - useLocationSize + 1));
	}

	public void printStatusMap(DotCom.LocationStatus[][] map) {
		// todo: print x, y label
		for(int y = 0; y <DotComBust.LOCATION_MAX; y++){
			for(int x = 0; x < DotComBust.LOCATION_MAX; x++){
				switch(map[x][y]){
					case none:
						System.out.print(" o");
						break;
					case miss:
						System.out.print(" m");
						break;
					case hit:
						System.out.print(" h");
						break;
					case sunk:
						System.out.print(" s");
						break;
				}
			}
			System.out.println("");
		}
	}
}
