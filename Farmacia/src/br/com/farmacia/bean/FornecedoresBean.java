package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import com.sun.media.sound.SoftMixingSourceDataLine;

import br.com.farmacia.dao.FornecedoresDao;
import br.com.farmacia.domain.Fornecedores;

@ManagedBean(name = "MBFornecedores") // referencia para ser utilizado no xhtml
@ViewScoped
public class FornecedoresBean {

	private ListDataModel<Fornecedores> itens;

	public ListDataModel<Fornecedores> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Fornecedores> itens) {
		this.itens = itens;
	}

//	pegar o pesquisa dao, pegando o metodo listar
	
	//@PostConstruct = Após a pagina for contruida ele vi executar

	@PostConstruct
public void preparaPesquisa(){
	
	
	try {
		FornecedoresDao dao = new FornecedoresDao();
		ArrayList<Fornecedores> arrayListFornecedores = dao.listar();
		itens = new ListDataModel<>(arrayListFornecedores);
	} catch (SQLException e) {
			e.printStackTrace();
	}
	
	
}
	
	
	
	private Fornecedores fornecedores;

	public Fornecedores getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedores fornecedores) {
		this.fornecedores = fornecedores;
	}
	
//	somente para carragar a instancia do fornecedores
	public void prepararNovo(){
		
		fornecedores  = new Fornecedores();
	}
	
	public void novo(){
		try {
			FornecedoresDao dao = new FornecedoresDao();
			dao.Salvar(fornecedores);
			System.out.println("Salvo com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro ao executar o Salvar");
			e.printStackTrace();
		}
	}

}
