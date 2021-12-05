package br.com.api.infra.database.repositories;

import br.com.api.domain.Situacao;
import br.com.api.domain.produto.Produto;
import br.com.api.domain.produto.ProdutoRepository;
import br.com.api.infra.database.jpa.ProdutoDataRepository;
import br.com.api.infra.database.orm.ProdutoData;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class ProdutoDatabaseRepository implements ProdutoRepository<Page<Produto>, Pageable> {
    private final ProdutoDataRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProdutoDatabaseRepository(ProdutoDataRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Produto buscar(Long codigo) {
        var produtoData = repository.findById(codigo)
                .orElseThrow(() -> new ObjectNotFoundException(codigo, Produto.class.getSimpleName()));

        if (produtoData.getSituacao().equals(Situacao.DESATIVADO))
            throw new ObjectNotFoundException(codigo, Produto.class.getSimpleName());

        return modelMapper.map(produtoData, Produto.class);
    }

    @Override
    public Page<Produto> listar(Pageable dadosPaginacao) {
        var paginaProdutoData = repository.findAll(dadosPaginacao);
        var produtos = paginaProdutoData.getContent()
                .stream().map(produtoData -> modelMapper.map(produtoData, Produto.class)).toList();
        return new PageImpl<>(produtos, dadosPaginacao, paginaProdutoData.getTotalElements());
    }

    @Override
    public Produto cadastrar(Produto produto) {
        return persistirProduto(produto);
    }

    @Override
    public Produto alterar(Produto produto) {
        return persistirProduto(produto);
    }

    @Override
    public void remover(Long codigo) {
        var produto = buscar(codigo);
        produto.desativar();
        persistirProduto(produto);
    }

    private Produto persistirProduto(Produto produto) {
        var produtoData = modelMapper.map(produto, ProdutoData.class);
        produtoData = repository.save(produtoData);
        return modelMapper.map(produtoData, Produto.class);
    }
}
