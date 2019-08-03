package com.example.demo.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

	public Order() {
	}

	public Order(Date date) {
		this.date = date;
	}

	@Id
	@Column(nullable = false, name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false, name = "date")
	private Date date;

}
