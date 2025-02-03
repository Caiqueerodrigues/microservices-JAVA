package com.exampleMicroServicos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleMicroServicos.pagamentos.model.Pagamento;

public interface PagamentosRepository extends JpaRepository<Pagamento, Long> {
    
}
