package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
	static String [] cells = {};
	static int count = 0;
	final static int seaLevel = 1;
	
	public static void main(String[] args) throws IOException {
		Path path = FileSystems.getDefault().getPath("map.txt");
		Stream<String> lines;
		int [][] mapAux;
			lines = Files.lines(path, StandardCharsets.UTF_8);
			int width = lines.findFirst().get().length();
			lines.close();
			lines = Files.lines(path, StandardCharsets.UTF_8);
			int height = (int) lines.count();
			lines = Files.lines(path, StandardCharsets.UTF_8);
			mapAux = new int[height][width];
			lines.forEach(line -> {
				cells = line.split(" ");
				for(int i = 0; i < cells.length; i++){
					mapAux[count][i] = Integer.parseInt(cells[i]);
				}
				count++;
			});
			lines.close();
			Map map = new Map(height, width, mapAux, seaLevel);
			//map.countIslands();
			for(int i = 0; i < height; i++){
				for(int j = 0; j < width; j++){
					System.out.print(mapAux[i][j]);
				}
				System.out.println("");
			}
			System.out.println();		
	}

}
