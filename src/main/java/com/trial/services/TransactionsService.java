package com.trial.services;

import com.trial.dtos.BalanceDTO;
import com.trial.entities.Transactions;
import com.trial.repositories.TransactionsRepository;
import com.trial.utilities.DateUtility;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionsService {

	@Autowired
	EntityManager entityManager;

	@Autowired
	TransactionsRepository transactionsRepository;

	@Autowired
	DateUtility dateUtility;

	public List<Transactions> getTransactionsOfBeneficiary(int beneficiaryId) {
		return transactionsRepository.findByBeneficiaryId(beneficiaryId);
	}

	public List<BalanceDTO> getAllAccountsBalanceForBeneficiary(int beneficiaryId) {
		return entityManager
					.createNamedQuery("Transactions.retrieveAccountBalancesForBeneficiary", BalanceDTO.class)
					.setParameter("beneficiaryId",beneficiaryId)
					.getResultList();
	}

	public Optional<Transactions> getLargestWithdrawalLastMonthForBeneficiary(int beneficiaryId) {
		return transactionsRepository.findMaxWithdrawalLastMonthForBeneficiary(beneficiaryId, dateUtility.getDateBeforeMonth(1));
	}
}