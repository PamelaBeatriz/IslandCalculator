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
		
	public void calculateArea_PerimeterIsland(){		
		if (this.positions!= null && this.positions.length > 0) {
			
			for (int ln = 0; ln < this.height; ln++) {
				for (int col = 0; col < this.width; col++) {	
					if(this.positions[ln][col] > 0){
						this.totalAreaIslands += 1;
					}
					if(this.countNestLand(ln, col) < 4){
						this.totalPeremeterIslands +=1;
					}
				}
			}			
		}
		System.out.println("Output #1 (total area): "  + this.totalAreaIslands);
		System.out.println("Output #2 (total permiter):"  + this.totalPeremeterIslands);
	}
	
	private int countNestLand(int ln, int col){
		int count = 0;
		
		if(ln > 0){
			if(this.positions[ln-1][col] > 0){ count +=1; }
		}
		if(col > 0){
			if(this.positions[ln][col - 1] > 0){count += 1;}
		}		
		if(this.positions[ln][col + 1] > 0 ){ count +=1;}
		if(this.positions[ln+1][col] > 0){ count +=1; }
		
		return count;
	}
	
	public void countTotalIslands(){
		int nextLabel = 1;
		int totalNumLabels = 0;

		int [][] mLab = new int[this.height][this.width];
		Boolean isLandActualCell, isLandUpperCell, isLandLeftCell;

		for(int l=0; l<this.height; l++)
		{
			for(int c=0; c<this.width; c++)
			{
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
