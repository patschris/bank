package com.trial.services;

import com.trial.entities.Accounts;
import com.trial.repositories.AccountsRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsService {

	@Inject
	AccountsRepository accountsRepository;

	public List<Accounts> getAccountsOfBeneficiary(int beneficiaryId) {
		return accountsRepository.findByBeneficiaryId(beneficiaryId);
	}
}