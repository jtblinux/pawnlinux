package carnet.bean;

import java.util.List;

public class Grid {
    private   List<GridHeader> head;
    private   List<GridRow>  rows;
	public List<GridHeader> getHead() {
		return head;
	}
	public void setHead(List<GridHeader> head) {
		this.head = head;
	}
	public List<GridRow> getRows() {
		return rows;
	}
	public void setRows(List<GridRow> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "Grid [head=" + head + ", rows=" + rows + "]";
	}
    
}
