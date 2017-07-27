package main;

/**
 * Represents a map
 * @author pamela.beatrizls
 *
 */
public class Map {
	private int height;
	private int width;
	private int positions[][] = {};
	private int seaLevel = 0;
	private int totalAreaIslands = 0;
	private int totalPeremeterIslands = 0;
	private int totalNumberIslands = 0;
	
	public Map(){}
	
	public Map(int height, int width, int[][] map, int seaLevel) {
		super();
		this.height = height;
		this.width = width;
		this.positions = map;
		this.seaLevel = seaLevel;
	}
	
	/**
	 * Calculate the area and perimeter island in a map
	 */
	public void calculateArea_PerimeterIsland(){		
		if (this.positions!= null && this.positions.length > 0) {
			
			for (int ln = 0; ln < this.height; ln++) {
				for (int col = 0; col < this.width; col++) {	
					if(this.positions[ln][col] > 0){
						this.totalAreaIslands += 1;
					}
					this.totalPeremeterIslands +=this.countEdges(ln, col);
				}
			}			
		}
		System.out.println("Output #1 (total area): "  + this.totalAreaIslands);
		System.out.println("Output #2 (total perimeter):"  + this.totalPeremeterIslands);
	}
	
	/**
	 * Count the island edges 
	 * @param line position cell island
	 * @param column position cell island
	 */
	private int countEdges(int line, int column){
		int count = 0;
		if(this.positions[line][column] > 0){
			 
			// Verifies if the portion of land is on some edge of the matrix and counts as perimeter
			if(line == 0 || column ==0 || line == this.height-1 || column == this.width-1){
				count += 1;
			}
			if(line > 0){
				if(this.positions[line-1][column] == 0){ count +=1; }
			}
			if(column > 0){
				if(this.positions[line][column - 1] == 0){count += 1;}
			}
			if(column < this.width-1){
				if(this.positions[line][column + 1] == 0 ){ count +=1;}
			}
			if(line < this.height-1){
				if(this.positions[line+1][column] == 0){ count +=1; }
			}
		}
		return count;
	}
	
	/**
	 * Counts the total islands in a map using labels to mark adjacent portions of land that form a island
	 */
	public void countTotalIslands(){
		int nextLabel = 1;
		int totalNumLabels = 0;

		int [][] mLab = new int[this.height][this.width];
		Boolean isLandActualCell, isLandUpperCell, isLandLeftCell;

		
		// Scan from top to bottom, from left to right, 
		// map positions and label the adjacent terrestrial cells (value> 1) that belong to the same island
		for(int l=0; l<this.height; l++)
		{
			for(int c=0; c<this.width; c++)
			{

				// Verify that the top and left cells are portion of land
				isLandActualCell = this.positions[l][c] > this.seaLevel;
				isLandUpperCell = (l > 0) ? this.positions[l-1][c] > this.seaLevel : false;
				isLandLeftCell = (c > 0) ? this.positions[l][c-1] > this.seaLevel : false;
				
				int leftLabel = isLandLeftCell ? mLab[l][c-1] : 0;
				int upLabel = isLandUpperCell ? mLab[l-1][c] : 0;
				
				int labelP = mLab[l][c];
				if(isLandActualCell){
					if(upLabel == 0 && leftLabel == 0){
						labelP = nextLabel++;
						totalNumLabels++;
					}else if(upLabel == leftLabel){
						labelP = upLabel;
					}else if(upLabel == 0 || leftLabel == 0){
						labelP = (upLabel != 0) ? upLabel : leftLabel;
					}else if(upLabel != leftLabel){
						labelP = upLabel;
						mLab[l][c-1] = upLabel;
						totalNumLabels--;
					}
					mLab[l][c] = labelP;	
				}
			}
		}
		System.out.println("Output #3 (number of islands): "+ totalNumLabels);
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int[][] getPositions() {
		return positions;
	}
	public void setPositions(int[][] map) {
		this.positions = map;
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
