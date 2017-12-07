package pcShop.dto;

import pcShop.model.ComponentType;

public class ComponentTypeDTO {
	private Long id;
	private String name;

	public ComponentTypeDTO() {

	}

	public ComponentTypeDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public ComponentTypeDTO(ComponentType componentType) {
		this.id = componentType.getId();
		this.name = componentType.getName();
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
}
