package com.trial.repositories;

import com.trial.entities.Accounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Integer>  {
	@Query("SELECT a FROM Accounts a WHERE a.beneficiaries.id = :beneficiaryId")
	List<Accounts> findByBeneficiaryId(@Param("beneficiaryId") int beneficiaryId);
}