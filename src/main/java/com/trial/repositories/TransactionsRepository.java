package com.trial.repositories;

import com.trial.entities.Transactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionsRepository extends CrudRepository<Transactions, Integer> {

	@Query("SELECT t FROM Transactions t join t.accounts a WHERE a.beneficiaries.id = :beneficiaryId order by t.date")
	List<Transactions> findByBeneficiaryId(@Param("beneficiaryId") int beneficiaryId);
}