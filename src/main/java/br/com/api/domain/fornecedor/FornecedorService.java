package br.com.api.domain.fornecedor;

import java.util.List;

public interface FornecedorService {
    Fornecedor buscar(Long id);

    List<Fornecedor> listar();

    Fornecedor cadastrar(Fornecedor supplier);

    Fornecedor alterar(Fornecedor supplier);

    void remover(Long id);
}
