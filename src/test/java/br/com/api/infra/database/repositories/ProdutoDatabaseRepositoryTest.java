package br.com.api.infra.database.repositories;

import br.com.api.infra.database.factories.ProdutoDataFactory;
import br.com.api.infra.database.jpa.FornecedorDataRepository;
import br.com.api.infra.database.jpa.ProdutoDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

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
    @Disabled
    void deveriaBuscarProduto() {

    }
}
