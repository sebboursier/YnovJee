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

import perso.dakeyras.ynov.client.util.BouchonUtils;
import perso.dakeyras.ynov.model.Transaction;

/**
 * @author sebboursier
 *
 */
public class Credit extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager.getLogger(Credit.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.trace("##### CREDIT - GET- Start");

		req.setAttribute("comptes", BouchonUtils.getClient().getComptes());

		req.setAttribute("page", "Credit");
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/common/Layout.jsp").forward(req, resp);
		LOG.trace("##### CREDIT - GET- End");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.trace("##### CREDIT - POST - Start");

		final Long compte = Long.parseLong(req.getParameter("compte"));
		final Transaction transaction = new Transaction();
		transaction.setLibelle(req.getParameter("libelle"));
		transaction.setMontant(Double.parseDouble(req.getParameter("montant")));

		req.setAttribute("response", true);

		req.setAttribute("comptes", BouchonUtils.getClient().getComptes());

		req.setAttribute("page", "Credit");
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/common/Layout.jsp").forward(req, resp);
		LOG.trace("##### CREDIT - POST - End");
	}
}
