package com.dsg.onlinestore.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ADDRESSSES")
public class Address {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "street must be set")
    @NotEmpty(message = "street not there")
	private String street;
	
	@NotNull(message = "number must be set")
    @NotEmpty(message = "number not there")
	private String number;
	
	@NotNull(message = "number must be set")
    @NotEmpty(message = "number not there")
	@Size(min = 5, max = 5, message = "Postal Code must be 5 digits")
	private String postalCode;
	
	@ManyToOne
	@JoinColumn(name="user_name", nullable=false)
	private User user;
	
	

}
