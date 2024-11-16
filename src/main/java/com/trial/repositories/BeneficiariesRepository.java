package com.trial.repositories;

import com.trial.entities.Beneficiaries;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeneficiariesRepository extends CrudRepository<Beneficiaries, Integer> {
	Optional<Beneficiaries> findById(Integer id);
}
