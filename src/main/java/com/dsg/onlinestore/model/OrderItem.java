package com.dsg.onlinestore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDERITEMS")
public class OrderItem {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	
	@Positive
	private int position;
	@Positive
	private double price;
	
	/*@OneToOne(mappedBy="orderItem")
    private Beverage beverage;*/
	
	@ManyToOne
	@JoinColumn(name="order_id", nullable=false)
	private Order order;

}
