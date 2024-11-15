package com.trial.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {

	@Id
	private int id;

	@ManyToOne
	private Beneficiaries beneficiaries;
}