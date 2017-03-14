package br.com.caelum.livraria.modelo;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.livraria.dao.LivroDAO;

public class LivroDataModel extends LazyDataModel<Livro>{
	
	private static final long serialVersionUID = -1124086823970414164L;
	
	@Inject
	private LivroDAO livroDAO;
	
	private String genero;
	
	public LivroDataModel() {
	    super.setRowCount(livroDAO.quantidadeDeElementos());
	}
	
	@Override
	public List<Livro> load(int inicio, int quantidade, String campoOrdenacao, SortOrder sentidoOrdenacao, Map<String, Object> filtros) {
	    return livroDAO.listaTodosPaginada(inicio, quantidade, filtros);
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}
