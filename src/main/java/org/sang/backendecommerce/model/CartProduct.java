package org.sang.backendecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart_products")
public class CartProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long productId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String imageUrl;

	@Column(nullable = false)
	private double price;

	@Column(nullable = false)
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private Cart cart;
}
