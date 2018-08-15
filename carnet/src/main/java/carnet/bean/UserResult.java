package carnet.bean;

import java.util.List;

public class UserResult {
    private  int id;
    private  List<String> data;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<String> getData() {
		return data;
	}
	public void setData(List<String> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "UserResult [id=" + id + ", data=" + data + "]";
	}
    
}
