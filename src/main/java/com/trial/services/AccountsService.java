package com.trial.services;

import com.trial.entities.Accounts;
import com.trial.repositories.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsService {

	@Autowired
	AccountsRepository accountsRepository;

	public List<Accounts> getAccountsOfBeneficiary(int beneficiaryId) {
		return accountsRepository.findByBeneficiaryId(beneficiaryId);
	}
}