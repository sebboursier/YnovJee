package perso.dakeyras.ynov.client.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import perso.dakeyras.ynov.client.util.BouchonUtils;

/**
 * @author sebboursier
 *
 */
public class Home extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager.getLogger(Home.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.trace("##### HOME - GET- Start");
		req.setAttribute("page", "Home");
		req.setAttribute("client", BouchonUtils.getClient());
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/common/Layout.jsp").forward(req, resp);
		LOG.trace("##### HOME - GET- End");
	}
}
