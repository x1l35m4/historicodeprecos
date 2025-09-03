package com.tracknirv.historicodeprecos.converts;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracknirv.historicodeprecos.dtos.inputs.CadastroEmpresaInput;
import com.tracknirv.historicodeprecos.dtos.outputs.EmpresaOutput;
import com.tracknirv.historicodeprecos.dtos.outputs.ProdutoSemAttEmpresaOutput;
import com.tracknirv.historicodeprecos.entities.EmpresaEntity;

@Component
public class EmpresaConvert {

	@Autowired
	private ModelMapper mapper;

	public EmpresaEntity inputToEntity(CadastroEmpresaInput cadastroEmpresa) {
		return mapper.map(cadastroEmpresa, EmpresaEntity.class);
	}
	
	public EmpresaOutput entityToEmpresaWithoutProdutosOutput(EmpresaEntity empresa) {
		EmpresaOutput empresaOutput = mapper.map(empresa, EmpresaOutput.class);

		return empresaOutput;
	}

	public EmpresaOutput entityToEmpresaWithProdutosOutput(EmpresaEntity empresa) {
		EmpresaOutput empresaOutput = mapper.map(empresa, EmpresaOutput.class);
		List<ProdutoSemAttEmpresaOutput> produtos = empresa.getProdutos().stream().map((produto) -> {
			return mapper.map(produto, ProdutoSemAttEmpresaOutput.class);
		}).toList();

		empresaOutput.setProdutos(produtos);

		return empresaOutput;
	}

	public List<EmpresaOutput> listEntityToListEmpresasWithoutProdutosOutput(List<EmpresaEntity> listaTodos) {
		List<EmpresaOutput> empresas = listaTodos.stream().map(this::entityToEmpresaWithProdutosOutput).toList();
		return empresas;
	}

}
