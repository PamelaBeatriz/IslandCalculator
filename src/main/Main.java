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
		Supplier<Stream<String>> supplier;
		int [][] mapAux;
			supplier = () -> Files.lines(path, StandardCharsets.UTF_8);
			int width = supplier.get().findFirst().get().length();
			int height = (int) supplier.get().count();
			mapAux = new int[height][width];
			supplier.get().forEach(line -> {
				cells = line.split(" ");
				for(int i = 0; i < cells.length; i++){
					mapAux[count][i] = Integer.parseInt(cells[i]);
				}
				count++;
			});
			Map map = new Map(height, width, mapAux, seaLevel);
			//map.countIslands();
			for(int i = 0; i < height; i++){
				for(int j = 0; j < width; j++){
					System.out.println(mapAux[i][j]);
				}
			}
			System.out.println();		
	}

}
