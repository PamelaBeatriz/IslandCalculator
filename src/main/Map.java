package main;

/**
 * Represents a map
 * @author pamela.beatrizls
 *
 */
public class Map {
	private int height;
	private int width;
	private int map[][] = {};
	private int seaLevel = 0;
	private int totalAreaIslands = 0;
	private int totalPeremeterIslands = 0;
	private int totalNumberIslands = 0;
	
	public Map(){
		
	}
	
	public Map(int height, int width, int[][] map, int seaLevel) {
		super();
		this.height = height;
		this.width = width;
		this.map = map;
		this.seaLevel = seaLevel;
	}
	
	public int countIslands(){
		/*for(int y = 0; y < map.length; y++){
			for(int x = 0; x < map.)
		}*/
		return 0;
	}
	
	//calculateArea(islands), calculatePerimeter(islands), countIslands()
	
	//public void
	
	public int getHeigh() {
		return height;
	}
	public void setHeigh(int heigh) {
		this.height = heigh;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int[][] getMap() {
		return map;
	}
	public void setMap(int[][] map) {
		this.map = map;
	}
	public int getSeaLevel() {
		return seaLevel;
	}
	public void setSeaLevel(int seaLevel) {
		this.seaLevel = seaLevel;
	}
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getTotalAreaIslands() {
		return totalAreaIslands;
	}

	public void setTotalAreaIslands(int totalAreaIslands) {
		this.totalAreaIslands = totalAreaIslands;
	}

	public int getTotalPeremeterIslands() {
		return totalPeremeterIslands;
	}

	public void setTotalPeremeterIslands(int totalPeremeterIslands) {
		this.totalPeremeterIslands = totalPeremeterIslands;
	}

	public int getTotalNumberIslands() {
		return totalNumberIslands;
	}

	public void setTotalNumberIslands(int totalNumberIslands) {
		this.totalNumberIslands = totalNumberIslands;
	}
	
}
