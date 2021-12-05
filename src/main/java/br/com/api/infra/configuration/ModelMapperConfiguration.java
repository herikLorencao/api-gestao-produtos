package br.com.api.infra.configuration;

import br.com.api.application.requests.FornecedorRequest;
import br.com.api.application.requests.ProdutoRequest;
import br.com.api.application.responses.FornecedorResponse;
import br.com.api.application.responses.ProdutoResponse;
import br.com.api.domain.Situacao;
import br.com.api.domain.fornecedor.CNPJ;
import br.com.api.domain.fornecedor.Fornecedor;
import br.com.api.domain.fornecedor.ValidadorCNPJ;
import br.com.api.domain.produto.Produto;
import br.com.api.infra.database.orm.FornecedorData;
import br.com.api.infra.database.orm.ProdutoData;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {
    private final ValidadorCNPJ validadorCNPJ;

    @Autowired
    public ModelMapperConfiguration(ValidadorCNPJ validadorCNPJ) {
        this.validadorCNPJ = validadorCNPJ;
    }

    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();

        mapRequests(modelMapper);
        mapResponses(modelMapper);
        mapRequests(modelMapper);
        mapDomainORM(modelMapper);
        mapORMToDomain(modelMapper);

        return modelMapper;
    }

    private void mapRequests(ModelMapper modelMapper) {
        Converter<ProdutoRequest, Produto> produtoRequestToDomain = ctx -> {
            var produtoRequest = ctx.getSource();
            var fornecedor = new Fornecedor(produtoRequest.getCodigoFornecedor(), null, null,
                    null, null);
            return new Produto(null, produtoRequest.getDescricao(), produtoRequest.getDataFabricacao(),
                    produtoRequest.getDataValidade(), fornecedor, Situacao.ATIVO);
        };

        Converter<FornecedorRequest, Fornecedor> fornecedorRequestToDomain = ctx -> {
            var fornecedorRequest = ctx.getSource();
            var cnpj = new CNPJ(validadorCNPJ, fornecedorRequest.getCnpj());
            return new Fornecedor(null, fornecedorRequest.getDescricao(), cnpj, null, Situacao.ATIVO);
        };

        modelMapper.addConverter(produtoRequestToDomain);
        modelMapper.addConverter(fornecedorRequestToDomain);
    }

    private void mapResponses(ModelMapper modelMapper) {
        Converter<Produto, ProdutoResponse> produtoToResponse = ctx -> {
            var produto = ctx.getSource();
            return new ProdutoResponse(produto.getCodigo(), produto.getDescricao(), produto.getDataFabricacao(),
                    produto.getDataValidade(), produto.getFornecedor().getCodigo(), produto.getSituacao());
        };

        Converter<Fornecedor, FornecedorResponse> fornecedorToResponse = ctx -> {
            var fornecedor = ctx.getSource();
            return new FornecedorResponse(fornecedor.getCodigo(), fornecedor.getDescricao(), fornecedor.getCnpj().getValor());
        };

        modelMapper.addConverter(produtoToResponse);
        modelMapper.addConverter(fornecedorToResponse);
    }

    private void mapDomainORM(ModelMapper modelMapper) {
        Converter<Produto, ProdutoData> produtoToORM = ctx -> {
            var produto = ctx.getSource();
            var fornecedor = new FornecedorData(produto.getFornecedor().getCodigo(), null, null,
                    null, null);
            return new ProdutoData(produto.getCodigo(), produto.getDescricao(), produto.getDataFabricacao(),
                    produto.getDataValidade(), produto.getSituacao(), fornecedor);
        };

        Converter<Fornecedor, FornecedorData> fornecedorToORM = ctx -> {
            var fornecedor = ctx.getSource();
            var fornecedorData = new FornecedorData(fornecedor.getCodigo(), null, null, null,
                    null);

            var produtosData = fornecedor.getProdutos().stream()
                    .map(produto -> new ProdutoData(produto.getCodigo(), produto.getDescricao(),
                            produto.getDataFabricacao(), produto.getDataValidade(), produto.getSituacao(), fornecedorData))
                    .toList();

            return new FornecedorData(fornecedor.getCodigo(), fornecedor.getDescricao(), fornecedor.getCnpj().getValor(),
                    fornecedor.getSituacao(), produtosData);
        };

        modelMapper.addConverter(produtoToORM);
        modelMapper.addConverter(fornecedorToORM);
    }

    private void mapORMToDomain(ModelMapper modelMapper) {
        Converter<ProdutoData, Produto> ormToProduto = ctx -> {
            var produtoData = ctx.getSource();

            var fornecedor = new Fornecedor(produtoData.getFornecedor().getCodigo(), null, null,
                    null, null);

            return new Produto(produtoData.getCodigo(), produtoData.getDescricao(), produtoData.getDataFabricacao(),
                    produtoData.getDataValidade(), fornecedor, produtoData.getSituacao());
        };

        Converter<FornecedorData, Fornecedor> ormToFornecedor = ctx -> {
            var fornecedorData = ctx.getSource();

            var fornecedor = new Fornecedor(fornecedorData.getCodigo(), null, null, null, null);
            var produtos = fornecedorData.getProdutos().stream()
                    .map(produto -> new Produto(produto.getCodigo(), produto.getDescricao(),
                            produto.getDataFabricacao(), produto.getDataValidade(), fornecedor, produto.getSituacao()))
                    .toList();
            var cnpj = new CNPJ(validadorCNPJ, fornecedorData.getCpnj());

            return new Fornecedor(fornecedorData.getCodigo(), fornecedorData.getDescricao(), cnpj, produtos, fornecedorData.getSituacao());
        };

        modelMapper.addConverter(ormToProduto);
        modelMapper.addConverter(ormToFornecedor);
    }
}
