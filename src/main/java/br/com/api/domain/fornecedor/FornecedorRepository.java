package br.com.api.domain.fornecedor;

public interface FornecedorRepository<T, V> {
    Fornecedor buscar(Long id);

    T listar(V dadosPaginacao);

    Fornecedor cadastrar(Fornecedor supplier);

    Fornecedor alterar(Fornecedor supplier);

    void remover(Long id);
}
