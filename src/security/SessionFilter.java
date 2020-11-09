package security;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.impl.Log4JLogger;

public class SessionFilter implements Filter {
	private FilterConfig filterConfig;
	public final Log4JLogger logger = new Log4JLogger(this.getClass().getName());

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) {
		logger.info(" filter start ");
		HttpSession session ;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		try {
			session = req.getSession();
			logger.info(" session " + session);

			if (session == null) {
				res.sendRedirect("timeout.xhtml"); // If the Active session is
									// null ,we redirect to the
													// timeout.jsp
			}
			chain.doFilter(request, response);
		} catch (IOException io) {
			System.out.println(" io .getMessge "+ io.getMessage());
		} catch (ServletException se) {
			System.out.println(" se .getMessge "+ se.getMessage());
		}
		logger.info(" filter end ");

	}

	public FilterConfig getFilterConfig() {
		return this.filterConfig;
	}

	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}