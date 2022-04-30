package br.inatel.sd.labjpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class NotaCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy ="notaCompra") // one to many eh sempre o lado fraco do relacionamento por isso o mapped 
	private List<NotaCompraItem>listaNotaCompraItem;
	
	@NotNull
	@ManyToOne // '...toOne' vai vira FK na tabela do BD
	private Fornecedor fornecedor;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<NotaCompraItem> getListaNotaCompraItem() {
		return listaNotaCompraItem;
	}

	public void setListaNotaCompraItem(List<NotaCompraItem> listaNotaCompraItem) {
		this.listaNotaCompraItem = listaNotaCompraItem;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	@NotNull
	private LocalDate dataEmissao; 
	
	public BigDecimal getCalculoTotalNota() {
//		BigDecimal total =  BigDecimal.ZERO;
//		
//		for( NotaCompraItem item: listaNotaCompraItem) {
//			total= total.add(item.getCalculoTotalItem());
//		}
//		
//		return total;
		
		
//		return listaNotaCompraItem.stream().
//		map(i -> i.getCalculoTotalItem())
//		.reduce(BigDecimal.ZERO, BigDecimal::add);  // somando todos elementos da lista mesma coisa comentada acima(labda)
		
		return listaNotaCompraItem.stream().
				map( NotaCompraItem::getCalculoTotalItem) // para cada elementoda classe NotaCompraItem pega o metodo(metodo reference)
				.reduce(BigDecimal.ZERO, BigDecimal::add);  // somando todos elementos da lista mesma coisa comentada acima
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaCompra other = (NotaCompra) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "NotaCompra [id=" + id + ", dataEmissao=" + dataEmissao + "]";
	}
	
	
	
}
