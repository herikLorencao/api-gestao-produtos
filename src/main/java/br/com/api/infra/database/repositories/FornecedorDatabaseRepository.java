package br.com.api.infra.database.repositories;

import br.com.api.domain.Situacao;
import br.com.api.domain.fornecedor.Fornecedor;
import br.com.api.domain.fornecedor.FornecedorRepository;
import br.com.api.infra.database.jpa.FornecedorDataRepository;
import br.com.api.infra.database.orm.FornecedorData;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class FornecedorDatabaseRepository implements FornecedorRepository<Page<Fornecedor>, Pageable> {

    private final FornecedorDataRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public FornecedorDatabaseRepository(FornecedorDataRepository fornecedorDataRepository, ModelMapper modelMapper) {
        this.repository = fornecedorDataRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Fornecedor buscar(Long id) {
        var fornecedorData = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, Fornecedor.class.getSimpleName()));

        if (fornecedorData.getSituacao().equals(Situacao.DESATIVADO))
            throw new ObjectNotFoundException(id, Fornecedor.class.getSimpleName());

        return modelMapper.map(fornecedorData, Fornecedor.class);
    }

    @Override
    public Page<Fornecedor> listar(Pageable dadosPaginacao) {
        var paginaFornecedorData = repository.findAllBySituacao(Situacao.ATIVADO, dadosPaginacao);
        var fornecedores = paginaFornecedorData.getContent()
                .stream().map(fornecedorData -> modelMapper.map(fornecedorData, Fornecedor.class)).toList();
        return new PageImpl<>(fornecedores, dadosPaginacao, paginaFornecedorData.getTotalElements());
    }

    @Override
    public Fornecedor cadastrar(Fornecedor fornecedor) {
        return persistirFornecedor(fornecedor);
    }

    @Override
    public Fornecedor alterar(Fornecedor fornecedor) {
        return persistirFornecedor(fornecedor);
    }

    @Override
    public void remover(Long id) {
        var fornecedor = buscar(id);
        fornecedor.desabilitar();
        persistirFornecedor(fornecedor);
    }

    private Fornecedor persistirFornecedor(Fornecedor fornecedor) {
        var fornecedorData = modelMapper.map(fornecedor, FornecedorData.class);
        fornecedorData = repository.save(fornecedorData);
        return modelMapper.map(fornecedorData, Fornecedor.class);
    }
}
