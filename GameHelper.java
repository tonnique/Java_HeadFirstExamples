import java.util.ArrayList;
import java.util.Scanner;

public class GameHelper {
	private static Scanner scanner = new Scanner(System.in);
	
	private static final String alphabet = "abcdefg";
	private static int gridLength = 7;
	private static int gridSize = 49;
	private static int[] grid = new int[gridSize];
	private static int comCount = 0;
	
	
	public static String getUserInput(String promt) {
		String inputLine = null;
		System.out.print(promt + "  ");
		inputLine = scanner.nextLine();
		if (inputLine.length() == 0) return null;
		else return inputLine;
	}
	
	public static ArrayList<String> placeDotCom(int comSize)
	{
		ArrayList<String> alphaCells = new ArrayList<String>();
		String[] alphacoords = new String[comSize];	// ������ ���������� ���� f6
		String temp = null; // ��������� ������ ��� ������������
		int[] coords = new int[comSize]; // ���������� �������� �����
		int attempts = 0; // ������� ������� �������
		boolean success = false; // ����� ���������� ��������������
		int location = 0; // ������� ��������� ��������������
		
		comCount++; // ����� ���� ��� ����������
		int incr = 1;  // ������������� �������������� ���������
	
		if ((comCount % 2) == 1) { // ���� �������� (��������� �����������)
			incr = gridLength;	// ������������� ������������ ���������
		}
		
		while (!success & attempts++ < 200 ) { // ������� ��������� ����			
			location = (int) (Math.random() * gridSize); // �������� ��������� ��������� �����
			//System.out.println("������� " + location);
			int x = 0;  // ����� ������� � �����, ������� ����� ����������
			success = true;  // ������������ �������� �����
			
			while (success && x < comSize)  { // ���� �������� ���������������� ������
			
				if (grid[location] == 0) {  // ���� ��� �� ������������
					coords[x++] = location;  // ��������� ��������������
					location += incr; // ������� ��������� �������� ������
					
					if (location >= gridSize) {
						success = false; // �������
					}
					
					if (x > 0 && (location % gridLength == 0)) { // ����� �� ����� - ������ ����
						success = false;	// �������
					}
					
				} else {
					// System.out.println("������������ " + location);
					success = false;
				}					
			}
		}
		
		int x = 0; // ��������� �������������� � ���������� ����������
		int row = 0;
		int column = 0;			
		//System.out.println("\n");
			
		while (x < comSize) {
			grid[coords[x]] = 1;	// �������� ������ �� ������� ����� ��� "��������������"
			row = (int) (coords[x] / gridLength);  // �������� �������� ����
			column = coords[x] % gridLength; // �������� �������� �������
			temp = String.valueOf(alphabet.charAt(column)); // ����������� ��� � ��������� ������
			
			alphaCells.add(temp.concat(Integer.toString(row)));
			x++;
			
			//System.out.println("  coord " + x + " = " + alphaCells.get(x-1));				
		}		
		//System.out.println();
		return alphaCells;
	}		
}


