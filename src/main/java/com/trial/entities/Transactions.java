package com.trial.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
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

	private BigDecimal amount;

	private String type;

	@Temporal(TemporalType.DATE)
	private Date date;
}