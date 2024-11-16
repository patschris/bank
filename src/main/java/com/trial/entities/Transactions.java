package com.trial.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@JsonAutoDetect
@NamedQuery(name = "Transactions.retrieveAccountBalancesForBeneficiary",
		query = "SELECT new com.trial.dtos.BalanceDTO(t.accounts.id, SUM(case when t.type='withdrawal' then -1*t.amount else t.amount END))" +
				"FROM Transactions t join t.accounts a WHERE a.beneficiaries.id = :beneficiaryId group by t.accounts.id")
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