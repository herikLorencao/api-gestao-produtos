package br.com.api.domain.produto;

public interface ProdutoService<T, V> {
    Produto buscar(Long codigo);

    T listar(V parametros);

    Produto cadastrar(Produto produto);

    Produto alterar(Produto produto);

    void remover(Long codigo);
}
