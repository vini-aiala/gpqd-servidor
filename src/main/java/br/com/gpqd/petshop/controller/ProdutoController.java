package br.com.gpqd.petshop.controller;

import br.com.gpqd.petshop.controller.form.ProdutoForm;
import br.com.gpqd.petshop.model.Produto;
import br.com.gpqd.petshop.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final ProdutoRepository produtoRepository;

    public ProdutoController(
            ProdutoRepository produtoRepository
    ) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public List<Produto> recoverProduto() {
        return produtoRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Produto getById(@PathVariable String id) {
        Optional<Produto> optional = produtoRepository.findById(Long.parseLong(id));
        return optional.orElse(null);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Produto> createProdutos(ProdutoForm form, UriComponentsBuilder uriBuilder) {
        Produto produto = form.build();
        produtoRepository.save(produto);

        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody ProdutoForm form) {
        Optional<Produto> optional = produtoRepository.findById(id);
        if (optional.isPresent()) {
            Produto produto = form.update(id, produtoRepository);
            return ResponseEntity.ok(produto);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Produto> optional = produtoRepository.findById(id);
        if (optional.isPresent()) {
            produtoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
