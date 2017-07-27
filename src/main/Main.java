package main;

import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

public class Main {
	private static String [] cells = {};
	private static int count = 0;
	private final static int seaLevel = 1;
	private static String fileName = "";
	
	public static void main(String[] args) throws IOException {
		fileName="map.txt";
		
		try{		
			Path path = FileSystems.getDefault().getPath(fileName);		
			
			int [][] mapAux;
			List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
			int height = allLines.size();
			int width = allLines.get(0).split(" ").length;
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
			
		} catch (NoSuchFileException e){
			System.out.println("File '"+ fileName +"' not found.");
			
		} catch (MalformedInputException m){
			System.out.println("The file '"+ fileName +"' has a incorrect format. Just '.txt' files are valid.");
		}
	}

}
