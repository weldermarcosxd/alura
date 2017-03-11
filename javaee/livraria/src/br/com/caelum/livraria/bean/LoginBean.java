package br.com.caelum.livraria.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.caelum.livraria.dao.UsuarioDAO;
import br.com.caelum.livraria.modelo.Usuario;

@ManagedBean
@ViewScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario(){
		return this.usuario;
	}

	public String autenticar() {
		Boolean retorno = new UsuarioDAO().autenticar(this.usuario);
		if(retorno){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
            .put("usuarioLogado", this.usuario);
			return "livro?faces-redirect=true";
		}else{
			FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Credenciais Inválidas"));
			return "login?faces-redirect=true";
		}
	}
	
	public String logout (){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
        .remove("usuarioLogado");
		return "livro?faces-redirect=true";
	}

}