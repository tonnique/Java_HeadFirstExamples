import java.util.ArrayList;

public class DotComBurst {
	
	// ��������� � ������������� ���������, ������� ��� �����������
	ArrayList<DotCom> dotComList = new ArrayList();
	int numOfGuesses = 0;
	
	String[] dotComNames = new String[] {"Pets.com", "eToys.com", "Go2.com"};
	
	public DotComBurst() { }
	
	public void setUpGame() {
		
		// ������� ������� ���������� ��� ������������
		System.out.println("���� ���� �������� " + dotComNames.length + " ������");
		
		// �������� �����, �������� �� ������ � ������� � ������ ������ 		
		for (int i = 0; i < dotComNames.length; i++) {
			
			DotCom dotCom = new DotCom(); // ������� ����			 
			dotCom.setName(dotComNames[i]); // ����������� ���
			
			// ������� ����� ������ ��� ������������
			if (i < dotComNames.length -1) System.out.print(dotComNames[i] + ", ");
			else { System.out.print(dotComNames[i]); }
			
			dotComList.add(dotCom); // ��������� � ������ ������
			ArrayList<String> newLocation = GameHelper.placeDotCom(3); // ��������� ���� �� ������� ����
			dotCom.setLocationsCells(newLocation);
		}
				
		System.out.println("\n����������� �������� �� �� ����������� ���-�� �����.");		
	}
	
	
	private void startPlaying() {
		// �� ��� ��� ���� ������ �������� DotCom �� ������ ������
		
		while(!dotComList.isEmpty()) {
			// �������� ���������������� ����
			String userGuess = GameHelper.getUserInput("�������� ��� ");
			checkUserGuess(userGuess);			
		}
		finishGame();
	}
	
	private void checkUserGuess(String guess) {
		// ����������� ���-�� ������� ������������
		numOfGuesses++;
		String result = "����"; // �� ��������� ������������� ������
		
		// ��������� ��� ��� �������� DotCom � ������
		for (DotCom dotComToTest : dotComList) {
			// ������ DotCom ��������� ��� ������������, ���� ��������� (��� ����������)
			result = dotComToTest.checkYourself(guess);
			if (result.equals("�����")) {
				// ���������� �� �����, - ��� ������ ��������� ������ �����
				break;
			} 
			if (result.equals("�������")) {
				// ���� ���� �������� - ������ ������� ��� �� ������ � ������� �� �����
				dotComList.remove(dotComToTest);
				break;
			}
		}
		// ������� ��� ������������ ���������
		System.out.println(result);
	}
	
	private void finishGame() {
		System.out.println("��� ������ ���� �� ���!");
		if (numOfGuesses <= 18) {
			System.out.println("��� ������ � ��� ����� " + numOfGuesses + " �������.");
			System.out.println("�� ������ ��������� �� ����, ��� ���� �������� �������.");
		} else {
			System.out.println("��� ������ � ��� �������� ����� �������. " + numOfGuesses + " �������.");
			System.out.println("���� ����� �������� ������ ����� ��������.");
		}		
	}
	
	public static void main(String[] args) {
		DotComBurst game = new DotComBurst();
		game.setUpGame();
		game.startPlaying();
	}
}
