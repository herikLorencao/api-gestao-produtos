package br.com.api.infra.database.jpa;

import br.com.api.domain.Situacao;
import br.com.api.infra.database.orm.FornecedorData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorDataRepository extends PagingAndSortingRepository<FornecedorData, Long> {
    Page<FornecedorData> findAllBySituacao(Situacao situacao, Pageable pageInfo);
}
