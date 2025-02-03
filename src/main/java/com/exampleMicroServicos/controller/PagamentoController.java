package com.exampleMicroServicos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.exampleMicroServicos.DTO.PagamentoDto;
import com.exampleMicroServicos.services.PagamentoService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/pagamentos")
@RequiredArgsConstructor
public class PagamentoController {

    private final PagamentoService service;

    @GetMapping
    public List<PagamentoDto> list() {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDto> byId(@PathVariable @NotNull Long id) {
        PagamentoDto dto = service.getByID(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PagamentoDto> create(@RequestBody @Valid PagamentoDto dto, UriComponentsBuilder uriBuilder) {

        PagamentoDto pagamento = service.createPayment(dto);
        var uri = uriBuilder.path("/pagamentos/{id}").buildAndExpand(pagamento.getId()).toUri();

        return ResponseEntity.created(uri).body(pagamento);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PagamentoDto> update(@PathVariable @NotNull Long id, @Valid @RequestBody PagamentoDto dto) {
        PagamentoDto pagamentoAtualizado = service.updatePayment(id, dto);

        return ResponseEntity.ok(pagamentoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PagamentoDto> delete(@PathVariable @NotNull Long id) {
        service.deletePayment(id);

        return ResponseEntity.noContent().build();
    }
}
