package carnet.bean;

public class ResponseResult<T> {
	private String msg;
	private int state;// 0-ok,1=error
	private T data;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseResult [msg=" + msg + ", state=" + state + ", data=" + data + "]";
	}

}
