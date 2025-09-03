package com.tracknirv.historicodeprecos.dtos.outputs;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Output DTO para representação de Empresa com os produtos
 * Utilizado para response onde a informação dos produtos são necessarios
 */

@Getter
@Setter
public class EmpresaSemAttProdutosOutput {
		private Long id;
		private String nome;
}	
