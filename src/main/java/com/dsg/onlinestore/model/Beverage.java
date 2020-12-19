package com.dsg.onlinestore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BEVERAGES")
public class Beverage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long beverageId;

	@NotNull(message = "type must be set")
	private String type;

	@OneToMany(mappedBy = "beverage", cascade = { CascadeType.ALL  })
	private List<Bottle> bottles;

	@OneToMany(mappedBy = "beverage", cascade = { CascadeType.ALL  })
	private List<Crate> crates;

}
