package org.mimba.bao.dao;

import org.mimba.bao.entities.Antecedent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IAntecedentRepository extends JpaRepository<Antecedent, Long> {

	public Page<Antecedent> findById(@Param("id") Long id, Pageable pageable);

	@Query("select a from Antecedent a where a.typeAntecedent like:mc")
	public Page<Antecedent> typeAntecedentAntecedentParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select a from Antecedent a where a.traitementIssue like:mc")
	public Page<Antecedent> traitementIssueAntecedentParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select a from Antecedent a where a.periode like:mc")
	public Page<Antecedent> periodeAntecedentParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select a from Antecedent a where a.antecedent like:mc")
	public Page<Antecedent> antecedentAntecedentParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select a from Antecedent a where a.patient.id=:idPatient")
	public Page<Antecedent> patientAntecedentParId(@Param("idPatient") Long idPatient, Pageable pageable);

	
}
