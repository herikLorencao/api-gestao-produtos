package br.com.api.infra.configuration;

import br.com.api.application.services.FornecedorRestService;
import br.com.api.application.services.ProdutoRestService;
import br.com.api.domain.fornecedor.Fornecedor;
import br.com.api.domain.fornecedor.FornecedorRepository;
import br.com.api.domain.fornecedor.FornecedorService;
import br.com.api.domain.fornecedor.ValidadorCNPJ;
import br.com.api.domain.produto.Produto;
import br.com.api.domain.produto.ProdutoRepository;
import br.com.api.domain.produto.ProdutoService;
import br.com.api.infra.database.jpa.FornecedorDataRepository;
import br.com.api.infra.database.jpa.ProdutoDataRepository;
import br.com.api.infra.database.repositories.FornecedorDatabaseRepository;
import br.com.api.infra.database.repositories.ProdutoDatabaseRepository;
import br.com.api.infra.validation.ValidadorCNPJStella;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Configuration
public class BeanConfiguration {
    @Bean
    public ProdutoRepository<Page<Produto>, Pageable> produtoRepository(
            ProdutoDataRepository repository,
            FornecedorDataRepository fornecedorRepository,
            ModelMapper modelMapper
    ) {
        return new ProdutoDatabaseRepository(repository, fornecedorRepository, modelMapper);
    }

    @Bean
    public ProdutoService<Page<Produto>, Pageable> produtoService(ProdutoRepository<Page<Produto>, Pageable> repository) {
        return new ProdutoRestService(repository);
    }

    @Bean
    public FornecedorRepository<Page<Fornecedor>, Pageable> fornecedorRepository(
            FornecedorDataRepository repository, ModelMapper modelMapper
    ) {
        return new FornecedorDatabaseRepository(repository, modelMapper);
    }

    @Bean
    public FornecedorService<Page<Fornecedor>, Pageable> fornecedorService(
            FornecedorRepository<Page<Fornecedor>, Pageable> repository
    ) {
        return new FornecedorRestService(repository);
    }

    @Bean
    public ValidadorCNPJ validadorCNPJ() {
        return new ValidadorCNPJStella();
    }
}
