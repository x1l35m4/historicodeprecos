package com.tracknirv.historicodeprecos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracknirv.historicodeprecos.entities.EmpresaEntity;
import com.tracknirv.historicodeprecos.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	public List<EmpresaEntity> listaTodos() {
		return empresaRepository.findAll();
	}

	public EmpresaEntity cadastro(EmpresaEntity empresaEntity) {
		Optional<EmpresaEntity> empresaEncontrada = empresaRepository.getByNome(empresaEntity.getNome());
		if (empresaEncontrada.isPresent()) {
			throw new RuntimeException(String.format("A empresa %s já esta cadastrada",empresaEntity.getNome()));
		} else {
			return empresaRepository.save(empresaEntity);
		}
	}

}
