/**
 * 
 */
package perso.dakeyras.ynov.client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author sebboursier
 *
 */
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager.getLogger(Login.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.trace("##### LOGIN - GET- Start");
		req.setAttribute("page", "Login");
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/common/Layout.jsp").forward(req, resp);
		LOG.trace("##### LOGIN - GET- Start");
	}
}
