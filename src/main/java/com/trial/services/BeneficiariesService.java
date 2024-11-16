package com.trial.services;

import com.trial.entities.Beneficiaries;
import com.trial.repositories.BeneficiariesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BeneficiariesService {

	@Autowired
	BeneficiariesRepository beneficiariesRepository;

	public Optional<Beneficiaries> getBeneficiaryDetails(int id){
		return beneficiariesRepository.findById(id);
	}
}