package org.mimba.bao.dao;

import java.util.Date;

import org.mimba.bao.entities.Reglement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IReglementRepository extends JpaRepository<Reglement, Long> {

	public Page<Reglement> findById(@Param("id") Long id, Pageable pageable);

	public Page<Reglement> findByDate(@Param("date") Date date, Pageable pageable);

	@Query("select r from Reglement r where r.date like:mc")
	public Page<Reglement> dateReglementParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select r from Reglement r where r.typePaiement like:mc")
	public Page<Reglement> typePaiementReglementParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select r from Reglement r where r.remarque like:mc")
	public Page<Reglement> remarqueReglementParMC(@Param("mc") String mc, Pageable pageable);

	public Page<Reglement> findByValeur(@Param("valeur") int valeur, Pageable pageable);

	@Query("select r from Reglement r where r.visite.id=:idVisite")
	public Page<Reglement> visiteReglementParId(@Param("idVisite") Long idVisite, Pageable pageable);

}
