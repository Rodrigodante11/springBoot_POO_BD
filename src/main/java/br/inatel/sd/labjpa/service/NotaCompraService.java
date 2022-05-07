package br.inatel.sd.labjpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.sd.labjpa.entity.NotaCompra;
import br.inatel.sd.labjpa.entity.NotaCompraItem;

@Service
@Transactional
public class NotaCompraService {
	
	@PersistenceContext
	private EntityManager em;
	
	// nota compra
	public NotaCompra buscarNotaCompraPeloId(Long id) {
		return em.find(NotaCompra.class, id);
	}
	
	public NotaCompra salvar(NotaCompra nota) {
		return em.merge(nota);
		
	}
	
	public List<NotaCompra> listarNotaCompra(){
		return em.createQuery("select n from NotaCompra n", NotaCompra.class).getResultList();
	}
	
	// nota compra item
	
	public NotaCompraItem salvar(NotaCompraItem item) {
		return em.merge(item);
	}
	
	public NotaCompraItem buscaNotaCompraItemPeloId(Long id) {
		return em.find(NotaCompraItem.class, id);
	}
	
	public List<NotaCompraItem> listarNotaCompraItem(){
		return em.createQuery(" select i from NotaCompraItem i", NotaCompraItem.class).getResultList();
	}
}
