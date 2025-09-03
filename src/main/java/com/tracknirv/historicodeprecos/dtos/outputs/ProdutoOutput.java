package com.tracknirv.historicodeprecos.dtos.outputs;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoOutput {
	private String nome;
	private EmpresaSemAttProdutosOutput empresa;
	private LocalDate dataDaCompra;
	private BigDecimal valorUnitario;
	private int quatidade;
	private BigDecimal valorTotal;
}
