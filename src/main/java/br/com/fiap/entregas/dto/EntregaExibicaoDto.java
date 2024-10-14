package br.com.fiap.entregas.dto;

import br.com.fiap.entregas.model.Entrega;
import br.com.fiap.entregas.model.StatusEntrega;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class EntregaExibicaoDto {
    private final Long numeroEntrega;
    private final Long numeroPedido;
    private final String nomeEntregador;
    private final StatusEntrega statusEntrega;
    private final LocalDate dataEntrega;

    // Construtor que recebe uma Entrega
    public EntregaExibicaoDto(Entrega entrega) {
        this(
                entrega.getNumeroEntrega(),
                entrega.getNumeroPedido(),
                entrega.getNomeEntregador(),
                entrega.getStatusEntrega(),
                entrega.getDataEntrega()
        );
    }
}

