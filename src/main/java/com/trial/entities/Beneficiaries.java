package com.trial.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "beneficiaries")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@JsonAutoDetect
public class Beneficiaries {

	@Id
	private int id;

	private String firstName;

	private String lastName;
}