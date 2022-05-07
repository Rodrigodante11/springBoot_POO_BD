package br.inatel.sd.labjpa;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.sd.labjpa.entity.Fornecedor;
import br.inatel.sd.labjpa.entity.NotaCompra;
import br.inatel.sd.labjpa.entity.Produto;
import br.inatel.sd.labjpa.service.FornecedorService;
import br.inatel.sd.labjpa.service.NotaCompraService;
import br.inatel.sd.labjpa.service.ProdutoService;

@SpringBootTest
class DataLoader {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@Autowired
	private NotaCompraService notaCompraService;


	@Test
	void contextLoads() {
		
		Produto p1= new Produto("Furadeira");
		Produto p2= new Produto("Serra Circular");
		Produto p3= new Produto("Lixadeira");
		Produto p4= new Produto("Plateia");
		Produto p5= new Produto("Tupia");
		
		p1 = produtoService.salvar(p1);
		p2 = produtoService.salvar(p2);
		p3 = produtoService.salvar(p3);
		p4 = produtoService.salvar(p4);
		p5 = produtoService.salvar(p5);
		
		produtoService.listar().forEach(System.out::println);
		
		//2.fornecedor
		Fornecedor f1 = new Fornecedor("Gasômetro Madeiras");
		f1.getEndereco().setEnderecoRua("Avenida Pinto Cobra");
		f1.getEndereco().setEnderecoNumero("110");
		f1.getEndereco().setEnderecoBairro("Vila Mariana");
		f1.getEndereco().setEnderecoCidade("Pouso Alegre");
		f1.getEndereco().setEnderecoUF("MG");
		
		Fornecedor f2 = new Fornecedor("Loja do Mecânico");
		f2.getEndereco().setEnderecoRua("Av Reinaldo Chioca");
		f2.getEndereco().setEnderecoNumero("1922");
		f2.getEndereco().setEnderecoBairro("Parque Progresso");
		f2.getEndereco().setEnderecoCidade("Franca");
		f2.getEndereco().setEnderecoUF("SP");
		f1 = fornecedorService.salvar( f1 );
		f2 = fornecedorService.salvar( f2 );
		List<Fornecedor> listaFornecedor = fornecedorService.listar();
		listaFornecedor.forEach( System.out::println );
		
		//3.Nota Compra
		NotaCompra nc1 = new NotaCompra( LocalDate.of(2021, 1, 15), f1);
		nc1 = notaCompraService.salvar(nc1);
		NotaCompra nc2 = new NotaCompra( LocalDate.of(2022, 2, 20), f2);
		nc2 = notaCompraService.salvar(nc2);
		notaCompraService.listarNotaCompra().forEach( System.out::println );
	}
	
	

}	
