package br.inatel.sd.labjpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.sd.labjpa.entity.Produto;

@Service
@Transactional //abre envoca o metodo e fecha( pra nao deixa aberto)
public class ProdutoService {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public Produto salvar(Produto p) {
		p = em.merge(p); // o merge serve para salvar e atualizar 
		return p;
	}
	
	public Produto buscarPeloId(Long id) {
		return em.find(Produto.class, id);
	}
	
	public List<Produto> listar(){
		String javapersistenceQuerryLanguage =  "SELECT p FROM produto p"; // select pois quero o objeto p 
		List<Produto> resultList = em.createQuery(javapersistenceQuerryLanguage, Produto.class).getResultList();
		
		return resultList;
	}
	
	public void remover(Produto p) {
		p = em.merge(p);
		em.remove(p);
	}
}
