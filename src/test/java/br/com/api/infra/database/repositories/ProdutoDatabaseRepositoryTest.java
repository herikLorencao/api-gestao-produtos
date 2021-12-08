package br.com.api.infra.database.repositories;

import br.com.api.domain.Situacao;
import br.com.api.domain.factories.ProdutoFactory;
import br.com.api.infra.database.factories.FornecedorDataFactory;
import br.com.api.infra.database.factories.ModelMapperFactory;
import br.com.api.infra.database.factories.ProdutoDataFactory;
import br.com.api.infra.database.jpa.FornecedorDataRepository;
import br.com.api.infra.database.jpa.ProdutoDataRepository;
import br.com.api.infra.database.orm.ProdutoData;
import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

class ProdutoDatabaseRepositoryTest {
    @Mock
    private ProdutoDataRepository produtoDataRepository;

    @Mock
    private FornecedorDataRepository fornecedorDataRepository;

    private ProdutoDataFactory produtoDataFactory;
    private FornecedorDataFactory fornecedorDataFactory;
    private ProdutoFactory produtoFactory;
    private ProdutoDatabaseRepository repository;
    private ModelMapper modelMapper;

    @BeforeEach
    public void setUp() {
        var modelMapperFactory = new ModelMapperFactory();
        MockitoAnnotations.openMocks(this);
        produtoDataFactory = new ProdutoDataFactory();
        fornecedorDataFactory = new FornecedorDataFactory();
        produtoFactory = new ProdutoFactory();
        modelMapper = modelMapperFactory.get();
        repository = new ProdutoDatabaseRepository(produtoDataRepository, fornecedorDataRepository, modelMapper);
    }

    @Test
    void deveriaBuscarProduto() {
        var produtoData = produtoDataFactory.geraValido();
        when(produtoDataRepository.findById(1L)).thenReturn(Optional.of(produtoData));

        var produto = repository.buscar(1L);

        assertEquals(produtoData.getCodigo(), produto.getCodigo());
        assertEquals(produtoData.getDescricao(), produto.getDescricao());
        assertEquals(produtoData.getSituacao(), produto.getSituacao());
        assertEquals(produtoData.getFornecedor().getCodigo(), produto.getFornecedor().getCodigo());
        assertEquals(produtoData.getDataFabricacao(), produto.getDataFabricacao());
        assertEquals(produtoData.getDataValidade(), produto.getDataValidade());
    }

    @Test
    void deveriaNaoEncontrarProduto() {
        var produtoData = produtoDataFactory.geraInativo();
        when(produtoDataRepository.findById(1L)).thenReturn(Optional.of(produtoData));

        assertThrows(ObjectNotFoundException.class, () -> repository.buscar(1L));
    }

    @Test
    void deveriaListarProdutos() {
        var produtosData = produtoDataFactory.geraLista();
        when(produtoDataRepository.findAllBySituacao(Situacao.ATIVO, Pageable.unpaged()))
                .thenReturn(new PageImpl<>(produtosData));

        var paginaProdutos = repository.listar(Pageable.unpaged());

        assertEquals(produtosData.size(), paginaProdutos.getTotalElements());
    }

    @Test
    void deveriaCadastrarProduto() {
        var produto = produtoFactory.geraValido();
        var produtoData = modelMapper.map(produto, ProdutoData.class);
        var fornecedorData = fornecedorDataFactory.geraValido();

        when(fornecedorDataRepository.findById(produtoData.getCodigo())).thenReturn(Optional.of(fornecedorData));
        when(produtoDataRepository.save(argThat(p -> p.getCodigo().equals(produto.getCodigo())))).thenReturn(produtoData);

        repository.cadastrar(produto);

        verify(produtoDataRepository, times(1)).save(argThat(p -> p.getCodigo().equals(produto.getCodigo())));
    }

    @Test
    void deveriaAlterarProduto() {
        var produto = produtoFactory.geraValido();
        var produtoData = modelMapper.map(produto, ProdutoData.class);
        var fornecedorData = fornecedorDataFactory.geraValido();

        when(fornecedorDataRepository.findById(produtoData.getFornecedor().getCodigo())).thenReturn(Optional.of(fornecedorData));
        when(produtoDataRepository.findById(produtoData.getCodigo())).thenReturn(Optional.of(produtoData));
        when(produtoDataRepository.save(argThat(p -> p.getCodigo().equals(produto.getCodigo())))).thenReturn(produtoData);

        repository.alterar(produto);

        verify(produtoDataRepository, times(1)).save(argThat(p -> p.getCodigo().equals(produto.getCodigo())));
    }

    @Test
    void deveriaRemoverProduto() {
        var produtoData = produtoDataFactory.geraValido();
        var produtoDataInativo = produtoDataFactory.geraInativo();
        var fornecedorData = fornecedorDataFactory.geraValido();

        when(fornecedorDataRepository.findById(produtoData.getCodigo())).thenReturn(Optional.of(fornecedorData));
        when(produtoDataRepository.save(argThat(p -> p.getCodigo().equals(produtoData.getCodigo())))).thenReturn(produtoDataInativo);
        when(produtoDataRepository.findById(1L)).thenReturn(Optional.of(produtoData));

        repository.remover(1L);

        verify(produtoDataRepository, times(1))
                .save(argThat(p -> p.getCodigo().equals(produtoData.getCodigo())
                        && p.getSituacao().equals(Situacao.INATIVO)));
    }
}
