package models;

public class BaseModel {
	private int id;
	
	public BaseModel(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void update(BaseModel other){
		this.id = other.id;
	}
}
