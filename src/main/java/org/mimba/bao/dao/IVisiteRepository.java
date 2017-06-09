package org.mimba.bao.dao;

import java.util.Date;

import org.mimba.bao.entities.Visite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IVisiteRepository extends JpaRepository<Visite, Long> {

	public Page<Visite> findById(@Param("id") Long id, Pageable pageable);

	public Page<Visite> findByDate(@Param("date") Date date, Pageable pageable);

	@Query("select v from Visite v where v.motif like:mc")
	public Page<Visite> motifVisiteParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select v from Visite v where v.interrogatoire like:mc")
	public Page<Visite> interrogatoireVisiteParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select v from Visite v where v.conclusion like:mc")
	public Page<Visite> conclusionVisiteParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select v from Visite v where v.examen like:mc")
	public Page<Visite> examenVisiteParMC(@Param("mc") String mc, Pageable pageable);

	public Page<Visite> findByhonoraire(@Param("honoraire") int honoraire, Pageable pageable);

	@Query("select v from Visite v where v.typeCas.id=:idTypeCas")
	public Page<Visite> typeCasVisiteParId(@Param("idTypeCas") Long idTypeCas, Pageable pageable);

	@Query("select v from Visite v where v.patient.id=:idPatient")
	public Page<Visite> patientVisiteParId(@Param("idPatient") Long idPatient, Pageable pageable);

	@Query("select v from Visite v where v.ordonnance.id=:idOrdonnance")
	public Page<Visite> ordonnanceVisiteParId(@Param("idOrdonnance") Long idOrdonnance, Pageable pageable);

}
