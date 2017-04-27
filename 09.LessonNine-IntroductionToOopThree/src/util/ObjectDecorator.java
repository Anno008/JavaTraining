package util;

public class ObjectDecorator<T> {
	private T obj;
	private String output;

	public ObjectDecorator(T obj, String output) {
		this.obj = obj;
		this.output = output;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

}
