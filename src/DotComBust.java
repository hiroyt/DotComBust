import java.util.ArrayList;

public class DotComBust {
	public static final int LOCATION_MAX = 7;
	public static final int SHIP_NUMBER = 2;
	public static final String GAME_TITLE = "DotComBust";
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
			// todo: print current result by location map.
		}
	}
	
	private void checkUserGuess(ArrayList<DotCom> dotComList
			, String location){
		String message = DotCom.MISS;
		for(DotCom dotCom: dotComList){
			String result = dotCom.fire(location);
			if(result.equals(DotCom.SUNK)){
				message = dotCom.getName() + " " +  DotCom.SUNK + "!";
				dotComList.remove(dotCom);
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
	
}
