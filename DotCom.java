import java.util.ArrayList;

public class DotCom {
	
	private ArrayList<String> locationCells;
	private String name; 
	
	public void setName(String n) {
		name = n;
	}
	
	public void setLocationsCells(ArrayList<String> locs) {
		locationCells = locs;
	}
	
	public String checkYourself(String userInput){	
		
		String result = "Мимо!";
		
		int index = locationCells.indexOf(userInput);
		
		if (index >= 0) {
			locationCells.remove(index);
			
			if (locationCells.isEmpty()) {
				result = "Потопил";
			}
			else {
				result = "Попал";
			}
		}				
		return result;
	}	
}
