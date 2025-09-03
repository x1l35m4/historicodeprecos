package com.tracknirv.historicodeprecos.dtos.inputs;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastroProdutoInput {
	private String nome;
	private Long empresa;
	private LocalDate dataDaCompra;
	private BigDecimal valorUnitario;
	private int quatidade;
}
