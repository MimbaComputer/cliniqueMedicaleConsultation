package org.mimba.bao.dao;

import java.util.Date;

import org.mimba.bao.entities.RendezVou;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IRendezVousRepository extends JpaRepository<RendezVou, Long> {

	public Page<RendezVou> findById(@Param("id") Long id, Pageable pageable);

	public Page<RendezVou> findByPresence(@Param("presence") boolean presence, Pageable pageable);

	public Page<RendezVou> findByTrancheHoraire(@Param("trancheHoraire") Date trancheHoraire, Pageable pageable);

	@Query("select r from RendezVou r where r.motif like:mc")
	public Page<RendezVou> motifRendezVousParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select r from RendezVou r where r.patient.id=:idPatient")
	public Page<RendezVou> patientRendezVousParID(@Param("idPatient") Long idPatient, Pageable pageable);

}
