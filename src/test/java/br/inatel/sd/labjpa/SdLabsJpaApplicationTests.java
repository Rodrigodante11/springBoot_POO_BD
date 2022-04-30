package br.inatel.sd.labjpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.sd.labjpa.entity.Produto;
import br.inatel.sd.labjpa.service.ProdutoService;

@SpringBootTest
class SdLabsJpaApplicationTests {
	
	@Autowired
	private ProdutoService produtoService;

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
		
		produtoService.listar().forEach(System.out::println);;
	}

}
