package br.com.api.application.rest;

import br.com.api.application.requests.ProdutoRequest;
import br.com.api.application.responses.ProdutoResponse;
import br.com.api.domain.produto.Produto;
import br.com.api.domain.produto.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService<Page<Produto>, Pageable> service;
    private final ModelMapper modelMapper;

    @Autowired
    public ProdutoController(ProdutoService<Page<Produto>, Pageable> service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscar(@PathVariable Long id) {
        var produto = service.buscar(id);
        var response = modelMapper.map(produto, ProdutoResponse.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public Page<ProdutoResponse> listar(@PageableDefault Pageable pageInfo) {
        var paginaProdutos = service.listar(pageInfo);
        var responses = paginaProdutos.getContent().stream()
                .map(produto -> modelMapper.map(produto, ProdutoResponse.class)).toList();
        return new PageImpl<>(responses, pageInfo, paginaProdutos.getTotalElements());
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> cadastrar(
            @Valid @RequestBody ProdutoRequest produtoRequest,
            UriComponentsBuilder uriBuilder
    ) {
        var produto = modelMapper.map(produtoRequest, Produto.class);
        var produtoCadastrado = service.cadastrar(produto);
        var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(modelMapper.map(produtoCadastrado, ProdutoResponse.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> alterar(
            @PathVariable Long id,
            @Valid @RequestBody ProdutoRequest produtoRequest
    ) {
        produtoRequest.setCodigo(id);
        var produto = modelMapper.map(produtoRequest, Produto.class);
        produto = service.alterar(produto);
        var response = modelMapper.map(produto, ProdutoResponse.class);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoResponse> remover(@PathVariable Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }
}
