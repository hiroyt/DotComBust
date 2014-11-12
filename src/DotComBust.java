import java.util.ArrayList;

public class DotComBust {
	public static final int LOCATION_MAX = 7;
	public static final int SHIP_NUMBER = 3;
	public static final String GAME_TITLE = "DotComBust";
//	private String allLocation;
	private int fireCount;
	GameHelper helper;
	
	public void setUpGame(ArrayList<DotCom> dotComList){
		helper = new GameHelper();
		printStartMessage();
		fireCount = 0;
		for(int i = 0; i < SHIP_NUMBER; i++){
			DotCom dotCom = new DotCom();
			dotCom.setName(Integer.toString(i) + ".com");
			dotCom.setLocation(helper.getRandomLocation());
			dotComList.add(dotCom);
		}
	}
	
	private void printStartMessage(){
		String message = new String();
		message = "=== " + GAME_TITLE + " start ====\n";
		message += "There are " + SHIP_NUMBER + " ship target.\n";
		message += "Guess ships location.\n";
		System.out.println(message);
	}
	
	public void startPlay(ArrayList<DotCom> dotComList){
		while(!dotComList.isEmpty()){
			fireCount++;
			// todo: ユーザ入力を有効にする
//			String location = helper.getUserInput("enter ship location");
			String location = "A1";
			// todo: checkUserGess()にlocationを渡す
			checkUserGuess(dotComList, location);
		}
	}
	
	private void checkUserGuess(ArrayList<DotCom> dotComList
			, String location){
		// todo: 判定処理を実装する
		dotComList.remove(0);
	}
	
	public void finishGame(){
		String message = new String();
		message = "=== " + GAME_TITLE + " end ====\n";
		message += "you fired " + fireCount + " times.\n";
		// todo: 評価内容の表示
		System.out.print(message);
	}
	
	public void play(){
//		ArrayList<String> shipLocation = new ArrayList<String>();
//		SimpleDotCom ship = new SimpleDotCom();
//		int startLocation;
//		String fireLocation;
//		String result;
//		
//		startLocation = (int)(Math.random()
//				* (LOCATION_MAX - SimpleDotCom.SHIP_SIZE));
//		for(int i=0; i<SimpleDotCom.SHIP_SIZE; i++){
//			shipLocation.add(Integer.toString(startLocation + i));
//		}
//		ship.setLocation(shipLocation);
//		getAllLocation(shipLocation);
//
//		for(fireCount = 1; ; fireCount++){
//			fireLocation = helper.getUserInput("enter ship location");
//			result = ship.fire(fireLocation);
//			System.out.println(result);
//			if(result.equals(SimpleDotCom.SUNK)){
//				break;
//			}
//		}
//		System.out.println("triy count = " + fireCount);
//		printAllLocation();
	}
	
	
	
//	private void getAllLocation(ArrayList<String> location){
//		allLocation = "ship location is [ ";
//		for(int i=0; i<location.size(); i++){
//			allLocation += location.get(i);
//			if(i == (location.size() - 1)){
//				allLocation += " ]";
//			}
//			else{
//				allLocation += ", ";
//			}
//		}
//	}
//	private void printAllLocation(){
//		System.out.println(allLocation);
//	}
}
