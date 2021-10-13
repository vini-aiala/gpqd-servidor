package br.com.gpqd.petshop.model.form;

import br.com.gpqd.petshop.model.Cliente;
import br.com.gpqd.petshop.model.Funcionario;
import br.com.gpqd.petshop.model.Pedido;
import br.com.gpqd.petshop.model.Produto;
import br.com.gpqd.petshop.repository.ClienteRepository;
import br.com.gpqd.petshop.repository.FuncionarioRepository;
import br.com.gpqd.petshop.repository.ProdutoRepository;

import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

public class PedidoForm {
    private List<Long> produtosId;
    private Long clienteId;
    private Long funcionarioId;

    public Pedido build(ClienteRepository clienteRepository, FuncionarioRepository funcionarioRepository, ProdutoRepository produtoRepository) {
        List<Produto> produtos = produtoRepository.findAllById(produtosId);
        Cliente cliente = clienteRepository.getById(clienteId);
        Funcionario funcionario = funcionarioRepository.getById(funcionarioId);
        return new Pedido(produtos, cliente, funcionario);
    }

    public List<Long> getProdutosId() {
        return produtosId;
    }

    public void setProdutosId(List<Long> produtosId) {
        this.produtosId = produtosId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }
}
