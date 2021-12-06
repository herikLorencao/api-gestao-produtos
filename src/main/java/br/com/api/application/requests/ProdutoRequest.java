package br.com.api.application.requests;

import br.com.api.domain.Situacao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class ProdutoRequest {
    private Long codigo;
    @NotNull
    @NotBlank
    private String descricao;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;
    private Long codigoFornecedor;
    private final Situacao situacao = Situacao.ATIVO;

    public ProdutoRequest() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public Long getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public Situacao getSituacao() {
        return situacao;
    }
}
