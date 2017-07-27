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
	
	public Map(){
		
	}
	public Map(int height, int width, int[][] map, int seaLevel) {

		super();
		this.height = height;
		this.width = width;
		this.positions = map;
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
	
	
//	int nextLabel = 1;
//	// Já irei armazenar o número de rótulos
//	// atribuídos, para sabermos quantas figuras
//	// encontramos na imagem.
//	int totalNumLabels = 0;
//	// Abaixo temos o algoritmo para preenchimento
//	// da matriz mRot.
//
//	int [][] mLab = new int[height][width];
//	int [][] map = new int[height][width];
//
//	for(int l=0; l<height; l++)
//	{
//		for(int c=0; c<width; c++)
//		{
//			Boolean landCellP, landCellUnder, landCellLeft;
//			isLandActualCell = map[l][c] > 1;
//			isLandUpperCell = (l > 0) ? map[l][c-1] > 1 : false;
//			isLandLeftCell = (c > 0) ? map[l-1][c] > 1 : false;
//			
//			int leftLabel = isLandCellLeft ? mLab[l][c-1] : 0;
//			int upLabel = isLandUpperCell ? mLab[l-1][c] : 0;
//			
//			int labelP;
//			int actualPos = map[l][c];
//			if(actualPos > 1){
//				if(upLabel == 0 && leftLabel == 0){
//					labelP = nextLabel++;
//					totalNumLabels++;
//				}else if(upLabel == leftLabel){
//					labelP = upLabel;
//				}else if(upLabel == 0 || leftLabel == 0){
//					labelP = (upLabel != 0) ? upLabel : leftLabel;
//				}else if(upLabel != leftLabel){
//				// Atribua a P o rótulo de C
//					labelP = upLabel;
//					mLab[l][c-1] = upLabel;
//					totalNumLabels--;
//				}
//				mLab[l][c] = labelP;	
//			}
//		}
//	}
}
