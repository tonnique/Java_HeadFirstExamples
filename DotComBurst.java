import java.util.ArrayList;

public class DotComBurst {
	
	// Объявляем и инициалзируем перменные, которые нам понадобятся
	ArrayList<DotCom> dotComList = new ArrayList();
	int numOfGuesses = 0;
	
	String[] dotComNames = new String[] {"Pets.com", "eToys.com", "Go2.com"};
	
	public DotComBurst() { }
	
	public void setUpGame() {
		
		// выводим краткие инструкции для пользователя
		System.out.println("Ваша цель потопить " + dotComNames.length + " сайтов");
		
		// создадим сайты, присвоим им адреса и добавим в список сайтов 		
		for (int i = 0; i < dotComNames.length; i++) {
			
			DotCom dotCom = new DotCom(); // создаем сайт			 
			dotCom.setName(dotComNames[i]); // присваиваем имя
			
			// выводим имена сайтов для пользователя
			if (i < dotComNames.length -1) System.out.print(dotComNames[i] + ", ");
			else { System.out.print(dotComNames[i]); }
			
			dotComList.add(dotCom); // добавляем в список сайтов
			ArrayList<String> newLocation = GameHelper.placeDotCom(3); // размещаем сайт на игровом поле
			dotCom.setLocationsCells(newLocation);
		}
				
		System.out.println("\nПопытайтесь потопить их за минимальное кол-во ходов.");		
	}
	
	
	private void startPlaying() {
		// до тех пор пока список объектов DotCom не станет пустым
		
		while(!dotComList.isEmpty()) {
			// получаем пользовательский ввод
			String userGuess = GameHelper.getUserInput("Сделайте ход ");
			checkUserGuess(userGuess);			
		}
		finishGame();
	}
	
	private void checkUserGuess(String guess) {
		// увеличиваем кол-во попыток пользователя
		numOfGuesses++;
		String result = "Мимо"; // по умолчанию подразумеваем промах
		
		// повторяем это для объектов DotCom в списке
		for (DotCom dotComToTest : dotComList) {
			// просим DotCom проверить ход пользователя, ищем попадание (или потопление)
			result = dotComToTest.checkYourself(guess);
			if (result.equals("Попал")) {
				// выбираемся из цикла, - нет смысла проверять другие сайты
				break;
			} 
			if (result.equals("Потопил")) {
				// этот сайт потоплен - теперь удаляем его из списка и выходим из цикла
				dotComList.remove(dotComToTest);
				break;
			}
		}
		// выводим для пользователя результат
		System.out.println(result);
	}
	
	private void finishGame() {
		System.out.println("Все стайты ушли ко дну!");
		if (numOfGuesses <= 18) {
			System.out.println("Это заняло у вас всего " + numOfGuesses + " попыток.");
			System.out.println("Вы успели выбраться до того, как ваши вложения утонули.");
		} else {
			System.out.println("Это заняло у вас довольно много времени. " + numOfGuesses + " попыток.");
			System.out.println("Рыбы водят хороводы вокруг ваших вложений.");
		}		
	}
	
	public static void main(String[] args) {
		DotComBurst game = new DotComBurst();
		game.setUpGame();
		game.startPlaying();
	}
}
