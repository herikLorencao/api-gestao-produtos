package br.com.api.domain.produto;

public class DatasInvalidas extends RuntimeException {
    public DatasInvalidas(Produto produto) {
        super("A data de fabricação do produto " + produto.getDescricao() + " não pode ser menor ou igual a data de validade");
    }
}
