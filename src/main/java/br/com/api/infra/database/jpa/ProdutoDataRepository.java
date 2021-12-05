package br.com.api.infra.database.jpa;

import br.com.api.domain.Situacao;
import br.com.api.infra.database.orm.ProdutoData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoDataRepository extends PagingAndSortingRepository<ProdutoData, Long> {
    Page<ProdutoData> findAllBySituacao(Situacao situacao, Pageable pageInfo);
}
