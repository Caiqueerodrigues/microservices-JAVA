package com.exampleMicroServicos.DTO;

import java.math.BigDecimal;

import com.exampleMicroServicos.Enums.Status;

import lombok.Data;

@Data //substitui o @Getter e @Setter, e possui o equals
public class PagamentoDto {
    private Long id;
    private BigDecimal valor;
    private String nome;
    private String numero;
    private String expiracao;
    private String codigo;
    private Status status;
    private Long pedidoId;
    private Long formaDePagamentoId;
}
