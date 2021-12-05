package br.com.api.domain.produto;

public interface ProdutoService<T, V> {
    Produto buscar(Long codigo);

    T listarAtivos(V dadosPaginacao);

    Produto cadastrar(Produto produto);

    Produto alterar(Produto produto);

    void remover(Long codigo);
}
