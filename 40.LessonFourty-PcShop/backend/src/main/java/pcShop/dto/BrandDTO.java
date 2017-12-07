package pcShop.dto;

import pcShop.model.Brand;

public class BrandDTO {
	private Long id;
	private String name;

	public BrandDTO() {

	}

	public BrandDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public BrandDTO(Brand brand) {
		this.id = brand.getId();
		this.name = brand.getName();
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
