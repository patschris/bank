package com.trial.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
public class Transactions {

	@Id
	private int id;

	@ManyToOne
	private Accounts accounts;

	private double amount;

	private String type;

	private Date date;
}