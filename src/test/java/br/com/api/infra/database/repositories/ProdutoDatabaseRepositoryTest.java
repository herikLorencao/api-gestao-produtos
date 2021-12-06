package br.com.api.infra.database.repositories;

import br.com.api.infra.database.factories.ProdutoDataFactory;
import br.com.api.infra.database.jpa.FornecedorDataRepository;
import br.com.api.infra.database.jpa.ProdutoDataRepository;
import br.com.api.infra.database.orm.ProdutoData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ProdutoDatabaseRepositoryTest {
    @Mock
    private ProdutoDataRepository produtoDataRepository;

    @Mock
    private FornecedorDataRepository fornecedorRepository;

    private ModelMapper modelMapper;
    private ProdutoDataFactory produtoDataFactory;
    private ProdutoDatabaseRepository repository;

    @BeforeEach
    public void setUp() {
        modelMapper = new ModelMapper();
        MockitoAnnotations.openMocks(this);
        produtoDataFactory = new ProdutoDataFactory();
        repository = new ProdutoDatabaseRepository(produtoDataRepository, fornecedorRepository, modelMapper);
    }

    @Test
    void deveriaBuscarProduto() {
        var produtoData = produtoDataFactory.geraValido();
        when(produtoDataRepository.findById(1L)).thenReturn(Optional.of(produtoData));

        var produto = repository.buscar(1L);

        assertEquals(produtoData.getCodigo(), produto.getCodigo());
    }
}
