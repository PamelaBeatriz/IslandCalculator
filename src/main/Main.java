package main;

import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

/**
 * Main application class
 * @author pamela.beatrizls
 *
 */
public class Main {
	private static String [] cells = {};
	private static int count = 0;
	private final static int seaLevel = 1;
	private static String fileName = "";
	
	public static void main(String[] args) throws IOException {
		fileName="map.txt";
		
		try{		
			int [][] mapAux;
			Path path = FileSystems.getDefault().getPath(fileName);	
			
			List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
			int height = allLines.size();
			int width = allLines.get(0).split(" ").length;
			
			if(height == 0 || width == 0 ){ 
				System.out.println("Error: It File must have blank spaces between the values. E.g.: 1 0 2 1");
				
			} else {				
				mapAux = new int[height][width];
				allLines.forEach(line -> {
					cells = line.split(" ");
					for(int i = 0; i < cells.length; i++){
						mapAux[count][i] = Integer.parseInt(cells[i]);
					}
					count++;
				});
				Map map = new Map(height, width, mapAux, seaLevel);
				map.calculateArea_PerimeterIsland();
				map.countTotalIslands();
			}			
			
		} catch (NoSuchFileException e){
			System.out.println("Error: File '"+ fileName +"' not found.");
			
		} catch (MalformedInputException m){
			System.out.println("Error: The file '"+ fileName +"' has a incorrect format. Just '.txt' files are valid.");
		} catch (NumberFormatException n){
			System.out.println("Error: It File must have just integer values");
		}
	}
}
