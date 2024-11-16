package com.trial.services;

import com.trial.entities.Transactions;
import com.trial.repositories.TransactionsRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsService {

	@Inject
	TransactionsRepository transactionsRepository;

	public List<Transactions> getTransactionsOfBeneficiary(int beneficiaryId) {
		return transactionsRepository.findByBeneficiaryId(beneficiaryId);
	}
}