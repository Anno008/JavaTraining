package wrappers;

import java.util.ArrayList;
import java.util.List;

import models.BaseModel;

public class BaseWrapper<T extends BaseModel> {
	
	public BaseWrapper(List<T> list){
		this.list = list;
	}
	
	private List<T> list = new ArrayList<T>();
	
	public List<T> getAll(){
		return list;
	}
	
	public void add(T obj) {
		list.add(obj);
	}
	
	public T find(int key){
		return list.stream().filter(i -> i.getId() == key).findFirst().orElse(null);
	}
	
	public void update(T obj){
		 obj.update(obj);
	}
	
	public void delete(T obj){
		list.remove(obj);
	}
}
