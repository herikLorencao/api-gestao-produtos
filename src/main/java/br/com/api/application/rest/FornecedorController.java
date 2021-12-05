package br.com.api.application.rest;

import br.com.api.application.requests.FornecedorRequest;
import br.com.api.application.responses.FornecedorResponse;
import br.com.api.domain.fornecedor.Fornecedor;
import br.com.api.domain.fornecedor.FornecedorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    private final FornecedorService<Page<Fornecedor>, Pageable> service;
    private final ModelMapper modelMapper;

    @Autowired
    public FornecedorController(FornecedorService<Page<Fornecedor>, Pageable> service, ModelMapper modelMapper) {
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorResponse> buscar(@PathVariable Long id) {
        var fornecedor = service.buscar(id);
        var response = modelMapper.map(fornecedor, FornecedorResponse.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public Page<FornecedorResponse> listar(Pageable pageInfo) {
        var paginaFornecedores = service.listar(pageInfo);
        var responses = paginaFornecedores.getContent().stream()
                .map(fornecedor -> modelMapper.map(fornecedor, FornecedorResponse.class)).toList();
        return new PageImpl<>(responses, pageInfo, paginaFornecedores.getTotalElements());
    }

    @PostMapping
    public ResponseEntity<FornecedorResponse> cadastrar(
            @Valid @RequestBody FornecedorRequest fornecedorRequest,
            UriComponentsBuilder uriBuilder
    ) {
        var fornecedor = modelMapper.map(fornecedorRequest, Fornecedor.class);
        var fornecedorCadastrado = service.cadastrar(fornecedor);
        var uri = uriBuilder.path("/fornecedores/{id}").buildAndExpand(fornecedor.getCodigo()).toUri();
        return ResponseEntity.created(uri).body(modelMapper.map(fornecedorCadastrado, FornecedorResponse.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FornecedorResponse> alterar(
            @PathVariable Long id,
            @Valid @RequestBody FornecedorRequest fornecedorRequest
    ) {
        var fornecedor = modelMapper.map(fornecedorRequest, Fornecedor.class);
        fornecedor = service.alterar(fornecedor);
        var response = modelMapper.map(fornecedor, FornecedorResponse.class);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FornecedorResponse> remover(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
