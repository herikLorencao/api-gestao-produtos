package br.com.api.application.services;

import br.com.api.domain.produto.Produto;
import br.com.api.domain.produto.ProdutoRepository;
import br.com.api.domain.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoRestService implements ProdutoService<Page<Produto>, Pageable> {
    private final ProdutoRepository<Page<Produto>, Pageable> repository;

    @Autowired
    public ProdutoRestService(ProdutoRepository<Page<Produto>, Pageable> repository) {
        this.repository = repository;
    }

    @Override
    public Produto buscar(Long codigo) {
        return repository.buscar(codigo);
    }

    @Override
    public Page<Produto> listarAtivos(Pageable dadosPaginacao) {
        return repository.listar(dadosPaginacao);
    }

    @Override
    public Produto cadastrar(Produto produto) {
        return repository.cadastrar(produto);
    }

    @Override
    public Produto alterar(Produto produto) {
        return repository.alterar(produto);
    }

    @Override
    public void remover(Long codigo) {
        repository.remover(codigo);
    }
}