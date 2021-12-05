package br.com.api.domain.fornecedor;

public interface FornecedorRepository<T, V> {
    Fornecedor buscar(Long id);

    T listar(V dadosPaginacao);

    Fornecedor cadastrar(Fornecedor fornecedor);

    Fornecedor alterar(Fornecedor fornecedor);

    void remover(Long id);
}
