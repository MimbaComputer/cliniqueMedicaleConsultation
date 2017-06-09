package org.mimba.bao.dao;

import java.util.Date;

import org.mimba.bao.entities.ConstanteMedicale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IConstanteMedicaleRepository extends JpaRepository<ConstanteMedicale, Long> {

	public Page<ConstanteMedicale> findById(@Param("id") Long id, Pageable pageable);

	@Query("select c from ConstanteMedicale c where c.date like:mc")
	public Page<ConstanteMedicale> dateConstanteMedicaleParMC(@Param("mc") String mc, Pageable pageable);

	@Query("select c from ConstanteMedicale c where c.patient.id=:idPatient")
	public Page<ConstanteMedicale> patientConstanteMedicaleParId(@Param("idPatient") Long idPatient, Pageable pageable);

	public Page<ConstanteMedicale> findByDate(@Param("date") Date date, Pageable pageable);

	public Page<ConstanteMedicale> findByPoids(@Param("poids") double poids, Pageable pageable);

	public Page<ConstanteMedicale> findByTaille(@Param("taille") double taille, Pageable pageable);

	public Page<ConstanteMedicale> findByPas(@Param("pas") int pas, Pageable pageable);

	public Page<ConstanteMedicale> findByPad(@Param("pad") int pad, Pageable pageable);

	public Page<ConstanteMedicale> findByPouls(@Param("pouls") int pouls, Pageable pageable);

	public Page<ConstanteMedicale> findByTemperature(@Param("temperature") double temperature, Pageable pageable);

}
