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
	
	private ShipDirection getRandomDirection(){
		if((int)(Math.random() * 2) == 0){
			return ShipDirection.x;
		}
		return ShipDirection.y;
	}
	
	private int getRandomStartCellValue(int useLocationSize, int locationMax){
		return (int)(Math.random() * (locationMax - useLocationSize + 1));
	}
}
