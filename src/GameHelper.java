import java.io.*;
import java.util.ArrayList;

public class GameHelper {
	private enum ShipDirection{x, y};

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

	public ArrayList<String> getRandomLocation(){
		ArrayList<String> locationList = new ArrayList<String>();
		ShipDirection shipDirection = getRandomDirection();
		char xCell = 'A';
		char yCell = '0';		
		if(shipDirection == ShipDirection.x){
			xCell += getRandomStartCellValue(DotCom.SHIP_SIZE, DotComBust.LOCATION_MAX);
			yCell += getRandomStartCellValue(1, DotComBust.LOCATION_MAX);
		}
		else{
			xCell += getRandomStartCellValue(1, DotComBust.LOCATION_MAX);
			yCell += getRandomStartCellValue(DotCom.SHIP_SIZE, DotComBust.LOCATION_MAX);
		}
		for(int i = 0; i < DotComBust.SHIP_NUMBER; i++){
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
