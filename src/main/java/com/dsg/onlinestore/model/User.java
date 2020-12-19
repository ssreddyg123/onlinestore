package com.dsg.onlinestore.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

	@Id
	@NotNull(message = "Username must be set")
	@NotEmpty(message = "Username not there")
	private String username;

	@NotNull(message = "Password must be set")
	@NotEmpty(message = "Password not there")
	private String password;

	@NotNull(message = "Birthday must be set")
	private LocalDate birthday;

	@OneToMany(mappedBy = "user", cascade = { CascadeType.ALL  })
	private List<Address> billingAddresses;

	@OneToMany(mappedBy = "user", cascade = { CascadeType.ALL  })
	private List<Order> orders;

}
