package br.com.api.application.services;

import br.com.api.domain.fornecedor.Fornecedor;
import br.com.api.domain.fornecedor.FornecedorRepository;
import br.com.api.domain.fornecedor.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class FornecedorRestService implements FornecedorService<Page<Fornecedor>, Pageable> {
    private final FornecedorRepository<Page<Fornecedor>, Pageable> repository;

    @Autowired
    public FornecedorRestService(FornecedorRepository<Page<Fornecedor>, Pageable> repository) {
        this.repository = repository;
    }

    @Override
    public Fornecedor buscar(Long id) {
        return repository.buscar(id);
    }

    @Override
    public Page<Fornecedor> listar(Pageable dadosPaginacao) {
        return repository.listar(dadosPaginacao);
    }

    @Override
    public Fornecedor cadastrar(Fornecedor fornecedor) {
        return repository.cadastrar(fornecedor);
    }

    @Override
    public Fornecedor alterar(Fornecedor fornecedor) {
        return repository.alterar(fornecedor);
    }

    @Override
    public void remover(Long id) {
        repository.remover(id);
    }
}
