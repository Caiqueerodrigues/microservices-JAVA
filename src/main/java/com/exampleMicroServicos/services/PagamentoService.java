package com.exampleMicroServicos.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.exampleMicroServicos.DTO.PagamentoDto;
import com.exampleMicroServicos.Enums.Status;
import com.exampleMicroServicos.pagamentos.model.Pagamento;
import com.exampleMicroServicos.repository.PagamentosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //para não usar o @Autowide
public class PagamentoService {
    
    private final PagamentosRepository repository;

    private final ModelMapper modelMapper; 
    //necessario para validação dos dados que irão entrar e sair pelo DTO, pra fazer as validações dos dados

    public List<PagamentoDto> getAll() {
        return repository
            .findAll()
            .stream()
            .map(p -> modelMapper.map(p, PagamentoDto.class)) //converte cada item da lista em um formato valido do DTO
            .collect(Collectors.toList());
    }

    public PagamentoDto getByID(Long id) {
        Optional<Pagamento> OptionalPagamento = repository.findById(id);

        Pagamento pagamento = OptionalPagamento.orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public PagamentoDto createPayment(PagamentoDto dto) {
        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setStatus(Status.CRIADO);
        repository.save(pagamento);

        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public PagamentoDto updatePayment(Long id, PagamentoDto dto) {
        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setId(id);

        pagamento = repository.save(pagamento);

        return modelMapper.map(pagamento, PagamentoDto.class);
    }

    public void deletePayment(Long id) {
        repository.deleteById(id);
    }
}
