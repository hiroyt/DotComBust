import java.util.ArrayList;


public class DotComBustTestDrive {
	static final String OK = ": OK";
	static final String FAIL = ": FAIL";
	
	public static void main(String[] args){
//		setUpGameTest();
//		startPlayTest();
//		finishGameTest();
		appDemo();
	}

	private static void setUpGameTest(){
		ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
		DotComBust dotComBust = new DotComBust();
		final String TEST_NAME = "setUpGameTest";
		ArrayList<String> expectLocationList = new ArrayList<String>();
		
		for(int i = 0; i < DotComBust.SHIP_NUMBER; i++){
			expectLocationList.add("A" + Integer.toString(i));
		}

		dotComBust.setUpGame(dotComList);
		for(int i = 0; i < DotComBust.SHIP_NUMBER; i++){
			// verify name
			String expectShipName = Integer.toString(i) + ".com";
			String actualShipName = dotComList.get(i).getName();
			if(!actualShipName.equals(expectShipName)){
				printError(TEST_NAME, "ship name"
						, expectShipName, actualShipName);
				return;
			}
			// verify location
			System.out.print(dotComList.get(i).getName() + ": ");
			ArrayList<String> actualLocationList 
				= dotComList.get(i).getLocationList();
			for(int shipPart = 0; shipPart < DotCom.SHIP_SIZE; shipPart++){
				char locationX = actualLocationList.get(shipPart).charAt(0);
				if((locationX < 'A') || (locationX > 'G')){
					printError(TEST_NAME, "location X"
							, "A-G", String.valueOf(locationX));
					return;
				}
				
				char locationY = actualLocationList.get(shipPart).charAt(1);
				if((locationY < '0') || (locationY > '6')){
					printError(TEST_NAME, "location Y"
							, "0-6", String.valueOf(locationY));
					return;
				}
				System.out.print(actualLocationList.get(shipPart));
			}
			System.out.println();
		}
		System.out.println(TEST_NAME + OK);
	}
	
	private static void startPlayTest(){
		final String TEST_NAME = "startPlayTest";

		ArrayList<String> location = new ArrayList<String>();
		location.add("A0");
		location.add("A1");
		location.add("A2");
		
		DotCom dotCom = new DotCom();
		dotCom.setLocation(location);
		dotCom.setName("test.com");

		ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
		dotComList.add(dotCom);

		DotComBust dotComBust = new DotComBust();
		dotComBust.startPlay(dotComList);
		dotComBust.finishGame();
		System.out.println(TEST_NAME + OK);
	}
	
	private static void finishGameTest(){
		final String TEST_NAME = "finishGameTest";
		DotComBust dotComBust = new DotComBust();
		ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
		dotComBust.setUpGame(dotComList);
		dotComBust.startPlay(dotComList);
		dotComBust.finishGame();
		System.out.println(TEST_NAME + OK);
	}
	
	private static void appDemo(){
		final String TEST_NAME = "appDemo";
		ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
		DotComBust dotComBust = new DotComBust();
		dotComBust.setUpGame(dotComList);
		dotComBust.startPlay(dotComList);
		dotComBust.finishGame();
		System.out.println(TEST_NAME + " finish");
	}
	
	private static void printError(String testName
			, String type
			, String expectVal
			, String actualVal){
		System.out.println(testName + " FAIL\n"
				+ type + ", "
				+ "Expect = " + expectVal + ", "
				+ "Actual = " + actualVal);	
	}
}
