
public class CellforAITracking {
	
	private Cell selectedCell;
	private Cell parentCell;
	private int calculatedCost;

	public CellforAITracking(Cell self, Cell parent) {
		selectedCell = self;
		parentCell = parent;
	}
	
	public Cell getSelectedCell() {
		return selectedCell;
	}
	
	public Cell getParentCell() {
		return parentCell;
	}
	
	public int getCalculatedCost() {
		return calculatedCost;
	}
	
	public void setCalculatedCost(int cc) {
		calculatedCost = cc;
	}

}
