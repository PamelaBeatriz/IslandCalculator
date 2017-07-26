package main;

/**
 * Represents a island
 * @author pamela.beatrizls
 *
 */
public class Island {
	private int area;
	private int perimeter;
	
	
	public Island(int area, int perimeter, int numVisibleIsland) {
		super();
		this.area = area;
		this.perimeter = perimeter;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getPerimeter() {
		return perimeter;
	}

	public void setPerimeter(int perimeter) {
		this.perimeter = perimeter;
	}
		
}
