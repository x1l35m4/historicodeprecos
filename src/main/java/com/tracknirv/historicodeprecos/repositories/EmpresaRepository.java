package com.tracknirv.historicodeprecos.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tracknirv.historicodeprecos.entities.EmpresaEntity;
import com.tracknirv.historicodeprecos.entities.ProdutoEntity;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {

	Optional<EmpresaEntity> getByNome(String nome);

	@Query("SELECT p FROM ProdutoEntity p WHERE p.nome = :#{#produto.nome} AND p.empresa = :#{#produto.empresa}")
	Optional<EmpresaEntity> findByNomeAndEmpresa(@Param("produto")ProdutoEntity produto);
	
}
