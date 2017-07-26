
package main;

import java.util.Scanner;

public class IslandCalculator {
	private static Map map;
	private static int height;
	private static int width;
	private static int option;
	private static Scanner in;
	private static OptionMenu optionMenu;
	
	private enum OptionMenu{
		INPUT_MAP(1), EXIT(2);
		
		private final int value;
		OptionMenu(int valorOpcao){
			value = valorOpcao;
		}
		public int getValue(){
			return value;
		}
	}
		
	public static void main(String[] args) {		
		in = new Scanner(System.in);
		init();
		printMapInformation();
	}
	
	
	private static void init(){		
		
		System.out.println("Welcome to Island Calculator. Please choose a option bellow.");
		System.out.println("1 - INPUT A MAP");
		System.out.println("2 - EXIT");
		option = in.nextInt();

		
		do {
			System.out.flush();
			System.out.println("Invalid option!");
			System.out.println("");
			System.out.println("Welcome to Island Calculator. Please choose a option bellow.");
			System.out.println("1 - INPUT A MAP");
			System.out.println("2 - EXIT");
			option = in.nextInt();
			
		} while (option == 0);
		
		
		if (option == optionMenu.INPUT_MAP.value){
			System.out.flush();
			System.out.println("Put the map dimensions");
			System.out.println("Height:");
			height = in.nextInt();
			System.out.println("Width:");
			width = in.nextInt();
			
			//TODO validar qndo a altura e largura forem invalidas
			
			readMap();
			
		}
		else if(option == optionMenu.EXIT.value){
			in.close();
			System.exit(0);
		}			
		
	}
	
	private static void readMap(){
		
		int mapTemp[][]= {};
		
		System.out.flush();
		System.out.println("Reading map ...");
	
		for (int col = 0; col < height; col++) {
			for (int ln = 0; ln < width; ln++) {
				mapTemp[col][ln] = in.nextInt();
			}
		}
		
		map.setMap(mapTemp);
		
		System.out.flush();
		System.out.println("----- Map inserted -----");
		for (int col = 0; col < height; col++) {
			for (int ln = 0; ln < width; ln++) {
				System.out.println(mapTemp[col][ln]);
			}
		}
	}
	
	private static void printMapInformation(){
		System.out.flush();
		System.out.println("-- Map informations ----");
		System.out.println("- Total area island(s) at default sea level: "+ map.getTotalAreaIslands());
		System.out.println("- Total peremeter island(s) at default sea level: "+ map.getTotalPeremeterIslands());
		System.out.println("- Total number island(s) at sea level 1: "+ map.getTotalNumberIslands());
	}

}
