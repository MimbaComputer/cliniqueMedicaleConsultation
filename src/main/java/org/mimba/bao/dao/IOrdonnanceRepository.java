package org.mimba.bao.dao;

import java.util.Date;

import org.mimba.bao.entities.Ordonnance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IOrdonnanceRepository extends JpaRepository<Ordonnance, Long> {

	public Page<Ordonnance> findById(@Param("id") Long id, Pageable pageable);

	@Query("select o from Ordonnance o where o.date like:mc")
	public Page<Ordonnance> dateOrdonnanceParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select o from Ordonnance o where o.prescription like:mc")
	public Page<Ordonnance> prescriptionOrdonnanceParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select o from Ordonnance o where o.prise like:mc")
	public Page<Ordonnance> priseOrdonnanceParMC(@Param("mc") String mc, Pageable pageable);

	public Page<Ordonnance> findByDate(@Param("date") Date date, Pageable pageable);

	public Page<Ordonnance> findByPrescription(@Param("prescription") String prescription, Pageable pageable);

	public Page<Ordonnance> findByPrise(@Param("prise") String prise, Pageable pageable);

	@Query("select o from Ordonnance o where o.typeCas.id=:idTypeCas")
	public Page<Ordonnance> typeCasOrdonnanceParId(@Param("idTypeCas") Long idTypeCas, Pageable pageable);

	@Query("select o from Ordonnance o where o.patient.id=:idPatient")
	public Page<Ordonnance> patientOrdonnanceParId(@Param("idPatient") Long idPatient, Pageable pageable);

	@Query("select o from Ordonnance o where o.visite.id=:idVisite")
	public Page<Ordonnance> visiteOrdonnanceParId(@Param("idVisite") Long idVisite, Pageable pageable);
}
