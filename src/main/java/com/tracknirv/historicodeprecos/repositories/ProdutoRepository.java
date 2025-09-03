package com.tracknirv.historicodeprecos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracknirv.historicodeprecos.entities.EmpresaEntity;
import com.tracknirv.historicodeprecos.entities.ProdutoEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

	List<ProdutoEntity> findAllByEmpresa(EmpresaEntity empresa);

}
