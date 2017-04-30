package models;

public class Publisher extends BaseModel {
	private String name;
	
	public Publisher(int id, String name){
		super(id);
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void update(String name){
		this.name = name;
	}
	
	@Override
	public String toString(){
		return "Id: " + getId() + ", " + name;
	}
}
