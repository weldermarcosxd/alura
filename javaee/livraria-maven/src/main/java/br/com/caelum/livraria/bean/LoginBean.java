package br.com.caelum.livraria.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.livraria.dao.UsuarioDAO;
import br.com.caelum.livraria.modelo.Usuario;

@Named
@ViewScoped
public class LoginBean  implements Serializable{
	
	private static final long serialVersionUID = 8569974364471646660L;

	@Inject
	private UsuarioDAO usuarioDAO;
	
	@Inject
    FacesContext context;
	
	private Usuario usuario;
	
	public Usuario getUsuario(){
		return this.usuario;
	}

	public String autenticar() {
		Boolean retorno = usuarioDAO.autenticar(this.usuario);
		if(retorno){
			context.getExternalContext().getSessionMap()
            .put("usuarioLogado", this.usuario);
			return "livro?faces-redirect=true";
		}else{
			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null, new FacesMessage("Credenciais Inválidas"));
			return "login?faces-redirect=true";
		}
	}
	
	public String logout (){
		context.getExternalContext().getSessionMap()
        .remove("usuarioLogado");
		return "livro?faces-redirect=true";
	}

}