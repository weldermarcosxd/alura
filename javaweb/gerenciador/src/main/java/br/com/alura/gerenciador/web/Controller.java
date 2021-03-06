package br.com.alura.gerenciador.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/controller")
public class Controller extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -978447868820583041L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String className = req.getParameter("class");
		if(null == className){
			throw new IllegalArgumentException("Nenhum ação classe passada ao router");
		}
		
		className = "br.com.alura.gerenciador.web." + className;
		
		try {
			Class classe = Class.forName(className);
			Tarefa tarefa = (Tarefa) classe.newInstance();
			String pagina = tarefa.executa(req, resp);	
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/templates" + pagina);
			requestDispatcher.forward(req, resp);
		} catch (ClassNotFoundException e) {
			System.out.println("Erro ao encontradar a classe no router");
			e.printStackTrace();
		} catch (InstantiationException e) {
			System.out.println("Erro ao instanciar a classe do router");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println("Erro ao acessar a classe do router");
			e.printStackTrace();
		}		
	}
}
