/**
 * Essa classe e reponsavel por fazer a comunicação das tabelas do banco de dados com o projeto.
 * @author kayo
 */
package br.com.farmacia.domain;

/**
 * 
 *
 */
public class Fornecedores {

	private Long idfornecedores;
	private String descricao;
	private String email;
	private String telefone;
	private String CNPJ;

	public Long getIdfornecedores() {
		return idfornecedores;
	}

	public void setIdfornecedores(Long idfornecedores) {
		this.idfornecedores = idfornecedores;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	@Override
	public String toString() {
		return "Fornecedores [idfornecedores=" + idfornecedores + ", descricao=" + descricao + ", email=" + email
				+ ", telefone=" + telefone + ", CNPJ=" + CNPJ + "]";
	}

//	@Override
//	public String toString() {
//		String saida = "\nCodigo do fornecedor:" + idfornecedores + "\nDescrição:" + descricao;
//		return saida;
//	}

}
