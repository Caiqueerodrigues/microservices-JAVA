package com.exampleMicroServicos.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.exampleMicroServicos.repository.PagamentosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //para não usar o @Autowide
public class PagamentoService {
    
    private final PagamentosRepository repository;

    private final ModelMapper modelMapper;
}
