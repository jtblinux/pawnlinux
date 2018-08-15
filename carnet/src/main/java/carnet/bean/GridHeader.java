package carnet.bean;

public class GridHeader {
//    private int width=70;
    private String type="co";  //dyn,ed,ed,price,ch,co
    private String align="left"; //center,left,right
    private String sort="str";  //int,str
    private String value; //
//	public int getWidth() {
//		return width;
//	}
//	public void setWidth(int width) {
//		this.width = width;
//	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAlign() {
		return align;
	}
	public void setAlign(String align) {
		this.align = align;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "GridHeader [ type=" + type + ", align=" + align + ", sort=" + sort + ", value="
				+ value + "]";
	}
        
}
