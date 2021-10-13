package br.com.gpqd.petshop.controller;

import br.com.gpqd.petshop.controller.form.PedidoForm;
import br.com.gpqd.petshop.model.Pedido;
import br.com.gpqd.petshop.repository.ClienteRepository;
import br.com.gpqd.petshop.repository.FuncionarioRepository;
import br.com.gpqd.petshop.repository.PedidoRepository;
import br.com.gpqd.petshop.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoController(
            PedidoRepository pedidoRepository,
            ClienteRepository clienteRepository,
            FuncionarioRepository funcionarioRepository,
            ProdutoRepository produtoRepository
    ) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public List<Pedido> recoverPedido() {
        return pedidoRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Pedido getById(@PathVariable String id) {
        Optional<Pedido> optional = pedidoRepository.findById(Long.parseLong(id));
        return optional.orElse(null);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Pedido> createPedidos(PedidoForm form, UriComponentsBuilder uriBuilder) {
        Pedido pedido = form.build(clienteRepository, funcionarioRepository, produtoRepository);
        pedidoRepository.save(pedido);

        URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(pedido);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Pedido> update(@PathVariable Long id, @RequestBody PedidoForm form) {
        Optional<Pedido> optional = pedidoRepository.findById(id);
        if (optional.isPresent()) {
            Pedido pedido = form.update(id, clienteRepository, funcionarioRepository, produtoRepository, pedidoRepository);
            return ResponseEntity.ok(pedido);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Pedido> optional = pedidoRepository.findById(id);
        if (optional.isPresent()) {
            pedidoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
