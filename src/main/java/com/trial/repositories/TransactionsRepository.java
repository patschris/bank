package com.trial.repositories;

import com.trial.entities.Transactions;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TransactionsRepository extends CrudRepository<Transactions, Integer> {

	@Query("SELECT t " +
			"FROM Transactions t JOIN t.accounts a " +
			"WHERE a.beneficiaries.id = :beneficiaryId " +
			"ORDER BY t.date")
	List<Transactions> findByBeneficiaryId(@Param("beneficiaryId") int beneficiaryId);

	@Query("SELECT t " +
			"FROM Transactions t JOIN t.accounts a " +
			"WHERE t.type='withdrawal' AND a.beneficiaries.id = :beneficiaryId AND t.date>=:date " +
			"ORDER BY t.amount DESC " +
			"LIMIT 1")
	Optional<Transactions> findMaxWithdrawalLastMonthForBeneficiary(@Param("beneficiaryId") int beneficiaryId,
																	@Param("date") LocalDate date);
}