/**
 * 
 */
package perso.dakeyras.ynov.client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sebboursier
 *
 */
public class Credit extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("page", "Credit");
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/common/Layout.jsp").forward(req, resp);
	}
}
