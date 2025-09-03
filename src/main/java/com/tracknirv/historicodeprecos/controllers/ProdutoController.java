package com.tracknirv.historicodeprecos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracknirv.historicodeprecos.configs.ControllerConfig;
import com.tracknirv.historicodeprecos.converts.ProdutoConvert;
import com.tracknirv.historicodeprecos.dtos.inputs.CadastroProdutoInput;
import com.tracknirv.historicodeprecos.dtos.outputs.ProdutoOutput;
import com.tracknirv.historicodeprecos.services.ProdutoService;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/produtos")
@CrossOrigin(origins = { "http://localhost/*" })
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ProdutoConvert produtoConvert;

	@GetMapping
	public List<ProdutoOutput> ListaTodos() {
		return produtoConvert.ListEntityToListProdutoOutput(produtoService.listaTodos());
	}
	
	@GetMapping("/{empresaId}")
	public List<ProdutoOutput> ListaTodosPorEmpresa(@PathVariable Long empresaId) {
		return produtoConvert.ListEntityToListProdutoOutput(produtoService.listaTodosPorEmpresa(empresaId));
	}

	@PostMapping
	public ProdutoOutput cadastra(@RequestBody CadastroProdutoInput cadastroProdutoInput) {
				
		return produtoConvert.EntityToProdutoOutput(produtoService.cadastro(cadastroProdutoInput));
	}
}
