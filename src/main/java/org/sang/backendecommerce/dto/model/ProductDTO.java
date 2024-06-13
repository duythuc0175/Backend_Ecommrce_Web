package org.sang.backendecommerce.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private Long id;
	private String name;
	private String description;
	private double price;
	private String imageUrl;
	private int stock;
}
