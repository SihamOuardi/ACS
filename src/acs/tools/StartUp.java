package acs.tools;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.impl.Log4JLogger;



public class StartUp extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1378803924021989893L;
	public static Log4JLogger logger = new Log4JLogger(StartUp.class.toString());

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/**
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	**/

	/**
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	**/

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			/**
			ServletContext context = getServletConfig().getServletContext();
			GlobalVars.DB_PARAMS_FILE = context.getInitParameter("DB_PARAMS_FILE");
			**/
			// GlobalVars.DB_PARAMS_FILE = getServletContext().getInitParameter("DB_PARAMS_FILE");
			// GlobalVars.DB_PARAMS_FILE = "C:\\m\\Bits\\Clients\\RoyalBank\\Dev\\workspace_IB\\EPS_MB_SRV\\src\\eps\\config\\dbParams.xml";
			// GlobalVars.DB_PARAMS_FILE = "/JBOSS/wildfly-8.2.0.Final/standalone/deployments/EPS_MB_SRV.war/WEB-INF/classes/eps/config/dbParams.xml";
/*
			logger.info("init() getRealPath=["+getServletConfig().getServletContext().getRealPath("/")+"]");
			logger.info("init() getContextPath=["+getServletConfig().getServletContext().getContextPath()+"]");
			GlobalVars.DB_PARAMS_FILE = getServletConfig().getServletContext().getRealPath("/")+"/WEB-INF/classes/dbParams.xml";
			//GlobalVars.EPS_DB_PARAMS_FILE = getServletConfig().getServletContext().getRealPath("/")+"/WEB-INF/classes/EPSdbParams.xml";
			
			ApplicationInit.InitDataBase();*/
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String [] Args ) {
		System.out.println("testtt ");
		
		return ;
	 
	}
}
