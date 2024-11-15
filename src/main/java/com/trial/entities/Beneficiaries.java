package com.trial.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "beneficiaries")
@NoArgsConstructor
@AllArgsConstructor
public class Beneficiaries {

	@Id
	private int id;

	private String firstName;

	private String lastName;
}