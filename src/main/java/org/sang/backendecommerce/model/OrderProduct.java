package org.sang.backendecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_products")
public class OrderProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, updatable = false)
	private Long productId;

	@Column(nullable = false, updatable = false)
	private String name;

	@Column(nullable = false, updatable = false)
	private String imageUrl;

	@Column(nullable = false, updatable = false)
	private Double price;

	@Column(nullable = false, updatable = false)
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false, updatable = false)
	private Order order;
}
