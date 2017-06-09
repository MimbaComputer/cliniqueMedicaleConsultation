package org.mimba.bao.dao;

import org.mimba.bao.entities.CasASuivre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ICasASuivreRepository extends JpaRepository<CasASuivre, Long> {

	public Page<CasASuivre> findById(@Param("id") Long id, Pageable pageable);

	@Query("select c from CasASuivre c where c.etatTraitement like:mc")
	public Page<CasASuivre> etatTraitementCasASuivreParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select c from CasASuivre c where c.histoireMaladie like:mc")
	public Page<CasASuivre> histoireMaladieCasASuivreParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select c from CasASuivre c where c.remarque like:mc")
	public Page<CasASuivre> remarqueCasASuivreParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select c from CasASuivre c where c.patient.id=:idPatient")
	public Page<CasASuivre> patientCasASuivreParId(@Param("idPatient") Long idPatient, Pageable pageable);
}
