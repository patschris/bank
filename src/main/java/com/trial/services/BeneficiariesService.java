package com.trial.services;

import com.trial.entities.Beneficiaries;
import com.trial.repositories.BeneficiariesRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BeneficiariesService {

	@Inject
	BeneficiariesRepository beneficiariesRepository;

	public Optional<Beneficiaries> getBeneficiaryDetails(int id){
		return beneficiariesRepository.findById(id);
	}
}