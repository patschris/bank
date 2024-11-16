package com.trial.services;

import com.trial.dtos.BalanceDTO;
import com.trial.entities.Transactions;
import com.trial.repositories.TransactionsRepository;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService {

	@Inject
	EntityManager entityManager;

	@Inject
	TransactionsRepository transactionsRepository;

	public List<Transactions> getTransactionsOfBeneficiary(int beneficiaryId) {
		return transactionsRepository.findByBeneficiaryId(beneficiaryId);
	}

	public List<BalanceDTO> getAllAccountsBalanceForBeneficiary(int beneficiaryId) {
		return entityManager
					.createNamedQuery("Transactions.retrieveAccountBalancesForBeneficiary", BalanceDTO.class)
					.setParameter("beneficiaryId",beneficiaryId)
					.getResultList();
	}
}