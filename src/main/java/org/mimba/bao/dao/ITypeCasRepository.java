package org.mimba.bao.dao;

import org.mimba.bao.entities.TypeCa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ITypeCasRepository extends JpaRepository<TypeCa, Long> {

	public Page<TypeCa> findById(@Param("id") Long id, Pageable pageable);

	@Query("select t from TypeCa t where t.libelle like:mc")
	public Page<TypeCa> libelleTypeCasParMC(@Param("mc") String mc, Pageable pageable);
	
	@Query("select t from TypeCa t where t.casASuivre.id=:idCasASuivre")
	public Page<TypeCa> casASuivreTypeCasParId(@Param("idCasASuivre") Long idCasASuivre, Pageable pageable);

	@Query("select t from TypeCa t where t.examenTypique like:mc")
	public Page<TypeCa> examenTypiqueTypeCasParMC(@Param("mc") String mc, Pageable pageable);
}
