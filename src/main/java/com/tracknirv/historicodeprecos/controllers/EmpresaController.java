package com.tracknirv.historicodeprecos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracknirv.historicodeprecos.configs.ControllerConfig;
import com.tracknirv.historicodeprecos.converts.EmpresaConvert;
import com.tracknirv.historicodeprecos.dtos.inputs.CadastroEmpresaInput;
import com.tracknirv.historicodeprecos.dtos.outputs.EmpresaOutput;
import com.tracknirv.historicodeprecos.entities.EmpresaEntity;
import com.tracknirv.historicodeprecos.services.EmpresaService;

@RestController
@RequestMapping(ControllerConfig.PRE_URL + "/empresas")
@CrossOrigin(origins = { "http://localhost/*" })
public class EmpresaController {

	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private EmpresaConvert empresaConvert;

	@GetMapping
	public List<EmpresaOutput> ListaTodos() {
		return empresaConvert.listEntityToListEmpresasWithoutProdutosOutput(empresaService.listaTodos());
	}

	@PostMapping
	public EmpresaEntity cadastra(@RequestBody CadastroEmpresaInput cadastroEmpresa) {
		return empresaService.cadastro(empresaConvert.inputToEntity(cadastroEmpresa));
	}
}
