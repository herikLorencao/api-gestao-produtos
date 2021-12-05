package br.com.api.domain.produto;

import java.util.List;

public interface ProdutoService {
    Produto buscar(Long codigo);

    List<Produto> listarAtivos();

    Produto cadastrar(Produto produto);

    Produto alterar(Produto produto);

    void remover(Long codigo);
}
