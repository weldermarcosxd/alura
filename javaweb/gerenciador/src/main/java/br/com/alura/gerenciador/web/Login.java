package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

public class Login implements Tarefa{
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

		if (null == usuario) {
			return "/falhaLogin.html";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogado", usuario);
			request.setAttribute("usuario", usuario);
			return "/login.jsp";
		}
	}
}