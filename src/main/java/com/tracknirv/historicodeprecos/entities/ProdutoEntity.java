package com.tracknirv.historicodeprecos.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_Produtos")
public class ProdutoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "empresa_id", nullable = false)
	private EmpresaEntity empresa;
	
	 @Column(name = "valor_unitario", nullable = false, precision = 10, scale = 2)
	private BigDecimal valorUnitario;
	 
	 @Column(name = "quantidade")
	private int quatidade;
	
	 @Column(name = "valor_total",nullable = false, precision = 10, scale = 2)
	private BigDecimal valorTotal;
	 
	 @Column(name = "data_compra")
	 private LocalDate dataDaCompra;
	 
 	 public void calcularValorTotal() {
		 this.valorTotal = (this.valorUnitario.multiply(BigDecimal.valueOf(this.quatidade)));
	 }
}
