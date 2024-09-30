package br.com.fiap.entregas.dto;


import br.com.fiap.entregas.model.StatusEntrega;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EntregaDto {

    private Long numeroEntrega;

    @NotNull(message = "Número do pedido não pode ser nulo")
    @Min(value = 0, message = "Número do pedido deve ser um número inteiro positivo")
    private Long numeroPedido;

    @NotNull(message = "Nome do entregador não pode ser nulo")
    @Size(max = 25, message = "Nome do entregador deve ter no máximo 25 caracteres")
    private String nomeEntregador;

    @NotNull(message = "Status da Entrega não pode ser nulo")
    private StatusEntrega statusEntrega;

    @NotNull(message = "Data de entrega não pode ser nula")
    private LocalDate dataEntrega;

}
