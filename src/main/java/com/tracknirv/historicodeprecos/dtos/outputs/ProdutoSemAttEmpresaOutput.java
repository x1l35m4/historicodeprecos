package com.tracknirv.historicodeprecos.dtos.outputs;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

/**
 * Output DTO para representação de Produto sem o atributo Empresa
 * Utilizado para responses onde a informação da empresa não é necessária
 */
@Getter
@Setter
public class ProdutoSemAttEmpresaOutput {
	private Long id;
	private String nome;
	private LocalDate dataDaCompra;
	private BigDecimal valorUnitario;
	private int quantidade;
	private BigDecimal valorTotal;
}
