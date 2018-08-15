package carnet.bean;

import java.util.List;

public class TableInfo {
    private int id;
    private String text;
    private List<TableInfo>  item;
    private int  child;  //判断是否有子代 1=有，0=没有
    
	public int getChild() {
		return child;
	}
	public void setChild(int child) {
		this.child = child;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public List<TableInfo> getItem() {
		return item;
	}
	public void setItem(List<TableInfo> item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "TableInfo [id=" + id + ", text=" + text + ", item=" + item + ", child=" + child + "]";
	}
	
    
}
