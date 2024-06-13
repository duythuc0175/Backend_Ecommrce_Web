package org.sang.backendecommerce.model;

import jakarta.persistence.*;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carts")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private Long userId;

	@Column(nullable = false)
	private Double total;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<CartProduct> cartProducts;

}
