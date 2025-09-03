package com.tracknirv.historicodeprecos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracknirv.historicodeprecos.converts.ProdutoConvert;
import com.tracknirv.historicodeprecos.dtos.inputs.CadastroProdutoInput;
import com.tracknirv.historicodeprecos.entities.EmpresaEntity;
import com.tracknirv.historicodeprecos.entities.ProdutoEntity;
import com.tracknirv.historicodeprecos.repositories.EmpresaRepository;
import com.tracknirv.historicodeprecos.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoConvert produtoConvert;

	@Autowired
	private EmpresaRepository empresaRepository;

	public List<ProdutoEntity> listaTodos() {
		return produtoRepository.findAll();
	}

	public List<ProdutoEntity> listaTodosPorEmpresa(Long empresaId) {
		EmpresaEntity empresa = empresaRepository.findById(empresaId)
				.orElseThrow(() -> new RuntimeException(String.format("Empresa de id: \s não encontrada", empresaId)));

		return produtoRepository.findAllByEmpresa(empresa);
	}

	public ProdutoEntity cadastro(CadastroProdutoInput cadastroProdutoInput) {

		ProdutoEntity novoProduto = produtoConvert.inputToEntity(cadastroProdutoInput);
		EmpresaEntity empresa = empresaRepository.findById(cadastroProdutoInput.getEmpresa())
				.orElseThrow(() -> new RuntimeException(
						String.format("Empresa de id:%s não encontrada", cadastroProdutoInput.getEmpresa())));

		novoProduto.setEmpresa(empresa);
		novoProduto.calcularValorTotal();

		if (this.isCastradado(novoProduto))throw new RuntimeException("Este produto já esta cadastrado");
		
		return produtoRepository.save(novoProduto);

	}

	public boolean isCastradado(ProdutoEntity produto) {
		//return empresaRepository.findByNomeAndEmpresa(produto).isEmpty();
		System.out.println(empresaRepository.findByNomeAndEmpresa(produto));
		return empresaRepository.findByNomeAndEmpresa(produto).isPresent();
	}

}
