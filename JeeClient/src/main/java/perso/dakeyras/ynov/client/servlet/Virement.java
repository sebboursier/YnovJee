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

/**
 * @author sebboursier
 *
 */
public class Virement extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = LogManager.getLogger(Virement.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.trace("##### VIREMENT - GET- Start");
		req.setAttribute("comptes", BouchonUtils.getClient().getComptes());
		req.setAttribute("page", "Virement");
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/common/Layout.jsp").forward(req, resp);
		LOG.trace("##### VIREMENT - GET- End");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.trace("##### VIREMENT - POST- Start");
		final Double montant = Double.parseDouble(req.getParameter("montant"));
		final Long emetteur = Long.parseLong(req.getParameter("emetteur"));
		final Long recepteur = Long.parseLong(req.getParameter("recepteur"));
		String error = null;
		if (emetteur.equals(recepteur)) {
			LOG.error("## VIREMENT - erreur metier - same compte");
			error = "Vous ne pouvez pas utiliser le même compte en tant qu'émetteur et récepteur.";
		}
		req.setAttribute("response", true);
		req.setAttribute("error", error);
		req.setAttribute("comptes", BouchonUtils.getClient().getComptes());
		req.setAttribute("page", "Virement");
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/common/Layout.jsp").forward(req, resp);
		LOG.trace("##### VIREMENT - POST- End");
	}
}
