package br.com.fiap.entregas.controller;

import br.com.fiap.entregas.dto.EntregaDto;
import br.com.fiap.entregas.dto.EntregaExibicaoDto;
import br.com.fiap.entregas.dto.ErrorResponseDto;
import br.com.fiap.entregas.service.EntregaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaService service;

    @GetMapping("/health")
    public String healthCheck() {
        return "O serviço está UP!";
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody @Valid EntregaDto entregaDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().stream()
                    .map(error -> {
                        return error.getDefaultMessage();
                    })
                    .collect(Collectors.joining("; "));

            return ResponseEntity.badRequest().body(new ErrorResponseDto(errorMessage));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(entregaDto));
    }

    @GetMapping("{numeroEntrega}")
    public ResponseEntity<EntregaExibicaoDto> buscarPorNumero(@PathVariable Long numeroEntrega){
        return ResponseEntity.ok(service.buscarPorNumero(numeroEntrega));
    }

    @GetMapping
    public ResponseEntity<List<EntregaExibicaoDto>> listarTodasAsEntregas(){
        return ResponseEntity.ok(service.listarTodasAsEntregas());
    }

    @DeleteMapping("{numeroEntrega}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long numeroEntrega){
        service.excluir(numeroEntrega);
    }

    @PutMapping
    public EntregaExibicaoDto atualizar(@RequestBody EntregaDto entregaDto){
        return service.atualizar(entregaDto);
    }

}
