import java.util.ArrayList;

public class DotComBust {
	public static final int LOCATION_MAX = 7;
	public static final int SHIP_NUMBER = 3;
	public static final String GAME_TITLE = "DotComBust";
//	private String allLocation;
	private int fireCount;
	GameHelper helper;
	
	public DotComBust(){
		helper = new GameHelper();
	}
	
	public void setUpGame(ArrayList<DotCom> dotComList){
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
			checkUserGuess(dotComList
					, helper.getUserInput("enter ship location"));
		}
	}
	
	private void checkUserGuess(ArrayList<DotCom> dotComList
			, String location){
		int listNum = dotComList.size();
		String message = DotCom.MISS;
		for(int i = 0; i < listNum; i++){
			DotCom dotCom = dotComList.get(i);
			String result = dotCom.fire(location);
			if(result.equals(DotCom.SUNK)){
				message = dotCom.getName() + " " +  DotCom.SUNK + "!";
				dotComList.remove(i);
				break;
			}
			else if(result.equals(DotCom.HIT)){
				message = dotCom.getName() + " " +  DotCom.HIT + "!";
				break;
			}
		}
		System.out.println(message);
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
