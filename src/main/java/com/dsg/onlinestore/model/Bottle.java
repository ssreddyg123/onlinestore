package com.dsg.onlinestore.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BOTTLES")
public class Bottle {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "name must be set")
    @NotEmpty(message = "name not there")
	@Pattern(regexp = "(a-zA-Z0-9)", message = "name must be alphanumeric.")
	private String name;
	
	@NotNull
    @Pattern(regexp = "(https:\\/\\/).*\\.(?:jpg|gif|png)", message = "Must be a valid URL to a picture.")
	private String bottlePic;
	
	@Min(value = 1, message = "Volume minimum is 1")
	@Positive
	private double volume;
	
	@AssertTrue
	private boolean isAlcoholic;
	@Positive
	private double volumePercent;
	@Positive
	private int price;
	
	@NotNull(message = "supplier must be set")
    @NotEmpty(message = "supplier not there")
	private String supplier;
	
	@PositiveOrZero
	private int inStock;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "beverage_id")
    private Beverage beverage;

}
