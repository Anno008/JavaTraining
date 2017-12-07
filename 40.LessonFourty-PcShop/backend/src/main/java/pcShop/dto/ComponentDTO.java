package pcShop.dto;

import pcShop.model.Component;

public class ComponentDTO {
	private Long id;
	private String name;
	private double price;
	private BrandDTO brand;
	private ComponentTypeDTO componentType;

	public ComponentDTO() {

	}

	public ComponentDTO(Long id, String name, double price, BrandDTO brand, ComponentTypeDTO componentType) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.componentType = componentType;
	}

	public ComponentDTO(Component component) {
		this.id = component.getId();
		this.name = component.getName();
		this.price = component.getPrice();
		this.brand = new BrandDTO(component.getBrand());
		this.componentType = new ComponentTypeDTO(component.getComponentType());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public BrandDTO getBrand() {
		return brand;
	}

	public void setBrand(BrandDTO brand) {
		this.brand = brand;
	}

	public ComponentTypeDTO getComponentType() {
		return componentType;
	}

	public void setComponentType(ComponentTypeDTO componentType) {
		this.componentType = componentType;
	}
}
