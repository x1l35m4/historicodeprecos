package com.tracknirv.historicodeprecos.converts;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tracknirv.historicodeprecos.dtos.inputs.CadastroProdutoInput;
import com.tracknirv.historicodeprecos.dtos.outputs.ProdutoOutput;
import com.tracknirv.historicodeprecos.entities.ProdutoEntity;

@Component
public class ProdutoConvert {
	
	@Autowired
	private ModelMapper mapper;
	
	public ProdutoEntity inputToEntity(CadastroProdutoInput cadastroProduto) {
		return mapper.map(cadastroProduto, ProdutoEntity.class);
	}
	
	public ProdutoOutput EntityToProdutoOutput(ProdutoEntity produto) {
		return mapper.map(produto, ProdutoOutput.class);
	}
	
	public List<ProdutoOutput> ListEntityToListProdutoOutput(List<ProdutoEntity> produtos) {
		List<ProdutoOutput> produtosOutput = produtos.stream().map(this::EntityToProdutoOutput).collect(Collectors.toList());
		
		return produtosOutput;
	}
	

}
